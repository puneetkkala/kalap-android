package com.kalapuneet.intentservicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Apple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
    }

    public void appleClick(View view){
        Intent i = new Intent(getApplicationContext(),Mango.class);
        startActivity(i);
    }
}
