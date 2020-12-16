package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button changeScreen = findViewById(R.id.button17);

        changeScreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Screen2 = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(Screen2);
            }
        });
    }



}