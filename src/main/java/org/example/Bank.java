package org.example;

import java.util.HashMap;

public class Bank {
    private final HashMap<Integer, Integer> accounts = new HashMap<>();

    public synchronized void deposit(int acc_no, int amt) {
        updateBalance(acc_no, amt);
        System.out.println("Deposited $" + amt + " into account " + acc_no + ". New balance: $" + getBalance(acc_no));
    }

    public synchronized void withdraw(int acc_no, int amt) {
        int currentBalance = getBalance(acc_no);
        if (currentBalance >= amt) {
            updateBalance(acc_no, -amt);
            System.out.println("Withdrawn $" + amt + " from account " + acc_no + ". New balance: $" + getBalance(acc_no));
        } else {
            System.out.println("Insufficient funds for withdrawal from account " + acc_no);
        }
    }

    public synchronized int getBalance(int acc_no) {
        return accounts.getOrDefault(acc_no, 0);
    }

    private synchronized void updateBalance(int acc_no, int amt) {
        accounts.compute(acc_no, (key, value) -> (value == null) ? amt : value + amt);
    }
}

