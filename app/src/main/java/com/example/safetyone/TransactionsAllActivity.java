package com.example.safetyone;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

public class TransactionsAllActivity extends AppCompatActivity {
    private Button sort;
    private RecyclerView transactions;
    private TextView title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_list);

        this.wireWidgets();
    }

    private void wireWidgets() {
        this.sort = findViewById(R.id.button_sort);
        this.transactions = findViewById(R.id.recyclerView_transactions);
        this.title = findViewById(R.id.title);
    }

    private void showTransactions() {
        //TODO recycler view adapter stuff
    }
}
