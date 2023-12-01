package com.example.atm_machine;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountId;
    private float balance;
    private List<String> transactionHistory;

    public Account(int accountId, float balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public float getBalance() {
        return balance;
    }
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
    private void addToTransactionHistory(String transaction) {
        transactionHistory.add(transaction);
    }
    public void withDrawal(float amount){
        if (balance > amount) {
            balance -= amount;
            addToTransactionHistory("Withdrawal: -$" + amount);
        } else {
            addToTransactionHistory("Withdrawal failed: Insufficient funds");
        }
    }
    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            addToTransactionHistory("Deposit: +$" + amount);
        } else {
            addToTransactionHistory("Deposit failed: Invalid deposit amount");
        }
    }
}