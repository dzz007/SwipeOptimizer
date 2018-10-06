package com.example.dzz007.swipeoptimizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Choose_Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__food);
        SQLiteDatabaseHandler hd = new SQLiteDatabaseHandler(getApplicationContext());
        try {
            hd.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        hd.openDataBase();
        Log.i("abc", String.valueOf(hd.returnData(1, 1, 100.00).size()));
    }
}
