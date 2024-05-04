package com.example.lntfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
//* = all view type//

public class MainActivity extends AppCompatActivity {
    Button textButton, logButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textButton = findViewById(R.id.buttonRegister);
        logButton = findViewById(R.id.buttonLogin);

        textButton.setOnLongClickListener(v -> {
            textButton.setBackgroundColor(getResources().getColor(R.color.black));
            return false;
        });

        textButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegisterPageActivity.class)));

        logButton.setOnLongClickListener(v -> {
            logButton.setBackgroundColor(getResources().getColor(R.color.black));
            return false;
        });

        logButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Login_Page.class)));
    }
}