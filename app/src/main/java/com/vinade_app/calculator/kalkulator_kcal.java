package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class kalkulator_kcal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_kcal);

        final CheckBox CheckBoxKobieta = findViewById(R.id.checkBox1_kcal);
        final CheckBox CheckBoxMezczyzna = findViewById(R.id.checkBox2_kcal);
        final CheckBox CheckBoxAktMala = findViewById(R.id.checkBox3);
        final CheckBox CheckBoxAktSrednia = findViewById(R.id.checkBox4);
        final CheckBox CheckBoxAktDuza = findViewById(R.id.checkBox5);
        final EditText WagaKal = findViewById(R.id.WagaKcal);
        final TextView Wynik =  findViewById(R.id.WynikKcal);
        final double[] aktywnosc = {0};
        final double[] bmr = {0};

        CheckBoxKobieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmr[0] = 0.9;
                if(CheckBoxKobieta.isChecked()){
                    CheckBoxMezczyzna.setChecked(false);
                }
            }
        });
        CheckBoxMezczyzna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmr[0] = 1;
                if(CheckBoxMezczyzna.isChecked()){
                    CheckBoxKobieta.setChecked(false);
                }
            }
        });
        CheckBoxAktDuza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktywnosc[0] = 1.4;
                if(CheckBoxAktMala.isChecked()){
                    CheckBoxAktMala.setChecked(false);
                }
                if(CheckBoxAktSrednia.isChecked()){
                    CheckBoxAktSrednia.setChecked(false);
                }
            }
        });

        CheckBoxAktSrednia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktywnosc[0] = 1.2;
                if(CheckBoxAktDuza.isChecked()){
                    CheckBoxAktDuza.setChecked(false);
                }
                if(CheckBoxAktSrednia.isChecked()){
                    CheckBoxAktMala.setChecked(false);
                }
            }
        });

        CheckBoxAktMala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktywnosc[0] =  1.0;
                if(CheckBoxAktDuza.isChecked()){
                    CheckBoxAktDuza.setChecked(false);
                }
                if(CheckBoxAktSrednia.isChecked()){
                    CheckBoxAktSrednia.setChecked(false);
                }
            }
        });

        Button ObliczBtn = findViewById(R.id.button2);

        ObliczBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double Waga=Integer.parseInt(WagaKal.getText().toString());

                double WynikInt = Waga * 24 * bmr * aktywnosc[0];

                Wynik.setText(String.valueOf(WynikInt));
            }

            });
}
}