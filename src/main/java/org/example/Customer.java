package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Customer extends Thread {

    private static final int NUM_TRANSACTIONS = 3;

    private final Bank bank;
    private final int customerId;

    public Customer(Bank bank, int customerId) {
        this.bank = bank;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TRANSACTIONS; i++) {
            int amount = ThreadLocalRandom.current().nextInt(1, 101); // Generates a random number between 1 and 100
            if (ThreadLocalRandom.current().nextBoolean()) {
                bank.deposit(customerId, amount);
            } else {
                bank.withdraw(customerId, amount);
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(101));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

