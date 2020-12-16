package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button tekstBtn = findViewById(R.id.button);
        final TextView pole =  findViewById(R.id.TextField);

        tekstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pole.setText("cat");
            }
        });
    }


}