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

        checkBox1_kcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1_kcal.isChecked()){
                    checkBox2.setChecked(false);
                }
            }
        });

        checkBox2_kcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2_kcal.isChecked()){
                    checkBox.setChecked(false);
                }
            }
        });

    }
}