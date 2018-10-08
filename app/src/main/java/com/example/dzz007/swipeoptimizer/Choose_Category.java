package com.example.dzz007.swipeoptimizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Choose_Category extends AppCompatActivity {

    ArrayList<String> entrees_list = new ArrayList<>();
    ArrayList<Double> entrees_list_prices = new ArrayList<>();
    ArrayAdapter<String> entrees_adapter;
    ArrayList<String> drinks_list = new ArrayList<>();
    ArrayList<Double> drinks_list_prices = new ArrayList<>();
    ArrayAdapter<String> drinks_adapter;
    ArrayList<String> snacks_list = new ArrayList<>();
    ArrayList<Double> snacks_list_prices = new ArrayList<>();
    ArrayAdapter<String> snacks_adapter;
    ListView entrees_lv;
    ListView drinks_lv;
    ListView snacks_lv;

    double current_balance;
    double max_balance;
    int location;

    private void execute(int type) {
        Intent i = new Intent(Choose_Category.this, Choose_Food.class);
        i.putExtra("location", location);
        i.putExtra("type", type);
        i.putExtra("current_balance", current_balance);
        startActivityForResult(i, type);
    }

    private void changeTitle(double balance) {
        setTitle("Swipe Optimizer  $"+((double)Math.round(balance*100.0)/100.0)+" Left");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(resultCode == RESULT_CANCELED)
            return;
        if(resultCode == RESULT_FIRST_USER) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("NO ITEMS LEFT WITHIN BUDGET").setMessage("Look's like there are no " +
                    "items left in this category within your remaining balance.\nTap an item to remove" +
                    " it and try again.").show();
            return;
        }

            if(requestCode==1){

                entrees_list.add(0, data.getStringExtra("return_item_name"));
                entrees_adapter.notifyDataSetChanged();
                current_balance-=data.getDoubleExtra("return_item_price",0);
                entrees_list_prices.add(0,data.getDoubleExtra("return_item_price",0));
                entrees_lv.setSelection(entrees_lv.getCount()-1);

            }

            if(requestCode==2){

                drinks_list.add(0, data.getStringExtra("return_item_name"));
                drinks_adapter.notifyDataSetChanged();
                current_balance-=data.getDoubleExtra("return_item_price",0);
                drinks_list_prices.add(0,data.getDoubleExtra("return_item_price",0));
                drinks_lv.setSelection(drinks_lv.getCount()-1);

            }

            if(requestCode==3){

                snacks_list.add(0, data.getStringExtra("return_item_name"));
                snacks_adapter.notifyDataSetChanged();
                current_balance-=data.getDoubleExtra("return_item_price",0);
                snacks_list_prices.add(0,data.getDoubleExtra("return_item_price",0));
                snacks_lv.setSelection(snacks_lv.getCount()-1);

            }

            changeTitle(current_balance);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__category);


        Intent i = getIntent();
        location = i.getIntExtra("location",1);
        current_balance = i.getDoubleExtra("current_balance", 10.0);
        changeTitle(current_balance);
        max_balance = current_balance;


        entrees_lv = (ListView)findViewById(R.id.entrees_list);
        entrees_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, entrees_list);

        drinks_lv = (ListView)findViewById(R.id.drinks_list);
        drinks_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, drinks_list);

        snacks_lv = (ListView)findViewById(R.id.snacks_list);
        snacks_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, snacks_list);

        entrees_list.add("Add New");
        drinks_list.add("Add New");
        snacks_list.add("Add New");

        entrees_lv.setAdapter(entrees_adapter);
        entrees_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(entrees_list.get(position).equals("Add New")){

                    execute(1);

                }else{

                        current_balance+=entrees_list_prices.get(position);
                        entrees_list.remove(position);
                        entrees_list_prices.remove(position);
                        entrees_adapter.notifyDataSetChanged();
                        changeTitle(current_balance);

                }

            }
        });

        drinks_lv.setAdapter(drinks_adapter);
        drinks_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(drinks_list.get(position).equals("Add New")){
                    execute(2);
                }else{

                    current_balance+=drinks_list_prices.get(position);
                    drinks_list.remove(position);
                    drinks_list_prices.remove(position);
                    drinks_adapter.notifyDataSetChanged();
                    changeTitle(current_balance);
                }

            }
        });

        snacks_lv.setAdapter(snacks_adapter);
        snacks_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(snacks_list.get(position).equals("Add New")){
                    execute(3);
                }else{

                    current_balance+=snacks_list_prices.get(position);
                    snacks_list.remove(position);
                    snacks_list_prices.remove(position);
                    snacks_adapter.notifyDataSetChanged();
                    changeTitle(current_balance);
                }

            }
        });

    }
}
