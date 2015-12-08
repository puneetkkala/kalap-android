package com.kalapuneet.boundservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.kalapuneet.boundservice.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {

    MyService kalapService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i,kalapConnection,Context.BIND_AUTO_CREATE);
    }

    public void showTime(View view){
        String currentTime = kalapService.getCurrentTime();
        TextView timeTxt = (TextView) findViewById(R.id.timeTxt);
        timeTxt.setText(currentTime);
    }

    private ServiceConnection kalapConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            kalapService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
