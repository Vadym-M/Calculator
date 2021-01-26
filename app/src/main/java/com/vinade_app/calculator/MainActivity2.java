package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    EditText Waga, Mililitry, Procent, Czas;
    TextView Wynik, Plec;
    CheckBox checkBox, checkBox2;
    double promile_usuwane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button tekstBtn = findViewById(R.id.button);
        final TextView Wynik =  findViewById(R.id.Wynik);

        init();

        tekstBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                double WagaInt=Integer.parseInt(Waga.getText().toString());
                double ProcentInt=Integer.parseInt(Procent.getText().toString());
                double CzasInt=Integer.parseInt(Czas.getText().toString());
                double MililitryInt = Integer.parseInt(Mililitry.getText().toString());

                double zmienna = MililitryInt * ((ProcentInt/100) * 0.79);


Log.d("test", String.valueOf(zmienna));

                if(checkBox.isChecked()){
                    WagaInt = WagaInt * 0.6;
                    promile_usuwane = 0.11;
                    Log.d("test", "checkbox 1");
                }
                if(checkBox2.isChecked()){
                    WagaInt = WagaInt * 0.7;
                    promile_usuwane = 0.13;
                    Log.d("test", "checkbox 2");
                }



                zmienna = zmienna / WagaInt;

                promile_usuwane = promile_usuwane * CzasInt;
                zmienna = zmienna - promile_usuwane;

                Wynik.setText(String.valueOf(zmienna));

            }
        });
    }
    public void init(){
        Waga = findViewById(R.id.Waga);
        Procent = findViewById(R.id.Procent);
        Mililitry = findViewById(R.id.Mililitry);
        Plec = findViewById(R.id.Plec);
        Czas = findViewById(R.id.Czas);
        Wynik = findViewById(R.id.Wynik);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);



    }
}