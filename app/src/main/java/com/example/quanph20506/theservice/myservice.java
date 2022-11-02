package com.example.quanph20506.theservice;

import static com.example.quanph20506.theservice.myaplication.CHANER;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class myservice extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("abc","oncrea");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }
    //fogrouservice chạy vào hàm onstartComand
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //lấy key tù main càn lấy dữ liệu
       String data=intent.getStringExtra("datainten");
       sendNotiofication(data);
        return START_NOT_STICKY;
    }

    private void sendNotiofication(String data) {
        //xác định nơi nhảy vào main
        Intent intent= new Intent(this,MainActivity.class);

        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification=new NotificationCompat.Builder(this,CHANER)
                //tên notification
                .setContentTitle("Title notification").setContentText(data)
                //iconnotifacation
                .setSmallIcon(R.drawable.ic_android_black_24dp)

                .setContentIntent(pendingIntent)
                .build();

startForeground(1,notification);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("abc","oncrea");
    }
}
