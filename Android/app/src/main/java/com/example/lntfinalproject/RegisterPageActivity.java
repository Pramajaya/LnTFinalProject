package com.example.lntfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;

public class RegisterPageActivity extends AppCompatActivity {

    EditText id, email, name, password, confirmPassword;
    Button regButton;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        id = findViewById(R.id.editTextRegisterId);
        email = findViewById(R.id.editTextRegisterEmail);
        name = findViewById(R.id.editTextRegisterName);
        password = findViewById(R.id.editTextRegisterPassword);
        confirmPassword = findViewById(R.id.editTextRegisterConfirmPassword);
        regButton = findViewById(R.id.buttonConfirmRegister);

        sp = getSharedPreferences("RegisterPagePre", Context.MODE_PRIVATE);

        regButton.setOnClickListener(v -> {
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sp.edit();
            String idValue = id.getText().toString();
            String emailValue = email.getText().toString();
            String nameValue = name.getText().toString();
            String passwordValue = password.getText().toString();
            String confirmPasswordValue = confirmPassword.getText().toString();

            if (id.length() <= 0) {
                Toast.makeText(getApplicationContext(), "ID harus diisi!", Toast.LENGTH_SHORT).show();

            } else if (email.length() <= 0) {
                Toast.makeText(getApplicationContext(), "Email harus diisi!", Toast.LENGTH_SHORT).show();

            } else if (!email.getText().toString().contains("@")) {
                Toast.makeText(getApplicationContext(), "Email harus berisi '@' !", Toast.LENGTH_SHORT).show();

            } else if (!email.getText().toString().endsWith(".com")) {
                Toast.makeText(getApplicationContext(), "Email harus diakhiri dengan '.com.!", Toast.LENGTH_SHORT).show();

            } else if (name.length() <= 0) {
                Toast.makeText(getApplicationContext(), "Nama harus diisi!", Toast.LENGTH_LONG).show();

            } else if (name.length() < 5) {
                Toast.makeText(getApplicationContext(), "Nama harus berisi lebih dari 5 karakter!", Toast.LENGTH_LONG).show();

            } else if (password.length() <= 0) {
                Toast.makeText(getApplicationContext(), "Password harus diisi!", Toast.LENGTH_SHORT).show();

            } else if (!confirmPassword.getText().toString().equals(passwordValue)) {
                Toast.makeText(getApplicationContext(), "Input harus sama dengan password!", Toast.LENGTH_SHORT).show();

            } else if (confirmPassword.length() <= 0) {
                Toast.makeText(getApplicationContext(), "Confirm password harus diisi!", Toast.LENGTH_SHORT).show();

            } else {
                editor.putString("id", idValue);
                editor.putString("email", emailValue);
                editor.putString("name", nameValue);
                editor.putString("password", passwordValue);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Data Tersimpan!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterPageActivity.this, Login_Page.class);
                startActivity(intent);
            }
        });
    }
}