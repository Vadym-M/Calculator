package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button k_wynagr,k_promili, k_walut, k_kalorii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Init();
    isClick();
    }


    public void Init(){
      k_kalorii = findViewById(R.id.k_kalorii);
      k_walut = findViewById(R.id.k_walut);
      k_wynagr = findViewById(R.id.k_wynagrodz);
      k_promili = findViewById(R.id.k_promili);
}
   public void isClick(){
        OnClickListener onClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId())
                {
                    case R.id.k_kalorii:
                        Intent intent1 = new Intent(getApplicationContext(), kalkulator_kcal.class);
                        startActivity(intent1);
                        break;
                    case R.id.k_promili:
                        Intent intent2 = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent2);
                        break;
                    case R.id.k_walut:
                        Intent intent3 = new Intent(getApplicationContext(), CalcWalut.class);
                        startActivity(intent3);
                        break;
                    case R.id.k_wynagrodz:
                        Intent intent4 = new Intent(getApplicationContext(), CalcPlac.class);
                        startActivity(intent4);
                        break;
                }
            }
        };
        k_promili.setOnClickListener(onClickListener);
        k_wynagr.setOnClickListener(onClickListener);
        k_walut.setOnClickListener(onClickListener);
        k_kalorii.setOnClickListener(onClickListener);
   }
}