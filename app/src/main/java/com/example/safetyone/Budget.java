package com.example.safetyone;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double limit;
    private double spent;
    private String category;

    public Budget(double limit, double spent, String category) {
        this.limit = limit;
        this.spent = spent;
        this.category = category;

    }

    public double getLimit() {
        return this.limit;
    }

    public String getCategory() {
        return category;
    }

    public double getSpent() {
        return this.spent;
    }

    public List<Budget> parseJSON() throws Exception {
        final List<Budget> budgets = new ArrayList<>();

        Object obj = new JSONParser().parse(new FileReader("monitored.json"));

        JSONArray monitored = (JSONArray) obj;

        for (int i = 0; i < monitored.length(); i++) {

            JSONObject jo = (JSONObject) monitored.get(i);
            String vendor = (String) jo.get("vendor");
            int limit = Integer.valueOf((String) jo.get("limit"));
            int spent =  Integer.valueOf((String) jo.get("spent"));
            budgets.add(new Budget(limit, spent, vendor));
        }

        return budgets;
    }

}
