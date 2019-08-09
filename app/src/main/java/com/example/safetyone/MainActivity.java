package com.example.safetyone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button signIn, signUp;
    private CheckBox remember, isCapitalOne;
    private TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.wireWidgets();
        this.signUp();

    }

    private void wireWidgets() {
        this.header = findViewById(R.id.textView_header);
        this.username = findViewById(R.id.editText_username);
        this.password = findViewById(R.id.editText_password);
        this.signIn = findViewById(R.id.button_signin);
        this.signUp = findViewById(R.id.button_signup);
        this.remember = findViewById(R.id.checkBox_remember);
    }

    private void login() {
        //TODO sign in w/ CapitalOne API
    }

    private void signUp() {
        //TODO sign up w/ CapitalOneAPI
        //TODO will redirect to registration activity
        System.out.print("setting on click listener");
        this.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Creating a New Account", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                i.putExtra("registeredFirst", false);
                startActivity(i);
            }
        });
    }




}

