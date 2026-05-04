package wallet;

import java.math.BigDecimal;

public class WalletBalance implements PaymentMethod {
    private final User user;

    public WalletBalance(User user) {
        this.user = user;
    }

    @Override
    public void processPayment(BigDecimal amount) throws InsufficientBalanceException {
        validateAmount(amount);
        if (user.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient wallet balance.");
        }
        user.setBalance(user.getBalance().subtract(amount));
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }
}
