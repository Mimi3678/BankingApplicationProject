package BankApplication;

import java.util.Scanner;

public class BAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //making a constructure
    BAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) { //making a check here
            balance = balance + amount;
            previousTransaction = amount; //interested to know what amount is deposited or withdrawed
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposit: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction)); //Math.abs gives ut positive values
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in); //user input from the console

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposite");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        //making a do-while loop
        do {
            System.out.println("==========================================");
            System.out.println("Enter option");
            System.out.println("==========================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("-------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("-------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("-------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("-------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("-------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("********************************");

                default:
                    System.out.println("Invalid, please enter again");
                    break;
            }
        }

        while (option != 'E');
        System.out.println("Thank You for using our services");
    }
}
