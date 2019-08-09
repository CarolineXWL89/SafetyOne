package com.example.safetyone;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button sort;
    private TextView tile;
    private RecyclerView transactions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        this.wireWidgets();
    }

    private void wireWidgets() {
        this.sort = findViewById(R.id.button);
        this.bottom = findViewById(R.id.view_bottom);
        this.top = findViewById(R.id.view_top);
        this.transactions = findViewById(R.id.recyclerView_transactions);
    }

    private void setTransactions() {
        //TODO for adapting transactions to recyclerview
    }
}
