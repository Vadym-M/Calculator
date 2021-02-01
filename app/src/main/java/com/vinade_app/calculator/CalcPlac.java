package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

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

//        if(rok_zycia.getSelectedItem().equals("TAK")){
//
//            int test = Integer.parseInt(brutto.getText().toString()) - 500;
//            wynik.setText(String.valueOf(test));
//        }else{
//            int test_2 = Integer.parseInt(brutto.getText().toString()) - 700;
//            wynik.setText(String.valueOf(test_2));
//        }

        if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("TAK")){

            double test = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) - 250))*17/100)-43.76) - (Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test)));


        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("TAK")){

            double test2 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) - 250))*17/100)) - (Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test2)));

        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("TAK")){

            double test3 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) - 300))*17/100)-43.76) - (Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test3)));


        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("NIE")){

            double test4 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(88.74/100 * Integer.parseInt(brutto.getText().toString()) - 250))*17/100)-43.76) - (Math.round(88.74/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test4)));


        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("NIE")) {

            double test15 = 88.74 / 100 * Integer.parseInt(brutto.getText().toString()) - (88.74 / 100 * Integer.parseInt(brutto.getText().toString()) * 9 / 100) - ((((Math.round(88.74 / 100 * Integer.parseInt(brutto.getText().toString()) - 300)) * 17 / 100) - 43.76) - (Math.round(88.74 / 100 * Integer.parseInt(brutto.getText().toString()) * 7.75 / 100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test15)));

        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("TAK")){

            double test5 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) - 300))*17/100)) - (Math.round(86.29/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test5)));


        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("NIE")){

            double test6 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(88.74/100 * Integer.parseInt(brutto.getText().toString()) - 300))*17/100)) - (Math.round(88.74/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test6)));

        }else if(rok_zycia.getSelectedItem().equals("TAK") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("NIE")){

            double test7 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100) - ((((Math.round(88.74/100 * Integer.parseInt(brutto.getText().toString()) - 250))*17/100)) - (Math.round(88.74/100 * Integer.parseInt(brutto.getText().toString()) * 7.75/100)));

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test7)));

        } else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("TAK")){

            double test8 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test8)));


        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("TAK")){

            double test9 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test9)));

        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("TAK")){

            double test10 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test10)));

        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("NIE")){

            double test11 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test11)));

        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("TAK")){

            double test12 = 86.29/100 * Integer.parseInt(brutto.getText().toString()) - (86.29/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test12)));

        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("NIE")){

            double test13 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test13)));

        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("NIE") && kup.getSelectedItem().equals("250") && chorobowe.getSelectedItem().equals("NIE")){

            double test14 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test14)));

        }else if(rok_zycia.getSelectedItem().equals("NIE") && pit.getSelectedItem().equals("TAK") && kup.getSelectedItem().equals("300") && chorobowe.getSelectedItem().equals("NIE")){

            double test16 = 88.74/100 * Integer.parseInt(brutto.getText().toString()) - (88.74/100 * Integer.parseInt(brutto.getText().toString()) * 9/100);

            DecimalFormat df = new DecimalFormat("###.##");
            wynik.setText(String.valueOf(df.format(test16)));

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