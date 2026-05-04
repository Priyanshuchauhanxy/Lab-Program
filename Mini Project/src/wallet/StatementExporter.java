package wallet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StatementExporter {
    private final WalletService walletService = new WalletService();

    public void exportToTxt(int userId, String filePath) {
        List<TransactionRecord> records = walletService.getTransactionHistory(userId);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (TransactionRecord record : records) {
                writer.write(record.toDisplayString());
                writer.newLine();
            }
            System.out.println("Statement exported successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    public void exportToCsv(int userId, String filePath) {
        List<TransactionRecord> records = walletService.getTransactionHistory(userId);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("id,sender_id,receiver_id,amount,status,remarks,created_at");
            writer.newLine();
            for (TransactionRecord record : records) {
                writer.write(csv(record.id()));
                writer.write(",");
                writer.write(csv(record.senderId()));
                writer.write(",");
                writer.write(csv(record.receiverId()));
                writer.write(",");
                writer.write(csv(record.amount()));
                writer.write(",");
                writer.write(csv(record.status()));
                writer.write(",");
                writer.write(csv(record.remarks()));
                writer.write(",");
                writer.write(csv(record.createdAt()));
                writer.newLine();
            }
            System.out.println("CSV exported successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("CSV export failed: " + e.getMessage());
        }
    }

    private String csv(Object value) {
        String text = value == null ? "" : value.toString();
        return "\"" + text.replace("\"", "\"\"") + "\"";
    }
}
