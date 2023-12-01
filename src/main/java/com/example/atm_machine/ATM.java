package com.example.atm_machine;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ATM {

    private static ATM INSTANCE;

    public static ATM getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ATM();
        }
        return INSTANCE;
    }

    private Map<Integer, Account> accounts;

    private ATM(){
        accounts = new HashMap<>();
        Account account1 = new Account(1111, 1000);
        Account account2 = new Account(2222, 2000);
        accounts.put(account1.getAccountId(),account1);
        accounts.put(account2.getAccountId(),account2);
    }

    public boolean isAccountValid(int accountId){
        Account account = accounts.get(accountId);
        if(account == null){
            return false;
        }else{
            return true;
        }
    }

    public float showBalance(int accountId){
        Account account = accounts.get(accountId);
        if(account != null){
            return account.getBalance();
        }else{
            throw new IllegalArgumentException("Account not found: " + accountId);
        }
    }
    public List<String> getTransactionHistory(int accountId) {
        Account account = accounts.get(accountId);
        if (account != null) {
            return account.getTransactionHistory();
        } else {
            throw new IllegalArgumentException("Account not found: " + accountId);
        }
    }
    public void withDraw(int accountId, float amount){
        Account account = accounts.get(accountId);
        if(account != null){
            account.withDrawal(amount);
        }
    }
    public void deposit(int accountId, float amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
        }
    }
}