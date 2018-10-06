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

    ArrayList<String> category_choose = new ArrayList<>();
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__category);

        category_choose.add("Entres");
        category_choose.add("Drinks");
        category_choose.add("Snacks");

        ListView lv = (ListView)findViewById(R.id.choose_category);
        ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, category_choose);

        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Choose_Category.this, Choose_Food.class));
            }
        });

    }
}
