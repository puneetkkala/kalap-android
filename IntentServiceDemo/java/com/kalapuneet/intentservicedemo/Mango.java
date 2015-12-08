package com.kalapuneet.intentservicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Mango extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mango);
    }

    public void mangoClick(View view){
        Intent i = new Intent(getApplicationContext(),Apple.class);
        startActivity(i);
    }
}
