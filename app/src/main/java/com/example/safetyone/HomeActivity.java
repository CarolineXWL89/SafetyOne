package com.example.safetyone;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private SeekBar generalStanding;
    private RecyclerView transactionList;

    ArrayList<Transaction> transactionLists = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        this.wireWidgets();
        fetchAdapter(transactionLists);
    }

    private void fetchAdapter(List<Transaction> transactionLists){
        TransactionAdapter adapter = new TransactionAdapter(transactionLists);
        transactionList.setLayoutManager(new LinearLayoutManager(this));
        transactionList.setAdapter(adapter);
    }

    private void wireWidgets() {
        this.generalStanding = findViewById(R.id.overallStanding);
        this.transactionList = findViewById(R.id.recyclerView_transactions);
    }
}
