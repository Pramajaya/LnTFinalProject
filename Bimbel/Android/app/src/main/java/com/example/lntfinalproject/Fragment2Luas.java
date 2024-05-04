package com.example.lntfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class Fragment2Luas extends Fragment {

    Button persegiButton, segitigaButton, lingkaranButton;
    EditText persegiSisi1, persegiSisi2, segitigaAlas, segitigaTinggi, lingkaranJari;
    TextView jawabanPersegi, jawabanLingkaran, jawabanSegitiga;

    String Ssisi1 = "";
    String Ssisi2 = "";
    String alas = "";
    String tinggiSegitiga = "";
    String jari = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment2_luas, container, false);

        persegiButton = (Button) view.findViewById(R.id.persegi_hitung);
        jawabanPersegi = (TextView) view.findViewById(R.id.jawaban_persegi);
        persegiSisi1 = (EditText) view.findViewById(R.id.persegi_sisi1);
        persegiSisi2 = (EditText) view.findViewById(R.id.persegi_sisi2);

        persegiButton.setOnClickListener(v -> {
            Ssisi1 = persegiSisi1.getText().toString();
            Ssisi2 = persegiSisi2.getText().toString();

            if(Ssisi1.isEmpty() || Ssisi2.isEmpty()) {
                Toast.makeText(getContext(), "Kolom harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                double luasPersegi = Double.parseDouble(Ssisi1) * Double.parseDouble(Ssisi2);
                jawabanPersegi.setText(String.valueOf(luasPersegi));
            }
        });

        segitigaButton = (Button) view.findViewById(R.id.segitiga_hitung);
        jawabanSegitiga = (TextView) view.findViewById((R.id.segitiga_jawaban));
        segitigaAlas = (EditText) view.findViewById(R.id.segitiga_alas);
        segitigaTinggi = (EditText) view.findViewById(R.id.segitiga_tinggi);

        segitigaButton.setOnClickListener(v -> {
            alas = segitigaAlas.getText().toString();
            tinggiSegitiga = segitigaTinggi.getText().toString();

            if(alas.isEmpty() || tinggiSegitiga.isEmpty()) {
                Toast.makeText(getContext(), "Kolom harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                double luasSegitiga = Double.parseDouble(alas) * Double.parseDouble(tinggiSegitiga);
                jawabanSegitiga.setText(String.valueOf(luasSegitiga));
            }
        });

        lingkaranButton = (Button) view.findViewById(R.id.lingkaran_hitung);
        jawabanLingkaran = (TextView) view.findViewById((R.id.jawaban_lingkaran));
        lingkaranJari = (EditText) view.findViewById(R.id.lingkaran_jari);

        lingkaranButton.setOnClickListener(v -> {
            jari = lingkaranJari.getText().toString();

            if(jari.isEmpty()) {
                Toast.makeText(getContext(), "Kolom harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                double luasLingkaran = Double.parseDouble(jari) * Double.parseDouble(jari);
                jawabanLingkaran.setText(String.valueOf(luasLingkaran));
            }
        });

        return view;
    }
}