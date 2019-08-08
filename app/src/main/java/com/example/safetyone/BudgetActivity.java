package com.example.safetyone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class BudgetActivity extends AppCompatActivity {

    private RecyclerView budgetView;

    public void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.registration_activity_budget);

        budgetView = findViewById(R.id.recylerView_categories);
    }
}
