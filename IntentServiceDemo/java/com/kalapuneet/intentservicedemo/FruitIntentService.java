package com.kalapuneet.intentservicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class FruitIntentService extends IntentService {

    private static final String TAG = "com.kalapuneet";

    public FruitIntentService() {
        super("Fruit Intent Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        Log.i(TAG,"The service has now started");

    }
}
