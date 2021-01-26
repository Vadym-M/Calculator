package com.vinade_app.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class CalcWalut extends AppCompatActivity {
    Runnable run;
    Thread thread;
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
                     for(int i = 0; i < parserWalut.getWaluty().size(); i++ )
                     {
                         Log.d("DEBUG", "MSG --> "+ i + " Currency ->" + parserWalut.getWaluty().get(i).getCurrency() + " Rate:" + parserWalut.getWaluty().get(i).getRate() );

                     }
                     Log.d("DEBUG", " TIME -->>"  + parserWalut.getTime());

                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
             Log.d("DEBUG", "TEST");
         }

     }; thread = new Thread(run);
     thread.start();
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
        }}

}