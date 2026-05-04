package wallet;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WalletService {
    public boolean addMoney(int userId, BigDecimal amount) {
        validateAmount(amount);

        String updateBalance = "UPDATE users SET balance = balance + ? WHERE id = ?";
        String insertTxn = "INSERT INTO transactions(sender_id, receiver_id, amount, status, remarks) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement balancePs = con.prepareStatement(updateBalance);
                 PreparedStatement txnPs = con.prepareStatement(insertTxn)) {
                balancePs.setBigDecimal(1, amount);
                balancePs.setInt(2, userId);
                if (balancePs.executeUpdate() == 0) {
                    throw new IllegalArgumentException("User not found.");
                }

                txnPs.setNull(1, Types.INTEGER);
                txnPs.setInt(2, userId);
                txnPs.setBigDecimal(3, amount);
                txnPs.setString(4, "SUCCESS");
                txnPs.setString(5, "ADD_MONEY");
                txnPs.executeUpdate();

                con.commit();
                return true;
            } catch (Exception e) {
                con.rollback();
                System.out.println("Add money failed: " + e.getMessage());
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return false;
    }

    public void sendMoney(int senderId, int receiverId, BigDecimal amount) throws InsufficientBalanceException {
        if (senderId == receiverId) {
            throw new IllegalArgumentException("Sender and receiver must be different.");
        }
        validateAmount(amount);

        String findBalance = "SELECT balance FROM users WHERE id = ?";
        String debit = "UPDATE users SET balance = balance - ? WHERE id = ?";
        String credit = "UPDATE users SET balance = balance + ? WHERE id = ?";
        String insertTxn = "INSERT INTO transactions(sender_id, receiver_id, amount, status, remarks) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection()) {
            con.setAutoCommit(false);
            try {
                BigDecimal senderBalance = fetchBalance(con, findBalance, senderId, "Sender");
                fetchBalance(con, findBalance, receiverId, "Receiver");

                if (senderBalance.compareTo(amount) < 0) {
                    throw new InsufficientBalanceException("Insufficient balance.");
                }

                try (PreparedStatement debitPs = con.prepareStatement(debit);
                     PreparedStatement creditPs = con.prepareStatement(credit);
                     PreparedStatement txnPs = con.prepareStatement(insertTxn)) {
                    debitPs.setBigDecimal(1, amount);
                    debitPs.setInt(2, senderId);
                    debitPs.executeUpdate();

                    creditPs.setBigDecimal(1, amount);
                    creditPs.setInt(2, receiverId);
                    creditPs.executeUpdate();

                    txnPs.setInt(1, senderId);
                    txnPs.setInt(2, receiverId);
                    txnPs.setBigDecimal(3, amount);
                    txnPs.setString(4, "SUCCESS");
                    txnPs.setString(5, "SEND_MONEY");
                    txnPs.executeUpdate();
                }

                con.commit();
                System.out.println("Transfer successful.");
            } catch (Exception e) {
                con.rollback();
                logFailedTransfer(con, insertTxn, senderId, receiverId, amount, e.getMessage());
                if (e instanceof InsufficientBalanceException insufficientBalanceException) {
                    throw insufficientBalanceException;
                }
                throw new RuntimeException(e.getMessage(), e);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }

    public List<TransactionRecord> getTransactionHistory(int userId) {
        List<TransactionRecord> history = new ArrayList<>();
        String sql = """
                SELECT id, sender_id, receiver_id, amount, status, remarks, created_at
                FROM transactions
                WHERE sender_id = ? OR receiver_id = ?
                ORDER BY created_at DESC
                """;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    history.add(mapTransaction(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Could not fetch history: " + e.getMessage());
        }
        return history;
    }

    public MonthlySummary getMonthlySummary(int userId) {
        List<TransactionRecord> history = getTransactionHistory(userId);
        LocalDateTime startOfMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        BigDecimal totalSent = BigDecimal.ZERO;
        BigDecimal totalReceived = BigDecimal.ZERO;
        long successCount = 0;
        long failedCount = 0;

        for (TransactionRecord record : history) {
            Timestamp createdAt = record.createdAt();
            if (createdAt == null || createdAt.toLocalDateTime().isBefore(startOfMonth)) {
                continue;
            }

            if ("SUCCESS".equalsIgnoreCase(record.status())) {
                successCount++;
            } else if ("FAILED".equalsIgnoreCase(record.status())) {
                failedCount++;
            }

            if (Integer.valueOf(userId).equals(record.senderId()) && "SUCCESS".equalsIgnoreCase(record.status())) {
                totalSent = totalSent.add(record.amount());
            }
            if (Integer.valueOf(userId).equals(record.receiverId()) && "SUCCESS".equalsIgnoreCase(record.status())) {
                totalReceived = totalReceived.add(record.amount());
            }
        }

        return new MonthlySummary(totalSent, totalReceived, successCount, failedCount);
    }

    public BigDecimal getCurrentBalance(int userId) {
        String sql = "SELECT balance FROM users WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBigDecimal("balance");
                }
            }
        } catch (SQLException e) {
            System.out.println("Could not fetch balance: " + e.getMessage());
        }
        return BigDecimal.ZERO;
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }

    private BigDecimal fetchBalance(Connection con, String sql, int userId, String label) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new IllegalArgumentException(label + " not found.");
                }
                return rs.getBigDecimal("balance");
            }
        }
    }

    private void logFailedTransfer(Connection con, String sql, int senderId, int receiverId, BigDecimal amount, String remarks) {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setBigDecimal(3, amount);
            ps.setString(4, "FAILED");
            ps.setString(5, remarks);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException ignored) {
        }
    }

    private TransactionRecord mapTransaction(ResultSet rs) throws SQLException {
        Integer senderId = (Integer) rs.getObject("sender_id");
        Integer receiverId = (Integer) rs.getObject("receiver_id");
        return new TransactionRecord(
                rs.getInt("id"),
                senderId,
                receiverId,
                rs.getBigDecimal("amount"),
                rs.getString("status"),
                rs.getString("remarks"),
                rs.getTimestamp("created_at")
        );
    }
}
