package com.example.demo.model;

public class Account {

    private Long id;
    private double balance;

    public Account(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() { return id; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
