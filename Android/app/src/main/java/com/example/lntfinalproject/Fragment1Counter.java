package com.example.lntfinalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class Fragment1Counter extends Fragment {

    TextView countNum;
    Button plusButton, minButton, resetButton;
    SharedPreferences sp;

    int val;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1_counter, container, false);

        countNum = (TextView) view.findViewById(R.id.counterPageNumber);
        plusButton = (Button) view.findViewById(R.id.buttonFragmentPlus);
        minButton = (Button) view.findViewById(R.id.buttonFragmentMinus);
        resetButton = (Button) view.findViewById(R.id.buttonFragmentReset);

        sp = requireContext().getSharedPreferences("Counter", Context.MODE_PRIVATE);
        countNum.setText(String.valueOf(sp.getInt("Number", 0)));

        plusButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sp.edit();
            String counterVal = countNum.getText().toString();
            val = Integer.parseInt(counterVal);
            val++;
            editor.putInt("Number", val);
            editor.apply();
            countNum.setText(String.valueOf(val));
        });

        minButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sp.edit();
            String counterVal = countNum.getText().toString();
            val = Integer.parseInt(counterVal);
            if (val >= 1) {
                val--;
                editor.putInt("number", val);
                editor.apply();
                countNum.setText(String.valueOf(val));
            }
        });

        resetButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.apply();
            countNum.setText("0");
        });

        return view;
    }
}