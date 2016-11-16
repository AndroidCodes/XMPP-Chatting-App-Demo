package com.example.xmpp_chatting_app_demo;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.xmpp_chatting_app_demo.xmpp.SimpleDateFormatThreadSafe;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by peacock on 6/10/16.
 */

public class Common {

    //mytesting@conference.peacock   --> alex, raj, ritesh     --> 123
    //testingRoom@conference.peacock --> mayank, bhavesh, ajay --> 123

    public static final String DOMAIN = "192.168.168.219";

    public static final String CHAT_USERNAME = "raj";

    public static final String PASSWORD = "123";

    public static final String CHAT_ROOM = "mytesting@conference.peacock";

    //public static final String NICK_NAME = "bhavesh";

    public static final String sharedPreferences = "test";

    public static final String isApplicationOpen = "is_application_open";

    public static final String isFragmentOpen = "is_fragment_open";

    public static final String isAppInRecent = "is_app_in_recent";

    public static final String gotHistory = "got_history";

    public static final String killedFromRecent = "killed_from_recent";

    public static final String isDiconnected = "is_disconnected";

    //public static final String unreadMessagesCount = "unread_meassages_count";

    public static int TYPE_WIFI = 1;

    public static int TYPE_MOBILE = 2;

    public static int TYPE_NOT_CONNECTED = 0;

    public static long getDateInMills(String date) {

        SimpleDateFormatThreadSafe sdf = new
                SimpleDateFormatThreadSafe("EEE MMM dd HH:mm:ss z yyyy");

        try {

            Date mDate = sdf.parse(date);

            return mDate.getTime();

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return 0;

    }

    public static int getConnectivityStatus(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork && activeNetwork.isConnectedOrConnecting()) {

            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;

        }
        return TYPE_NOT_CONNECTED;
    }

    public static boolean getConnectivityStatusString(Context context) {

        int connection = getConnectivityStatus(context);

        boolean status = false;

        status = connection == TYPE_WIFI || connection == TYPE_MOBILE ||
                connection != TYPE_NOT_CONNECTED;

        return status;
    }

    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {

        ActivityManager manager = (ActivityManager) context.
                getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningServiceInfo service : manager.
                getRunningServices(Integer.MAX_VALUE)) {

            if (serviceClass.getName().equals(service.service.getClassName())) {

                return true;

            }
        }

        return false;

    }
}
