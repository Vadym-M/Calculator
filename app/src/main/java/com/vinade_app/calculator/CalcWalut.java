package com.vinade_app.calculator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class CalcWalut extends AppCompatActivity {
    Runnable run;
    Thread thread;
    ListView listView;
    ArrayList<Waluta> waluty;
    TextView time;
    String timeParser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_walut);



     run = new Runnable() {
         @Override
         public void run() {
             try {
                 String content = download("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
                 ParserWalut parserWalut = new ParserWalut();
                 Log.d("DEBUG", "TEST2");
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
        Init();
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

            Log.d("DEBUG", " TIME CHECK -->"+ timeParser);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.currency_fragment);
        bottomSheetDialog.show();

            MyAdapter myAdapter = new MyAdapter(bottomSheetDialog.getContext(), waluty);
           listView = bottomSheetDialog.findViewById(R.id.listView);
            time = bottomSheetDialog.findViewById(R.id.textTime);
            listView.setAdapter(myAdapter);
            time.setText("Data: "+ timeParser);
        }
}
