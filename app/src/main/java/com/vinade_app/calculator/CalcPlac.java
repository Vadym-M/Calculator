package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcPlac extends AppCompatActivity {

EditText brutto, skl_wypad;
TextView wynik;
Button gozik;
Spinner rok_zycia, pit, kup, chorobowe;
String[] spin_rok_zycia ={"TAK","NIE"};
String[] spin_pit ={"TAK","NIE"};
String[] spin_kup ={"250","300"};
String[] spin_chorobowe ={"TAK","NIE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_plac);
        init();
        initSpin();

        gozik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Obliczenia();
            }
        });
    }

    void Obliczenia(){

        if(rok_zycia.getSelectedItem().equals("TAK")){

            int test = Integer.parseInt(brutto.getText().toString()) - 500;
            wynik.setText(String.valueOf(test));
        }else{
            int test_2 = Integer.parseInt(brutto.getText().toString()) - 700;
            wynik.setText(String.valueOf(test_2));
        }
    }

    void init(){
        brutto = findViewById(R.id.wynagrodzenie_brutto);
        skl_wypad = findViewById(R.id.skladka_wypadkowa);
        wynik = findViewById(R.id.textView18);
        rok_zycia = findViewById(R.id.rok_zycia);
        pit = findViewById(R.id.pit);
        kup = findViewById(R.id.kup);
        chorobowe = findViewById(R.id.chorobowe);
        gozik = findViewById(R.id.gozik);
    }

    void initSpin() {
        ArrayAdapter<String>adap_rok_zycia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin_rok_zycia);
        rok_zycia.setAdapter(adap_rok_zycia);

        ArrayAdapter<String>adap_pit = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin_pit);
        pit.setAdapter(adap_pit);

        ArrayAdapter<String>adap_kup = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin_kup);
        kup.setAdapter(adap_kup);

        ArrayAdapter<String>adap_chorobowe = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spin_chorobowe);
        chorobowe.setAdapter(adap_chorobowe);

    }


}