package com.example.p_czyunchen.demo.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.example.p_czyunchen.demo.R;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String channelId = "chat";
            String name = "聊天信息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId,name,importance);

            channelId = "subscribe";
            name = "订阅";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId,name,importance);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(String id,String name,int importance){
        NotificationChannel channel = new NotificationChannel(id,name,importance);
        channel.setShowBadge(true);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void chatClick(View view) {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = manager.getNotificationChannel("chat");
            if(channel.getImportance()==NotificationManager.IMPORTANCE_NONE){
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE,getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID,channel.getId());
                startActivity(intent);
                Toast.makeText(this, "请手动打开通知", Toast.LENGTH_SHORT).show();
            }
        }
        Notification notification = new NotificationCompat.Builder(this,"chat")
                .setContentTitle("聊天消息")
                .setContentText("Do you have any time?")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setNumber(2)
                .setAutoCancel(true)
                .build();
        manager.notify(1,notification);
    }

    public void subscribeClick(View view) {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this,"chat")
                .setContentTitle("订阅通知")
                .setContentText("AI is coming.")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setNumber(3)
                .setAutoCancel(true)
                .build();
        manager.notify(2,notification);
    }
}
