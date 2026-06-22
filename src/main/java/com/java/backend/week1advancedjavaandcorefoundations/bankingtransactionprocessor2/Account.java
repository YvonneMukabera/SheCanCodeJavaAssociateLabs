package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;

public class Account {
    private String owner;
    private double balance;
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
    public String getOwner() {
        return owner;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    @Override
    public String toString() {

        return String.format("Account for %s: RWF %.2f", owner, balance);
    }
}
