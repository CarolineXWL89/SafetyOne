package com.example.safetyone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

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

    private int averageIncome = 5114;

    //Supposed to be initialized with intent
    private int income;// = 5000;
    private int age;// = 18;

    public void onCreate (Bundle savedInstance){

        //Declare the XML scene
        super.onCreate(savedInstance);
        setContentView(R.layout.registration_activity_budget);

        wireWidgets();

        //Fetching Intents
        Intent intent = getIntent();
        this.income =intent.getIntExtra("income", 5114);
        this.age = intent.getIntExtra("age", 38);

        //Generating Automatic Categories
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList = resetCategories(categoryList);

        //Implementing CategoryAdapter with recycler view
        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        catList.setLayoutManager(new LinearLayoutManager(this));
        catList.setAdapter(adapter);
    }

    private void wireWidgets() {
        //Iniitialize XML elements
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

    private ArrayList<Category> resetCategories(ArrayList<Category> categoryList){
        categoryList.clear();
        int housingCost = getHouseAllocation();
        categoryList.add(new Category("House", housingCost, 0));
        int powerCost = allocationTrend(118);
        categoryList.add(new Category("Power", powerCost, 0));
        int utilityCost = allocationTrend(200);
        categoryList.add(new Category("Utilities", utilityCost, 0));
        int groceryCost = allocationTrend(325);
        categoryList.add(new Category("Groceries", groceryCost, 0));
        int educationCost = getEducationExpense(housingCost, powerCost, utilityCost, groceryCost);
        categoryList.add(new Category("Education", educationCost, 0));
        int genericExpense = getGenericExpense(housingCost, powerCost, utilityCost, groceryCost, educationCost);
        categoryList.add(new Category("Dining", genericExpense, 0));
        categoryList.add(new Category("Entertainment", genericExpense, 0));
        categoryList.add(new Category("Shopping", genericExpense, 0));
        categoryList.add(new Category("Miscellaneous", genericExpense, 0));

        return categoryList;
    }

    private int spendableAmount(){
        int percentInvested = ((20*this.age)-90)/54;
        int amountInvested = (percentInvested * this.income)/100;
        return this.income - amountInvested;
    }

    private int getHouseAllocation(){
        int amountInvested = this.income - spendableAmount();
        return 2*(amountInvested*this.age)/100;
    }

    private int allocationTrend(int avgVal){
        int ratio = avgVal/this.averageIncome;
        return(ratio * (this.income + ((Math.abs(this.averageIncome-this.income)/(2)))));
    }

    private int getEducationExpense(int housing, int power, int utility, int grocery){
        int remaining = this.income - (housing + power + utility + grocery);
        return (int) (0.5 - (this.age-18)) *remaining;
    }

    private int getGenericExpense(int housing, int power, int utility, int grocery, int education) {
        int remaining = this.income - (housing + power + utility + grocery + education);
        return remaining / 4;
    }
}
