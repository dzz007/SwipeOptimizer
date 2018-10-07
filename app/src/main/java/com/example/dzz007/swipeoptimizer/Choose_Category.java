package com.example.dzz007.swipeoptimizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Choose_Category extends AppCompatActivity {

    ArrayList<String> entrees_list = new ArrayList<>();
    ArrayAdapter<String> entrees_adapter;
    ArrayList<String> drinks_list = new ArrayList<>();
    ArrayAdapter<String> drinks_adapter;
    ArrayList<String> snacks_list = new ArrayList<>();
    ArrayAdapter<String> snacks_adapter;

    int location;
    double current_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__category);
        setTitle("Swipe Optimizer                   $4.87/$9.00");

        Intent i = getIntent();
        location = i.getIntExtra("location",1);
        current_balance = i.getDoubleExtra("current_balance", 10.0);

        ListView entrees_lv = (ListView)findViewById(R.id.entrees_list);
        entrees_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, entrees_list);

        ListView drinks_lv = (ListView)findViewById(R.id.drinks_list);
        drinks_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, drinks_list);

        ListView snacks_lv = (ListView)findViewById(R.id.snacks_list);
        snacks_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, snacks_list);

        entrees_list.add("Add New");
        drinks_list.add("Add New");
        snacks_list.add("Add New");

        entrees_lv.setAdapter(entrees_adapter);
        entrees_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(entrees_list.get(position).equals("Add New")){

                    Intent i = new Intent(Choose_Category.this, Choose_Food.class);
                    i.putExtra("location", location);
                    i.putExtra("type", 1);
                    i.putExtra("current_balance", current_balance);
                    startActivity(i);

                }

            }
        });

        drinks_lv.setAdapter(drinks_adapter);
        drinks_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(drinks_list.get(position).equals("Add New")){

                    Intent i = new Intent(Choose_Category.this, Choose_Food.class);
                    i.putExtra("location", location);
                    i.putExtra("type", 2);
                    i.putExtra("current_balance", current_balance);
                    startActivity(i);

                }

            }
        });

        snacks_lv.setAdapter(snacks_adapter);
        snacks_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(snacks_list.get(position).equals("Add New")){

                    Intent i = new Intent(Choose_Category.this, Choose_Food.class);
                    i.putExtra("location", location);
                    i.putExtra("type", 3);
                    i.putExtra("current_balance", current_balance);
                    startActivity(i);

                }

            }
        });

    }
}
