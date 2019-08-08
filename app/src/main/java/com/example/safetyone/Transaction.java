package com.example.safetyone;

import java.time.format.DateTimeFormatter;

public class Transaction {
    private double amount;
    private DateTimeFormatter time;
    private String category;

    public Transaction(double amount, DateTimeFormatter time, String category) {
        this.amount = amount;
        this.time = time;
        this.category = category;

    }

    public String getTime() {
        return time.toString();
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}