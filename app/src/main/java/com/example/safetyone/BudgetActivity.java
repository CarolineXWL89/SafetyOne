package com.example.safetyone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class BudgetActivity extends AppCompatActivity {

    private RecyclerView catList;
    private TextView allocated;
    private TextView amountAllocated;
    private TextView left;
    private TextView amountLeft;
    private TextView budget;
    private TextView budgetAmount;
    private ImageButton editBudget;
    private ImageButton createCategory;

    public void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.registration_activity_budget);

        catList = findViewById(R.id.recyclerView_categories);
        allocated = findViewById(R.id.textView_allocated);
        amountAllocated = findViewById(R.id.textView_allocatedAmount);
        left = findViewById(R.id.textView_left);
        amountLeft = findViewById(R.id.textView_moneyLeft);
        budget = findViewById(R.id.textView_budget);
        budgetAmount = findViewById(R.id.textView_budgetAmount);
        editBudget = findViewById(R.id.imageButton_editBudget);
        createCategory = findViewById(R.id.imageButton_addCategory);
    }
}
