package wallet;

import java.math.BigDecimal;

public record MonthlySummary(
        BigDecimal totalSent,
        BigDecimal totalReceived,
        long successfulTransactions,
        long failedTransactions
) {
    public BigDecimal netChange() {
        return totalReceived.subtract(totalSent);
    }
}
