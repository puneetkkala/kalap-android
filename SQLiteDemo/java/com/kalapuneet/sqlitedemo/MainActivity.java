package com.kalapuneet.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText dbInp;
    TextView dbTxt;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbInp = (EditText) findViewById(R.id.dbInp);
        dbTxt = (TextView) findViewById(R.id.dbTxt);

        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addClick(View view){
        Products product = new Products(dbInp.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void delClick(View view){
        String inputText = dbInp.getText().toString();
        dbHandler.deleteProduct(inputText);
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        dbTxt.setText(dbString);
        dbInp.setText("");
    }
}
