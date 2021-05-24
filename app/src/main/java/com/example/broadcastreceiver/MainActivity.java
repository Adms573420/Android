package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
EditText edtTitle,edtContent;
NotificationManagerCompat manager;
int notificationid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        manager=NotificationManagerCompat.from(this);
        edtTitle=findViewById(R.id.edtTitle);
        edtContent=findViewById(R.id.edtContent);

    }


    public void SendChannel1(View view) {
        createNotification(MyApplication.CHANNEL_1);
    }

    private void createNotification(String ChannelId) {
        String title=edtTitle.getText().toString();
        String content=edtContent.getText().toString();
       notificationid++;
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,ChannelId);
       Notification notification= builder.setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(Notification.PRIORITY_HIGH)
                .setCategory(Notification.CATEGORY_MESSAGE)
               .setOngoing(true)
                .build();
       manager.notify(0,notification);
        Log.d(TAG, "createNotification: "+notificationid);
    }


    public void SendChannel2(View view) {
        createNotification(MyApplication.CHANNEL_2);
    }

    public void cancelNot(View view) {
        if(notificationid<1)
            return;
        manager.cancel(0);
        notificationid--;
        Log.d(TAG, "cancelNot: "+notificationid);

    }
}