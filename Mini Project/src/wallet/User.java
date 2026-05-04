package wallet;

import java.math.BigDecimal;

public class User {
    private int id;
    private String name;
    private String upiId;
    private BigDecimal balance;

    public User() {
        this.balance = BigDecimal.ZERO;
    }

    public User(String name, String upiId) {
        this(name, upiId, BigDecimal.ZERO);
    }

    public User(String name, String upiId, BigDecimal balance) {
        this.name = name;
        this.upiId = upiId;
        setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (balance == null) {
            throw new IllegalArgumentException("Balance cannot be null.");
        }
        if (balance.signum() < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', upiId='" + upiId + "', balance=" + balance + "}";
    }
}
