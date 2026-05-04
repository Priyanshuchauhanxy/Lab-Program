package wallet;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record TransactionRecord(
        int id,
        Integer senderId,
        Integer receiverId,
        BigDecimal amount,
        String status,
        String remarks,
        Timestamp createdAt
) {
    public String toDisplayString() {
        return String.format(
                "TxnId=%d, sender=%s, receiver=%s, amount=%s, status=%s, remarks=%s, time=%s",
                id,
                senderId == null ? "-" : senderId,
                receiverId == null ? "-" : receiverId,
                amount,
                status,
                remarks == null ? "-" : remarks,
                createdAt
        );
    }
}
