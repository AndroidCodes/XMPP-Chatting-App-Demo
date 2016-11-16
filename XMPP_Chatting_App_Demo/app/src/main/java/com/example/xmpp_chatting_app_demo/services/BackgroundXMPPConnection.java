package com.example.xmpp_chatting_app_demo.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;

import com.example.xmpp_chatting_app_demo.Common;
import com.example.xmpp_chatting_app_demo.xmpp.BackgroundXMPP;

/**
 * Created by peacock on 8/10/16.
 */

public class BackgroundXMPPConnection extends Service {

    private static BackgroundXMPP backgroundXMPP;

    private ConnectivityManager connectivityManager;

    private PendingIntent pendGps;

    private AlarmManager manager;

    private SharedPreferences preferences;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Looper.prepare();

                preferences = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE);

                connectivityManager = (ConnectivityManager) getSystemService(Context.
                        CONNECTIVITY_SERVICE);

                if (Common.getConnectivityStatusString(BackgroundXMPPConnection.this)) {

                    backgroundXMPP = new BackgroundXMPP(BackgroundXMPPConnection.this,
                            Common.DOMAIN, Common.CHAT_USERNAME, Common.PASSWORD);
                    backgroundXMPP.connect();

                }

                System.out.println("Background_OnCreate --> Background Service Started");

            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        /* if service is stopped working(not by calling stopService) due to other assistance then
           because of following code it will be restarted automatically. */
        PendingIntent restartService = PendingIntent.getService(this, 0,
                new Intent(this, BackgroundXMPPConnection.class), Intent.FILL_IN_ACTION);

        manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 1000;
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, System.currentTimeMillis(),
                interval, restartService);

        return START_STICKY;

    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {

        super.onTaskRemoved(rootIntent);

        preferences.edit().putString(Common.killedFromRecent, "true").commit();
        preferences.edit().putString(Common.isFragmentOpen, "false").commit();
        preferences.edit().putString(Common.isAppInRecent, "false").commit();
        preferences.edit().putString(Common.isApplicationOpen, "false").commit();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        try {

        } catch (Exception e) {

            System.out.println("BackgroundService_OnDestroyException --> " + e.getMessage());

        }
    }
}
