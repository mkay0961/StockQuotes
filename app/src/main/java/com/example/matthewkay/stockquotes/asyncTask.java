package com.example.matthewkay.stockquotes;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
    };

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected ArrayList<String> doInBackground(String ... strings) {
        ArrayList<String> arrayList = new ArrayList<>();
        Stock stock;

        stock = new Stock(strings[0]);
        try {
            stock.load();
        }
        catch (Exception e) {
            onProgressUpdate();
        }

        arrayList.add(0, stock.getSymbol());
        arrayList.add(1,stock.getName());
        arrayList.add(2,stock.getLastTradePrice());
        arrayList.add(3,stock.getLastTradeTime());
        arrayList.add(4,stock.getChange());
        arrayList.add(5,stock.getRange());


        return arrayList;




    }



    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(arrayList);

        try {
            Symbol.setText(arrayList.get(0));
            Name.setText(arrayList.get(1));
            TradePrice.setText(arrayList.get(2));
            TradeTime.setText(arrayList.get(3));
            Change.setText(arrayList.get(4));
            WeekRange.setText(arrayList.get(5));
        }
        catch (Exception e){
            System.out.println(e);
        }





    }



}



