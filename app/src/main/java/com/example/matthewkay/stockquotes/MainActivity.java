package com.example.matthewkay.stockquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView symbol, name, price, time, change, range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        symbol = (TextView) findViewById(R.id.symdisplay);
        name = (TextView) findViewById(R.id.namedisplay);
        price = (TextView) findViewById(R.id.lastpricedisplay);
        time = (TextView) findViewById(R.id.lasttimedisplay);
        change = (TextView) findViewById(R.id.changedisplay);
        range = (TextView) findViewById(R.id.rangedisplay);
        asyncTask task = new asyncTask(symbol,name,price,time,change,range,this);
        task.execute("GOOG");
        Log.i("he", (String) symbol.getText());


    }












    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Symbol", symbol.getText().toString());
        savedInstanceState.putString("Name", name.getText().toString());
        savedInstanceState.putString("Price", price.getText().toString());
        savedInstanceState.putString("Time", time.getText().toString());
        savedInstanceState.putString("Change", change.getText().toString());
        savedInstanceState.putString("Range", range.getText().toString());

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        symbol.setText(savedInstanceState.getString("Symbol"));
        name.setText(savedInstanceState.getString("Name"));
        price.setText(savedInstanceState.getString("Price"));
        time.setText(savedInstanceState.getString("Time"));
        change.setText(savedInstanceState.getString("Change"));
        range.setText(savedInstanceState.getString("Range"));

    }


}
