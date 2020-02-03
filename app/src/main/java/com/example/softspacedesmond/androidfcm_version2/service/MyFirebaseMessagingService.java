package com.example.softspacedesmond.androidfcm_version2.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.softspacedesmond.androidfcm_version2.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

public class MyFirebaseMessagingService extends FirebaseMessagingService
{
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData() != null || remoteMessage.getData().isEmpty())
        {
            sendNotification(remoteMessage);
//            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }
//        else if (remoteMessage.getData().size() > 0)
//        {
//            sendNotification2(remoteMessage);
//        }
//
        else if (remoteMessage.getNotification() != null)
        {
            sendNotification(remoteMessage.getNotification().getBody(), remoteMessage.getData());
        }
        else
        {
            sendNotification2(remoteMessage);
        }
    }

    private void sendNotification(RemoteMessage remoteMessage)
    {
        Map<String, String> data = remoteMessage.getData();
        String title = data.get("title");
        String content = data.get("content");

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "com.example.softspacedesmond.androidfcm_version2.test";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "FireBase_Notif", NotificationManager.IMPORTANCE_MAX);

            notificationChannel.setDescription("Fire_Notification");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_notification)
                .setTicker("Hearty365")
                .setContentTitle(title)
                .setContentText(content);

        notificationManager.notify(1, notificationBuilder.build());
    }

    private void sendNotification(String messageBody, Map<String, String> dataMap)
    {
//        PendingIntent pendingIntent = null;

        String title = dataMap.get("title");
        String content = dataMap.get("content");

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "com.example.softspacedesmond.androidfcm_version2.test";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "FireBase_Notif", NotificationManager.IMPORTANCE_MAX);

            notificationChannel.setDescription("Fire_Notification");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_notification)
                .setTicker("Hearty365")
                .setContentTitle(title)
                .setContentText(content);

        notificationManager.notify(1, notificationBuilder.build());
    }

    private void sendNotification2(RemoteMessage remoteMessage)
    {
        Map<String, String> data = remoteMessage.getData();
        String title = data.get("title");
        String content = data.get("content");

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "com.example.softspacedesmond.androidfcm_version2.test";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "FireBase_Notif", NotificationManager.IMPORTANCE_MAX);

            notificationChannel.setDescription("Fire_Notification");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_notification)
//                .setTicker("Hearty365")
                .setContentTitle(title)
                .setContentText(content);

        notificationManager.notify(1, notificationBuilder.build());
    }
}
