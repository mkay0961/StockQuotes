package com.example.matthewkay.stockquotes;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by MatthewKay on 3/13/18.
 */

public class asyncTask extends AsyncTask<String, String, String> {


    private TextView Symbol, Name, TradePrice, TradeTime, Change, WeekRange;
    private Context context;
    ArrayList<String> arrayList;

    public asyncTask(TextView Symbol, TextView Name, TextView TradePrice, TextView TradeTime, TextView Change, TextView WeekRange, Context context) {
        this.Symbol = Symbol;
        this.Name = Name;
        this.TradePrice = TradePrice;
        this.TradeTime = TradeTime;
        this.Change = Change;
        this.WeekRange = WeekRange;
        this.context = context;
        Log.i("test","been constructed");
    };


    @Override
    protected String doInBackground(String ... strings) {
        arrayList = new ArrayList<>();
        Stock stock;

        String rtn = "";
        Log.i("test","makeing stock");

        stock = new Stock(strings[0]);

        try {
            stock.load();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        Log.i("test","about to add to array");
        //Log.i("test","trying to find sybmol" + stock.getName());

        try {
            arrayList.add(stock.getSymbol());
            arrayList.add(stock.getName());
            arrayList.add(stock.getLastTradePrice());
            arrayList.add(stock.getLastTradeTime());
            arrayList.add(stock.getChange());
            arrayList.add(stock.getRange());

        }
        catch(Exception e){
            Log.i("j", "ERRROROOROOROR");
            Toast.makeText(context, "You Entered A Invalid Symbol", LENGTH_SHORT).show();
        }
        Log.i("test","done adding to array");

        return rtn;




    }



    @Override
    protected void onPostExecute(String string) {
        Log.i("test","about to try and set ");

        //problem
        if(arrayList.get(1) != null) {
            Name.setText(arrayList.get(1));
            Symbol.setText(arrayList.get(0));
            TradePrice.setText(arrayList.get(2));
            TradeTime.setText(arrayList.get(3));
            Change.setText(arrayList.get(4));
            WeekRange.setText(arrayList.get(5));
        }
        else {
            Toast.makeText(context, "YOU ENTERED A WRONG SYMBOL", LENGTH_SHORT).show();

        }


        Log.i("test","set");





    }



}



