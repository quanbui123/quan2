package com.example.quanph20506.theservice;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.nio.channels.Channel;

public class myaplication extends Application {
public static final String CHANER =  "cs";
//khoi tao chanel_id amimation chay amination
    @Override
    public void onCreate() {
        super.onCreate();
        createChannel();
    }

    private void createChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel(CHANER,"chanel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager= getSystemService(NotificationManager.class);
            if (manager!=null){
                manager.createNotificationChannel(channel);
            }

        }
    }
}
