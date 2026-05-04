package wallet;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    public boolean register(String name, String upiId, String password, BigDecimal openingBalance) {
        validateRegistrationInput(name, upiId, password, openingBalance);

        String sql = "INSERT INTO users(name, upi_id, password, balance) VALUES (?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name.trim());
            ps.setString(2, upiId.trim());
            ps.setString(3, password);
            ps.setBigDecimal(4, openingBalance);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

    public User login(String upiId, String password) {
        String sql = "SELECT id, name, upi_id, balance FROM users WHERE upi_id = ? AND password = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, upiId);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setUpiId(rs.getString("upi_id"));
                    user.setBalance(rs.getBigDecimal("balance"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return null;
    }

    private void validateRegistrationInput(String name, String upiId, String password, BigDecimal openingBalance) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (upiId == null || upiId.isBlank() || !upiId.contains("@")) {
            throw new IllegalArgumentException("A valid UPI ID is required.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required.");
        }
        if (openingBalance == null || openingBalance.signum() < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }
    }
}
