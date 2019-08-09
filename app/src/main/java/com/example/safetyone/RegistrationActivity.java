package com.example.safetyone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    private EditText dateTwo, yearOne, monthTwo, yearTwo, monthOne, firstName, lastName, cardNum, dateOne,
            CVV, addressTwo, addressOne, city, zip, income, email;
    private TextView generalReg, selectCardType, goodThrough, income_text, dollar;
    private Spinner typeCard, state;
    private Button nextReg;
    private boolean canReg;

    private int number = 0;
    private String street = "";
    private String username = "";
    private String password = "";
    List<String> content = new ArrayList<>();
    Map<String, String> passData = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity_general);

        this.wireWidgets();

        Intent i = getIntent();
        this.canReg = i.getBooleanExtra("registeredFirst", true); //why is default true?
        this.username = i.getStringExtra("username");
        this.password = i.getStringExtra("password");

        this.setUserGeneral();
        this.nextPage();

    }

    private void wireWidgets() {
        this.dateTwo = findViewById(R.id.editText_dateTwo);
        this.yearOne = findViewById(R.id.editText_yearOne);
        this.monthTwo = findViewById(R.id.editText_monthTwo);
        this.yearTwo = findViewById(R.id.editText_monthOne);
        this.monthOne = findViewById(R.id.editText_firstName);
        this.firstName = findViewById(R.id.editText_firstName);
        this.lastName = findViewById(R.id.editText_lastName);
        this.cardNum = findViewById(R.id.editText_cardNum);
        this.dateOne = findViewById(R.id.editText_dateOne);
        this.CVV = findViewById(R.id.editText_CVV);
        this.addressTwo = findViewById(R.id.editText_addressTwo);
        this.addressOne = findViewById(R.id.editText_addressOne);
        this.city = findViewById(R.id. editText_city);
        this.zip = findViewById(R.id.editText_zip);
        this.income = findViewById(R.id.editText_income);
        this.email = findViewById(R.id.editText_email);
        this.generalReg = findViewById(R.id.textView_generalReg);
        this.selectCardType = findViewById(R.id.textView_selectCardType);
        this.goodThrough = findViewById(R.id.textView_goodThru);
        this.income_text = findViewById(R.id.textView_income);
        this.dollar = findViewById(R.id.textView_dollar);
        this.typeCard = findViewById(R.id.spinner_typeCard);
        this.state = findViewById(R.id.spinner_state);
        this.nextReg = findViewById(R.id.button_nextRegOneTwo);
    }

    private void setUserGeneral() {
        if (this.canReg) {
            //TODO create user w/ no info yet
            //TODO make sure fields are non-nullable

            //reset value
            this.canReg = true;

            this.parseAddress();

            //passing data
            this.passData.put("firstName", this.firstName.getText().toString());
            this.passData.put("lastName", this.lastName.getText().toString());
            this.passData.put("number", Integer.toString(this.number));
            this.passData.put("street", this.street);
            this.passData.put("addressTwo", this.addressTwo.getText().toString());
            this.passData.put("city", this.city.getText().toString());
            this.passData.put("income", this.income.getText().toString());
            this.passData.put("zip", this.zip.getText().toString());
            this.passData.put("card_num", this.cardNum.getText().toString());
            this.passData.put("card_type", this.typeCard.getSelectedItem().toString());
            this.passData.put("cvv", this.CVV.getText().toString());
            this.passData.put("dateOne", this.dateOne.getText().toString());
            this.passData.put("dateTwo", this.dateTwo.getText().toString());
            this.passData.put("monthOne", this.monthOne.getText().toString());
            this.passData.put("monthTwo", this.monthTwo.getText().toString());
            this.passData.put("yearOne", this.yearOne.getText().toString());
            this.passData.put("yearTwo", this.yearTwo.getText().toString());
            this.passData.put("email", this.email.getText().toString());
            this.passData.put("state", this.state.getSelectedItem().toString());
        }
    }

    private void parseAddress() {
        int divIndex = this.addressOne.getText().toString().indexOf(" ");
        this.number = Integer.getInteger(this.addressOne.getText().toString().substring(0, divIndex));
        this.street = this.addressOne.getText().toString().substring(this.addressOne.getText().toString().indexOf(" ") + 1);
    }

    private void nextPage() {
        this.nextReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserFile(username, password);
                Intent i = new Intent(RegistrationActivity.this, BudgetActivity.class);
//                i.putExtra("user", user);
                i.putExtra("username", username);
                i.putExtra("password", password);

                for (String key : passData.keySet()) {
                    i.putExtra(key, passData.get(key));
                }
                startActivity(i);
            }
        });
    }

    public void createUserFile(String username, String password) {
        String fileName = username;
        this.content = new ArrayList<>();
        this.content.add("username: ");
        this.content.add(username);
        this.content.add("password: ");
        this.content.add(password);

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            for (String item : this.content) {
                fos.write(item.getBytes());
            }
            fos.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(RegistrationActivity.this, "Cannot create user", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
