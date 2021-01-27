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

        Button tekstBtn = findViewById(R.id.button);
        final TextView Wynik =  findViewById(R.id.Wynik);

        CheckBox checkBox1_kcal = findViewById(R.id.checkBox1_kcal);
        final CheckBox checkBox2_kcal = findViewById(R.id.checkBox2_kcal);

        checkBox1_kcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1_kcal.isChecked()){
                    checkBox2_kcal.setChecked(false);
                }
            }
        });

        checkBox2_kcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2_kcal.isChecked()){
                    checkBox2_kcal.setChecked(false);
                }
            }
        });

    }
}