package com.example.lntfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class Fragment3Volume extends Fragment {

    Button balokButton, piramidButton, tabungButton;
    TextView jawabanBalok, jawabanPiramid, jawabanTabung;
    EditText panjangBalok, lebarBalok, tinggiBalok, luasAlasPiramid, tinggiPiramid, jariTabung, tinggiTabung;

    String pBal = "";
    String lBal = "";
    String tBal = "";
    String laPir = "";
    String tPir = "";
    String jTab = "";
    String tTab = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3_volume, container, false);

        balokButton = (Button) view.findViewById(R.id.button_balok);
        jawabanBalok = (TextView) view.findViewById(R.id.jawaban_balok);
        panjangBalok = (EditText) view.findViewById((R.id.editText_balok1));
        lebarBalok = (EditText) view.findViewById(R.id.editText_balok2);
        tinggiBalok = (EditText) view.findViewById(R.id.editText_balok3);

        balokButton.setOnClickListener(v -> {
            pBal = panjangBalok.getText().toString();
            lBal = lebarBalok.getText().toString();
            tBal = tinggiBalok.getText().toString();

            if(pBal.isEmpty() || lBal.isEmpty() || tBal.isEmpty()) {
                Toast.makeText(getContext(), "Kolom harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                double volumeBalok = Double.parseDouble(pBal) * Double.parseDouble(lBal) * Double.parseDouble(tBal);
                jawabanBalok.setText(String.valueOf(volumeBalok));
            }
        });

        piramidButton = (Button) view.findViewById(R.id.button_piramid);
        jawabanPiramid = (TextView) view.findViewById(R.id.jawaban_piramid);
        luasAlasPiramid = (EditText) view.findViewById(R.id.editText_piramid1);
        tinggiPiramid = (EditText) view.findViewById(R.id.editText_piramid2);

        piramidButton.setOnClickListener(v -> {
            laPir = luasAlasPiramid.getText().toString();
            tPir = tinggiPiramid.getText().toString();

            if(laPir.isEmpty() || tPir.isEmpty()) {
                Toast.makeText(getContext(), "Kolom harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                double volumePiramid = (Double.parseDouble(laPir) * Double.parseDouble(tPir)) / 3;
                jawabanPiramid.setText(String.valueOf(volumePiramid));
            }
        });

        tabungButton = (Button) view.findViewById(R.id.button_tabung);
        jawabanTabung = (TextView) view.findViewById(R.id.jawaban_tabung);
        jariTabung = (EditText) view.findViewById(R.id.editText_tabung1);
        tinggiTabung = (EditText) view.findViewById(R.id.editText_tabung2);

        tabungButton.setOnClickListener(v -> {
            jTab = jariTabung.getText().toString();
            tTab = tinggiTabung.getText().toString();

            if(jTab.isEmpty() || tTab.isEmpty()) {
                Toast.makeText(getContext(), "Kolom harus diisi!", Toast.LENGTH_SHORT).show();
            } else if ((Double.parseDouble(jTab) % 7) == 0) {
                double volumeTabung = (22 * Double.parseDouble(jTab) * Double.parseDouble(jTab) * Double.parseDouble(tTab)) / 7;
                jawabanTabung.setText(String.valueOf(volumeTabung));
            } else {
                double volumeTabung = 3.14 * Double.parseDouble(jTab) * Double.parseDouble(jTab) * Double.parseDouble(tTab);
                jawabanTabung.setText(String.valueOf(volumeTabung));
            }
        });

        return view;
    }
}