package com.example.dzz007.swipeoptimizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Choose_Category.class));
            }
        }
        );
//        data.add("Abc");
//        data.add("Def");
//        ListView lv = (ListView)findViewById(R.id.myView);
//        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data);
//        lv.setAdapter(adapter);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                data.remove(position);
//                adapter.notifyDataSetChanged();
//            }
//        });
//
//        Button btn = (Button)findViewById(R.id.button5);
//        TextView textTotal = (TextView)findViewById(R.id.textTotal);
//        textTotal.setGravity(Gravity.CENTER);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                data.add("WTF?");
//                adapter.notifyDataSetChanged();
//            }
//        });
    }
}
