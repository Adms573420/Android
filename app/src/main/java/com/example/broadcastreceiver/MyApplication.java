package com.example.broadcastreceiver;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {


    public final static String CHANNEL_1= "CHANNEL 1";
    public final static String CHANNEL_2= "CHANNEL 2";
    @Override
    public void onCreate() {
        super.onCreate();
        CreateNotificationChannel();
    }

    private void CreateNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel cahnnel1=new NotificationChannel(CHANNEL_1,"Channel 1",
                    NotificationManager.IMPORTANCE_HIGH);
            cahnnel1.setDescription("This is Channel 1");

            NotificationChannel cahnnel2=new NotificationChannel(CHANNEL_2,"Channel 2",
                    NotificationManager.IMPORTANCE_LOW);
            cahnnel2.setDescription("This is Channel 2");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(cahnnel1);
            manager.createNotificationChannel(cahnnel2);
        }

    }
}
