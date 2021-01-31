package com.vinade_app.calculator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class CalcWalut extends AppCompatActivity {
    Runnable run;
    Thread thread;
    ListView listView;
    ArrayList<Waluta> waluty;
    TextView time, show_kwota, wynik, info;
    String timeParser;
    Spinner spinner_mam, spinner_otrzymam;
    EditText kwota;
    Button show_table;
    BottomSheetDialog bottomSheetDialog;
    ImageButton backBtn, swapBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_walut);
        Init();
        kwota.setText("100");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        swapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = spinner_mam.getSelectedItemPosition();
                spinner_mam.setSelection(spinner_otrzymam.getSelectedItemPosition());
                spinner_otrzymam.setSelection(a);
            }
        });
        show_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });
        spinner_mam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ShowAllInPanel();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_otrzymam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ShowAllInPanel();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        kwota.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShowAllInPanel();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


     run = new Runnable() {
         @Override
         public void run() {
             try {
                 String content = download("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
                 ParserWalut parserWalut = new ParserWalut();
                 if(parserWalut.parse(content))
                 {
                     waluty = parserWalut.getWaluty();
                     timeParser = parserWalut.getTime();

                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
             //Log.d("DEBUG", "TEST");
         }

     }; thread = new Thread(run);
     thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SpinnerInit();
        BottomDialogInit();
        ShowAllInPanel();
    }
    private String download(String urlPath) throws IOException {
        StringBuilder xmlResult = new StringBuilder();
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpsURLConnection) url.openConnection();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line=reader.readLine()) != null) {
                xmlResult.append(line);
            }
            return xmlResult.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
        private void Init(){
            spinner_mam = findViewById(R.id.spinner_mam);
            spinner_otrzymam = findViewById(R.id.spinner_otrzymam);
            kwota = findViewById(R.id.kwota);
            wynik = findViewById(R.id.wynik);
            show_kwota = findViewById(R.id.show_kwota);
            show_table = findViewById(R.id.tabel_kurs);
            info = findViewById(R.id.text_info);
            backBtn = findViewById(R.id.back_btn);
            swapBtn = findViewById(R.id.swap_btn);


        }

        void BottomDialogInit()
        {
            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(R.layout.currency_fragment);
            bottomSheetDialog.getBehavior().setPeekHeight(300);
            MyAdapter myAdapter = new MyAdapter(bottomSheetDialog.getContext(), waluty);
            listView = bottomSheetDialog.findViewById(R.id.listView);
            time = bottomSheetDialog.findViewById(R.id.textTime);
            listView.setAdapter(myAdapter);
            time.setText("Data: "+ timeParser);
        }
        void SpinnerInit()
        {
            String[] adapterString = new String[waluty.size()];
            for(int i = 0 ; i< waluty.size(); i++)
            {
                adapterString[i]= waluty.get(i).getCurrency();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, adapterString);
            spinner_otrzymam.setAdapter(adapter);
            spinner_mam.setAdapter(adapter);
            spinner_mam.setSelection(7);
        }
         String Conversion()
        {
            float current_rate_from = 0, current_rate_to = 0,converted_amount=0 ;
            for(int i = 0; i< waluty.size(); i++){
                if(spinner_mam.getSelectedItem().equals(waluty.get(i).getCurrency()))
                {
                  current_rate_from = Float.parseFloat(waluty.get(i).getRate());

                }
                if(spinner_otrzymam.getSelectedItem().equals(waluty.get(i).getCurrency()))
                {
                   current_rate_to = Float.parseFloat(waluty.get(i).getRate());
                }
            }
            DecimalFormat df = new DecimalFormat("###.##");
            float conversion_rate = current_rate_from / current_rate_to;
            if(kwota.getText().length() <= 0)
            {
                 converted_amount=Float.parseFloat(String.valueOf(1)) / conversion_rate;
                 show_kwota.setText("1 " + spinner_mam.getSelectedItem().toString());
            }else {
             converted_amount=Float.parseFloat(String.valueOf(kwota.getText())) / conversion_rate;}
            return String.valueOf(df.format(converted_amount));
        }
        void ShowAllInPanel()
        {
            show_kwota.setText(kwota.getText()+ " " + spinner_mam.getSelectedItem().toString());
            wynik.setText(Conversion() +" "+ spinner_otrzymam.getSelectedItem().toString());
            info.setText("1 "+ spinner_mam.getSelectedItem().toString() + " = "+ TextInfo()+" " + spinner_otrzymam.getSelectedItem().toString() + ", według średniego kursu ECB z dn." + timeParser);
        }
        String TextInfo()
        {
            float current_rate_from = 0, current_rate_to = 0,converted_amount=0 ;
            for(int i = 0; i< waluty.size(); i++){
                if(spinner_mam.getSelectedItem().equals(waluty.get(i).getCurrency()))
                {
                    current_rate_from = Float.parseFloat(waluty.get(i).getRate());
                }
                if(spinner_otrzymam.getSelectedItem().equals(waluty.get(i).getCurrency()))
                {
                    current_rate_to = Float.parseFloat(waluty.get(i).getRate());
                }
            }
            DecimalFormat df = new DecimalFormat("###.##");
            float conversion_rate = current_rate_from / current_rate_to;
            converted_amount= 1 / conversion_rate;
            return String.valueOf(df.format(converted_amount));
        }
}
