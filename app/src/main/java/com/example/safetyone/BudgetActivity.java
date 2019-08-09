package com.example.safetyone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

public class BudgetActivity extends AppCompatActivity {

    private RecyclerView budgetView;
    private EditText instructions;

    public void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.registration_activity_budget);

        budgetView = findViewById(R.id.recyclerView_categories);
        instructions = findViewById(R.id.editText_allotments);
    }
}
