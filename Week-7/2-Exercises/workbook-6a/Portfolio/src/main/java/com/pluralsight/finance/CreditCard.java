package com.pluralsight.finance;

public class CreditCard implements Valuable {
    private final String name;
    private final String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public void charge(double amount) {
        this.balance += amount;
    }

    public void pay(double amount) {
        this.balance -= amount;
    }

    @Override
    public double getValue() {
        return this.balance;
    }
}
