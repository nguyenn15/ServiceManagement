package com.example.a300273215.admin;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import ORM.RequestOrder;
import model.ListItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import Service.FactoryServiceAPI;
import Service.RequestOrderApi;

/**
 * Created by 300273215 on 7/23/2018.
 */

public class MyService extends Service {
    Timer timer;
    private NotificationManager notifier = null;
    private static final int GPS_NOTIFY = 0x1001;

    private int count;
    private CountInterface con;
    private static final String NOTIFICATION_CHANNEL_ID
            = "my_notification_channel";

    @Override
    public void onStart(final Intent intent, final int startId) {
        super.onStart(intent, startId);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Your database code here
                Count(intent, startId);
            }
            },2000,2000);


        }

        @Override
        public void onCreate () {
            super.onCreate();


            timer = new Timer();

            notifier = (NotificationManager) getSystemService(
                    Context.NOTIFICATION_SERVICE
            );

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel
                        = new NotificationChannel(
                        NOTIFICATION_CHANNEL_ID,
                        "My notification",
                        NotificationManager.IMPORTANCE_DEFAULT
                );
                notificationChannel.setDescription("Channel Description");
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setVibrationPattern(
                        new long[]{0, 1000, 500, 1000});
                notificationChannel.enableVibration(true);
                notifier.createNotificationChannel(notificationChannel);
            }


        }

    private void Count(final Intent intent, final int startId) {

        final List<ListItem> listItems = new ArrayList<>();
        try {
            RequestOrderApi requestorderApi = FactoryServiceAPI.GetRequesetOrderApi();
            Map<String, String> params = new HashMap<String, String>();
            params.put("Status", RequestOrder.STATUS.PENDING.getValue() + "");

            Call<List<RequestOrder>> requestorders = requestorderApi.byStatus(params);


            requestorders.enqueue(new Callback<List<RequestOrder>>() {
                @Override
                public void onResponse(Call<List<RequestOrder>> call, Response<List<RequestOrder>> response) {
                    List<RequestOrder> requestOrders = response.body();
                    /// add to list here
                    //Toast.makeText(AdminHomePage.this, "request Order" + requestOrders.get(0), Toast.LENGTH_SHORT).show();
                    //  SetDataSourceFragment1(requestOrders);


                    for (RequestOrder tp : requestOrders) {
                        Log.i("data", tp.getIdRequest() + "");
                        ListItem listItem = new ListItem(tp.getIdRequest(), tp.getStatus().toString(), tp.getIdCustomer());
                        listItems.add(listItem);
                    }
                    SharedPreferences old = getSharedPreferences("firstcount", MODE_PRIVATE);
                    int oldCount = old.getInt("firstcount", MODE_PRIVATE);
                    int newCount = listItems.size();
                   // Log.e("new count", newCount + "");
                   // Log.e("old count", oldCount + "");
                    if (newCount > oldCount && oldCount != -1) {
                      //  Log.e("Kyu aa rhi", "arsh");
                        doServiceStart(intent, startId);


                    }

/*
                    SharedPreferences.Editor editor = getSharedPreferences("newcount", MODE_PRIVATE).edit();
                    editor.putInt("newcount", count);
                    editor.apply();*/
                }

                @Override
                public void onFailure(Call<List<RequestOrder>> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void doServiceStart(Intent intent, int startId) {

        SharedPreferences old = getSharedPreferences("login", MODE_PRIVATE);
        String check = old.getString("login", "");
        Log.i("check value",check);
        Intent toLaunch=null;
        PendingIntent intentBack;

        if (check.equals("Login")) {

             toLaunch = new Intent(getApplicationContext(),
                    AdminHomePage.class);

        }
        else if (check.equals("Logout"))
        {
             toLaunch = new Intent(getApplicationContext(),
                    LoginActivity.class);


        }

        intentBack = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                toLaunch,
                0
        );
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(
                                getApplicationContext(),
                                NOTIFICATION_CHANNEL_ID
                        );
                builder.setTicker("New Request");
                builder.setSmallIcon(android.R.drawable.stat_notify_more);
                builder.setWhen(System.currentTimeMillis());
                builder.setContentTitle("New Request");
                builder.setContentText(
                        "Request from customer"
                );
                builder.setContentIntent(intentBack);
                builder.setAutoCancel(true);
                Notification notify = builder.build();
                notifier.notify(GPS_NOTIFY, notify);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}

