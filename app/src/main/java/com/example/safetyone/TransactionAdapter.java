package com.example.safetyone;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private List<Transaction> transactions;

    public TransactionAdapter(List<Transaction> transactions){this.transactions = transactions;}

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View superView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_layout, parent, false);
        return new ViewHolder(superView);
    }

    public void onBindViewHolder(final ViewHolder holder, int position){
        Transaction currentTransaction = transactions.get(position);
        holder.vendorView.setText(currentTransaction.getCategory());
        holder.amountView.setText((int) currentTransaction.getAmount());
    }

    @Override
    public int getItemCount(){return transactions.size();}

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView vendorView;
        TextView amountView;
        CardView cardview;

        ViewHolder(View view){
            super(view);
            vendorView = view.findViewById(R.id.vendorView);
            amountView = view.findViewById(R.id.amountView);
            cardview = view.findViewById(R.id.cardView_vendor);
        }
    }
}
