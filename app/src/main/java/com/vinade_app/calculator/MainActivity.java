package com.vinade_app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button test;
    TextView operationField;
    TextView resultField; // текстовое поле для вывода результата
    EditText numberField;   // поле для ввода числа
   // TextView operationField;    // текстовое поле для вывода знака операции
    Double operand = null;  // операнд операции
    String lastOperation = "="; // последняя операция
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    test = findViewById(R.id.btn9);
    operationField = findViewById(R.id.operationField);
    test.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //operationField.setText(test);
        }
    });
}

    public void onNumberClick(View view) {
        Button button = (Button)view;
        numberField.append(button.getText());

        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }
    }

    public void onOperationClick(View view) {
    }



}