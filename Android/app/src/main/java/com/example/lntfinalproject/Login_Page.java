package com.example.lntfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
//import android.view.KeyEvent;

public class Login_Page extends AppCompatActivity {
    Button textButton;
    EditText emailLogin, passwordLogin;
    SharedPreferences sp;

    String emailLoginValid = "";
    String passwordLoginValid = "";
    String registeredEmail = "";
    String registeredPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        textButton = findViewById(R.id.buttonConfirmLogin);
        emailLogin = findViewById(R.id.editTextLoginEmail);
        passwordLogin = findViewById(R.id.editTextLoginPassword);

        sp = getSharedPreferences("RegisterPagePre", Context.MODE_PRIVATE);

        textButton.setOnClickListener(v -> {
            emailLoginValid = emailLogin.getText().toString();
            passwordLoginValid = passwordLogin.getText().toString();

            registeredEmail = sp.getString("email", "");
            registeredPassword = sp.getString("password", "");

            if (!emailLoginValid.equals(registeredEmail)) {
                Toast.makeText(getApplicationContext(), "Email tidak terdaftar!", Toast.LENGTH_SHORT).show();
            } else if (!passwordLoginValid.equals(registeredPassword)) {
                Toast.makeText(getApplicationContext(), "Password tidak terdaftar!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Selamat datang!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login_Page.this, CounterPageActivity.class);
                startActivity(intent);
                }
        });



    }
}