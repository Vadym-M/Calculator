package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcPlac extends AppCompatActivity {


    Button gozik;
    TextView tekst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_plac);

        gozik = findViewById(R.id.button3);
        tekst = findViewById(R.id.textView3);

        gozik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setText("Siema witam w mojej kuchni");
            }
        });
    }
}