package org.example;

import java.util.Scanner;

public class App {
    private static final int THREAD_SLEEP_TIME = 2000;

    public static void main(String[] args) {
        System.out.println("BANK TRANSACTION SYSTEM.........!");
        Bank bank = new Bank();

        // Get the number of customers
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Number of customers......?");
            int num = scanner.nextInt();

            // Start customer threads
            for (int i = 1; i <= num; i++) {
                Customer customer = new Customer(bank, i);
                customer.start();
            }


            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            for (int i = 1; i <= num; i++) {
                System.out.println("Final balance for account " + i + ": $" + bank.getBalance(i));
            }
        }
    }
}
