package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kalkulator_kcal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_kcal);

        Button tekstBtn = findViewById(R.id.button);
        final TextView Wynik =  findViewById(R.id.Wynik);

     /*   tekstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText WagaPole= findViewById(R.id.Waga);
                String WagaString=WagaPole.getText().toString();

                EditText MililitryPole = findViewById(R.id.Mililitry);
                String MililitryString = MililitryPole.getText().toString();

                Integer Mililitry = Integer.parseInt(MililitryString);
                Integer Waga = Integer.parseInt(WagaString);

                Wynik.setText(Mililitry*Waga);

            }
        });

      */
    }
}