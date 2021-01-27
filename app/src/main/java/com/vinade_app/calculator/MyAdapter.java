package com.vinade_app.calculator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Waluta> data;
    Context context;

    public MyAdapter(Context context, ArrayList<Waluta> waluta) {
        if (waluta != null) {
            data = waluta;
            Log.d("DEBUG", "ok");
        }
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 5;
    }

    @Override
    public Object getItem(int num) {
        // TODO Auto-generated method stub
        return data.get(num);
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
        TextView header = (TextView) someView.findViewById(R.id.textView2);
        TextView subHeader = (TextView) someView.findViewById(R.id.textView3);
        header.setText(data.get(i).getRate());
        subHeader.setText(data.get(i).getCurrency());
        return someView;
    }}
