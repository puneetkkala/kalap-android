package com.kalapuneet.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] foods = {"Poha Jalebi","Pav Bhaji","Chhola Bhatura","Vada Pav"};
        ListAdapter kalapAdapter = new CustomAdapter(this,foods);
        ListView kalapLst = (ListView) findViewById(R.id.kalapLstV);
        kalapLst.setAdapter(kalapAdapter);
        kalapLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this,food,Toast.LENGTH_LONG).show();
            }
        });
    }
}
