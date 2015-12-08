package com.kalapuneet.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder kalapBinder = new MyLocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return kalapBinder;
    }

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss",Locale.ENGLISH);
        return (df.format(new Date()));
    }

    public class MyLocalBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }
}
