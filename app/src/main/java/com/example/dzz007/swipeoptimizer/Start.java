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
                startActivity(new Intent(Start.this, Choose_Category.class));
            }
        });

    }
}
