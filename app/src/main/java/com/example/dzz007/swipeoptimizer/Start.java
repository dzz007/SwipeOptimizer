package com.example.dzz007.swipeoptimizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setTitle("Please select a location");

        Button btnRock = (Button) findViewById(R.id.btnRock);
        Button btnHenrys= (Button) findViewById(R.id.btnHenrys);
        Button btnSBTruck= (Button) findViewById(R.id.btnSBTruck);

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Choose_Category.class);
                i.putExtra("location", 1);
                i.putExtra("current_balance", 9.0);
                startActivity(i);
            }
        });

        btnHenrys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Choose_Category.class);
                i.putExtra("location", 2);
                i.putExtra("current_balance", 10.0);
                startActivity(i);
            }
        });

        btnSBTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Choose_Category.class);
                i.putExtra("location", 3);
                i.putExtra("current_balance", 9.0);
                startActivity(i);
            }
        });

    }
}
