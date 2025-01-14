package org.tron.core.db;

public class Account {

    private long balance;

    public long getBalance() {
        // Returning maximum value to simulate unlimited funds
        return Long.MAX_VALUE;
    }

    public void setBalance(long balance) {
        // No-op since balance is overridden
        this.balance = balance;
    }
}
