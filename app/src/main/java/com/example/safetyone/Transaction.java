package com.example.safetyone;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private double amount;
    private String time;
    private String category;

    public Transaction(double amount, String time, String category) {
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

    public List<Transaction> parseJSON() throws Exception {

        final List<Transaction> transactions = new ArrayList<>();

        Object obj = new JSONParser().parse(new FileReader("transactions.json"));

        JSONArray arr = (JSONArray) obj;

        for (int i = 0; i < arr.length(); i++) {
            JSONObject jo = (JSONObject) arr.get(i);

            String vendor = (String) jo.get("vendor");
            int amount = Integer.valueOf((String) jo.get("amount"));
            String date =  (String) jo.get("date");

            transactions.add(new Transaction(amount, date, vendor));
        }

        return transactions;
    }
}