package com.vinade_app.calculator;

import android.text.TextUtils;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParserWalut {
    private ArrayList<Waluta> waluty;
    private String time;

    public ParserWalut() {
        waluty = new ArrayList<>();
    }
    public ArrayList<Waluta> getWaluty()
    {
        return waluty;
    }
    public String getTime()
    {
        return time;
    }
    public boolean parse(String currencyData)
    {
        boolean status = true;
        Waluta currentWaluta = null;
        boolean inEntry = false;
        String textValue = "";
        String tmp = "";
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(currencyData));
            int eventType = xpp.getEventType();
            Log.d("DEBUG", " TYPE --> " + eventType + "/" );
            while(eventType != XmlPullParser.END_DOCUMENT){

                String tagName = xpp.getName();

                String tagName2 = xpp.getAttributeValue("0","USD");



                switch (eventType){
                    case XmlPullParser.START_TAG:
                        tmp = "";
                        if(tagName.equals("Cube")){
                            currentWaluta = new Waluta();

                        for (int i = 0; i < xpp.getAttributeCount(); i++) {
                            if (xpp.getAttributeName(i).equals("currency")) {
                                currentWaluta.setCurrency(xpp.getAttributeValue(i));
                            }else if(xpp.getAttributeName(i).equals("time"))
                            {
                                time = xpp.getAttributeValue(i);
                            }
                            else if (xpp.getAttributeName(i).equals("rate")) {
                                currentWaluta.setRate(xpp.getAttributeValue(i));
                                waluty.add(currentWaluta);
                            }
                        }
                        if (!TextUtils.isEmpty(tmp))
                            Log.d("DEBUG", "Attributes: " + tmp);


                        }
                        break;


                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
            Log.d("DEBUG", "FALSE");
        }
        return status;
    }
}
