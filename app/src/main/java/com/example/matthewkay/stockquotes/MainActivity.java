package com.example.matthewkay.stockquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView symbol, name, price, time, change, range;
    EditText text;
    asyncTask task;

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
        text = (EditText) findViewById(R.id.search);
        Log.i("test","making task");

        Log.i("test","execueting");
        //task.execute("GOOG");
        Log.i("h", "executed");
        //Log.i("he", (String) symbol.getText());
        text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP)) {
                    Log.i("h", "enter !!!!!!!!!");
                    Log.i("h", String.valueOf(text.getText()).trim());

                    task = new asyncTask(symbol,name,price,time,change,range,getApplicationContext());
                    task.execute(String.valueOf(text.getText()).trim().toUpperCase());
                    //Toast.makeText(, text.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        Log.i("h", "click listen");
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
