package com.example.safetyone;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<Category> categories;

    public CategoryAdapter(List<Category> categories){this.categories = categories;}

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View superView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reg_budget_layout, parent, false);
        return new ViewHolder(superView);
    }

    public void onBindViewHolder(final ViewHolder holder, int position){
        Category currentCategory = categories.get(position);
        holder.category.setText(currentCategory.getName());
        holder.amount.setText((int) currentCategory.getAllocated());
        holder.suggestedAllocation.setText((int) currentCategory.getAllocated());
    }

    @Override
    public int getItemCount(){return categories.size();}

    class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView category;
        EditText amount;
        Switch canLock;
        TextView suggestionText;
        TextView suggestedAllocation;
        ImageButton removeCategory;

         ViewHolder(View view){
            super(view);
            cardView = view.findViewById(R.id.cardView_category);
            category = view.findViewById(R.id.textView_category);
            amount = view.findViewById(R.id.editText_amount);
            canLock = view.findViewById(R.id.switch_lockable);
            suggestionText = view.findViewById(R.id.textView_suggested);
            suggestedAllocation = view.findViewById(R.id.textView_suggestedAllocation);
            removeCategory = view.findViewById(R.id.imageButton_removeCategory);
        }
    }
}