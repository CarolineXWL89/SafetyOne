package com.example.safetyone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    private EditText dateTwo, yearOne, monthTwo, yearTwo, monthOne, firstName, lastName, cardNum, dateOne,
            CVV, addressTwo, addressOne, city, zip, income, email;
    private TextView generalReg, selectCardType, goodThrough, income_text, dollar;
    private Spinner typeCard, state;
    private Button nextReg;
    private User user;
    private boolean canReg;

    private int number = 0;
    private String street = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity_general);

        this.wireWidgets();
        this.user = new User();

        Intent i = getIntent();
        this.canReg = i.getBooleanExtra("registeredFirst", true); //why is default true?

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
            this.user.setIncome(Integer.getInteger(this.income.getText().toString()));

            this.user.setFirstName(this.firstName.getText().toString());
            this.user.setLastName(this.lastName.getText().toString());
            this.parseAddress();
            this.user.setAddress(this.number, this.street, this.addressTwo.getText().toString(),
                    this.city.getText().toString(), this.state.getSelectedItem().toString(),
                    Integer.getInteger(this.zip.getText().toString()));

            this.user.setEmail(this.email.getText().toString());
            this.user.setCardInfo(CardType.valueOf(this.typeCard.getSelectedItem().toString()), Long.getLong(this.cardNum.getText().toString()),
                    Integer.getInteger(this.CVV.getText().toString()), Integer.getInteger(this.dateOne.getText().toString()),
                    Integer.getInteger(this.dateTwo.getText().toString()), Integer.getInteger(this.monthOne.getText().toString()),
                    Integer.getInteger(this.monthTwo.getText().toString()), Integer.getInteger(this.yearOne.getText().toString()),
                    Integer.getInteger(this.yearTwo.getText().toString()), this.user.getAddress());
            this.user.setCardType(this.typeCard.getSelectedItem().toString());

            //reset value
            this.canReg = true;
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
                Intent i = new Intent();
                i.putExtra("user", user);
                startActivity(i);
            }
        });
    }
}
