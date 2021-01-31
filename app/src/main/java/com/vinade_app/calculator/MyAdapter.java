package com.vinade_app.calculator;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Waluta> data1 = new ArrayList<>();
    ArrayList<Waluta> data = new ArrayList<>();
    ArrayList<Waluta> data2 = new ArrayList<>();
    Context context;

    public MyAdapter(Context context, ArrayList<Waluta> waluta) {
        if (waluta != null) {
            data = waluta;
           for(int i = 0 ;i < data.size();i++)
           {
             if(i < data.size()/2)
             {
                 data1.add(data.get(i));
             } else
                 {
                     data2.add(data.get(i));
                 }
           }

        }
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data2.size();
    }

    @Override
    public Object getItem(int num) {
        // TODO Auto-generated method stub
        return data2.get(num);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int i, View someView, ViewGroup arg2) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (someView == null) {
            someView = inflater.inflate(R.layout.currency_item, arg2, false);
        }
        TextView currency1 = (TextView) someView.findViewById(R.id.currency1);
        TextView currency2 = (TextView) someView.findViewById(R.id.currency2);
        TextView rate1 = (TextView) someView.findViewById(R.id.rate1);
        TextView rate2 = (TextView) someView.findViewById(R.id.rate2);

            rate1.setText(data1.get(i).getRate());

            currency1.setText(data1.get(i).getCurrency());
            if(data1.get(i).getCurrency().equals("PLN"))
            {
                currency1.setTextColor(Color.GREEN);
            }else
                {
                    currency1.setTextColor(Color.BLACK);
                    currency2.setTextColor(Color.BLACK);

                }
            rate2.setText(data2.get(i).getRate());
            currency2.setText(data2.get(i).getCurrency());

        return someView;
    }}
