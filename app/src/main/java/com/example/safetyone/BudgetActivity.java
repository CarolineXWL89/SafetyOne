package com.example.safetyone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.StrictMath.abs;

public class BudgetActivity extends AppCompatActivity {

    private RecyclerView catList;
    private TextView allocated, amountAllocated, left, amountLeft, budget, budgetAmount;
    private ImageButton editBudget, createCategory;
    private Button finish;

    private int averageIncome = 5114;
    private boolean finished = false;
    private User user;

    private long card_num;
    private CardType cardType;
    private int income, zip, cvv, dateOne, dateTwo, monthOne, monthTwo, yearOne, yearTwo, number;
    private String email, state, addressTwo, street, firstName, lastName, city;

    private Map<String, String> passData = new HashMap<>();



    //Supposed to be initialized with intent
//    private int income;// = 5000;
    private int age;// = 18;

    ArrayList<Category> categoryList = new ArrayList<>();

    public void onCreate (Bundle savedInstance){

        //Declare the XML scene
        super.onCreate(savedInstance);
        setContentView(R.layout.registration_activity_budget);

        wireWidgets();
        this.user = new User();

        //Fetching Intents
        Intent intent = getIntent();
//        this.income =intent.getIntExtra("income", 5114);
//        this.age = intent.getIntExtra("age", 38);
        this.card_num = Long.getLong(intent.getStringExtra("card_num"));
        this.cardType = CardType.valueOf(intent.getStringExtra("card_type"));
        this.income = Integer.getInteger(intent.getStringExtra("income"));
        this.zip = Integer.getInteger(intent.getStringExtra("zip"));
        this.cvv = Integer.getInteger(intent.getStringExtra("cvv"));
        this.dateOne = Integer.getInteger(intent.getStringExtra("dateOne"));
        this.dateTwo = Integer.getInteger(intent.getStringExtra("dateTwo"));
        this.monthOne = Integer.getInteger(intent.getStringExtra("monthOne"));
        this.monthTwo = Integer.getInteger(intent.getStringExtra("monthTwo"));
        this.yearOne = Integer.getInteger(intent.getStringExtra("yearOne"));
        this.yearTwo = Integer.getInteger(intent.getStringExtra("yearTwo"));
        this.number = Integer.getInteger(intent.getStringExtra("number"));
        this.email = intent.getStringExtra("email");
        this.state = intent.getStringExtra("state");
        this.addressTwo = intent.getStringExtra("addressTwo");
        this.street = intent.getStringExtra("street");
        this.firstName = intent.getStringExtra("firstName");
        this.lastName = intent.getStringExtra("lastName");
        this.cardType = CardType.valueOf(intent.getStringExtra("card_type"));
        this.city = intent.getStringExtra("city");

        //Generating Automatic Categories
        categoryList = resetCategories(categoryList);

        //Fetch Categories
        fetchAdapter(categoryList);

        //add category
        createCategory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                categoryList.add(new Category("New Category", 0, 0));
                fetchAdapter(categoryList);
            }
        });
    }

    private void finishSetUp() {
        if (this.finished) {
            this.finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setUserItems();
                    Intent i = new Intent(BudgetActivity.this, HomeActivity.class);



                }
            });
        }
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
        this.finish = findViewById(R.id.button_finish);
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

    //Implementing CategoryAdapter with recycler view
    void fetchAdapter(List<Category> categoryList){
        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        catList.setLayoutManager(new LinearLayoutManager(this));
        catList.setAdapter(adapter);
    }


    private void setUserItems() {
        this.user.setIncome(income);

        this.user.setFirstName(this.firstName);
        this.user.setLastName(this.lastName);
        this.user.setAddress(this.number, this.street, this.addressTwo,
                this.city, this.state,
                this.zip);

        this.user.setEmail(this.email);
        this.user.setCardInfo(this.cardType, this.card_num,
                this.cvv, this.dateOne, this.dateTwo, this.monthOne, this.monthTwo, this.yearOne,
                this.yearTwo, this.user.getAddress());
        this.user.setCardType(this.cardType.toString());

        this.passData.put("firstName", this.firstName);
        this.passData.put("lastName", this.lastName);
        this.passData.put("number", Integer.toString(this.number));
        this.passData.put("street", this.street);
        this.passData.put("addressTwo", this.addressTwo);
        this.passData.put("city", this.city);
        this.passData.put("income", Integer.toString(this.income));
        this.passData.put("zip", Integer.toString(this.zip));
        this.passData.put("card_num", Long.toString(this.card_num));
        this.passData.put("card_type", this.cardType.toString());
        this.passData.put("cvv", Integer.toString(this.cvv));
        this.passData.put("dateOne", Integer.toString(this.dateOne));
        this.passData.put("dateTwo", Integer.toString(this.dateTwo));
        this.passData.put("monthOne", Integer.toString(this.monthOne));
        this.passData.put("monthTwo", Integer.toString(this.monthTwo));
        this.passData.put("yearOne", Integer.toString(this.yearOne));
        this.passData.put("yearTwo", Integer.toString(this.yearTwo));
        this.passData.put("email", this.email);
        this.passData.put("state", this.state);
    }
}
