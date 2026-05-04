package wallet;

import java.math.BigDecimal;

public class BankTransfer implements PaymentMethod {
    @Override
    public void processPayment(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        System.out.println("Bank transfer processed for amount: " + amount);
    }
}
