package com.example.dzz007.swipeoptimizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


public class Choose_Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__food);


        Intent i = getIntent();
        int location = i.getIntExtra("location",1);
        int type = i.getIntExtra("type", 1);
        double current_balance = i.getDoubleExtra("current_balance", 10.0);

        String TAG = "message";
        Log.d(TAG,"Location: "+location+"\tType: "+type+"\tBalance: "+current_balance);

        SQLiteDatabaseHandler sq = new SQLiteDatabaseHandler(this);
        try {
            sq.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sq.openDataBase();
        final ArrayList<Item> item_list = sq.returnData(location, type, current_balance);

        final HashMap<String, Double> item_hash = new HashMap<>();
        final ArrayList<String> name_list = new ArrayList<>();
        ArrayAdapter<String> item_adapter;
        ListView item_lv = (ListView)findViewById(R.id.item_list);
        item_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, name_list);

        for(int c = 0; c<item_list.size();c++){

                name_list.add(item_list.get(c).item_name+"\t("+item_list.get(c).item_price+")");
                item_adapter.notifyDataSetChanged();
                item_hash.put(item_list.get(c).item_name+"\t("+item_list.get(c).item_price+")", item_list.get(c).item_price);

        }


        item_lv.setAdapter(item_adapter);
        item_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent returnIntent = new Intent();
                returnIntent.putExtra("return_item_name", name_list.get(position));
                returnIntent.putExtra("return_item_price", item_hash.get(name_list.get(position)));
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });



    }
}
