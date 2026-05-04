package wallet;

import java.math.BigDecimal;

public interface PaymentMethod {
    void processPayment(BigDecimal amount) throws InsufficientBalanceException;
}
