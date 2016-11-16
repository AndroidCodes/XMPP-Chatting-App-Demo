package com.example.xmpp_chatting_app_demo.xmpp;

/*import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.chat_module.dataBase.AppDataBase;
import com.common.Common;
import com.srk.HomeActivity;
import com.srk.R;
import com.util.SharedPrefUtility;
import com.util.global.Global;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.muc.DiscussionHistory;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.jivesoftware.smackx.receipts.DeliveryReceiptManager;
import org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AutoReceiptMode;
import org.jivesoftware.smackx.receipts.ReceiptReceivedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;*/

public class BackgroundXMPP_From_app {

    /*public static ArrayList<String> testMessage = null;

    private static XMPPTCPConnection connection;

    private int unreadMessageCount = 0;

    private ChatManagerListenerImpl mChatManagerListener;

    private String loginUser, passwordUser;

    private Context context;

    private AppDataBase dbHelper;

    private String serverAddress;

    private DiscussionHistory history;

    private SharedPrefUtility prefUtility;*/

    /*public BackgroundXMPP_From_app(Context context, String serverAdress, String logiUser,
                                        String passwordser) {

        this.serverAddress = serverAdress;

        this.loginUser = logiUser;

        this.passwordUser = passwordser;

        this.context = context;

        testMessage = new ArrayList<>();

        init();

    }*/

    /*public static void sendMsgtoGroup(String msg) {

        try {

            if (connection.isAuthenticated()) {

                MultiUserChatManager muc = MultiUserChatManager.getInstanceFor(connection);

                MultiUserChat chat = muc.getMultiUserChat(Common.CHAT_ROOM);

                Message message = new Message(Common.CHAT_ROOM, Message.Type.groupchat);
                message.setFrom(Common.CHAT_USERNAME);
                message.setBody(msg);

                chat.sendMessage(message);

            } else {

                System.out.println("SendMsgError --> Client Not Connected");

            }
        } catch (Exception e) {

            System.out.println("SendMsgException --> " + e.getMessage());

        }
    }

    public static void disconnect() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                connection.disconnect();
            }
        }).start();

    }*/

    /*public void init() {

        prefUtility = new SharedPrefUtility(context);

        dbHelper = new AppDataBase(context);

        mChatManagerListener = new ChatManagerListenerImpl();

        if (Global.getConnectivityStatusString(context)) {

            initialiseConnection();

        }
    }*/

    //private void initialiseConnection() {

        /*final XMPPTCPConnectionConfiguration connConfig = XMPPTCPConnectionConfiguration.builder().
                setHost(serverAddress).setPort(5222).setDebuggerEnabled(true).
                setSecurityMode(ConnectionConfiguration.SecurityMode.disabled).
                setUsernameAndPassword(loginUser, passwordUser).setServiceName(serverAddress).
                build();

        XMPPTCPConnection.setUseStreamManagementDefault(true);
        XMPPTCPConnection.setUseStreamManagementResumptionDefault(true);

        connection = new XMPPTCPConnection(connConfig);
        connection.setUseStreamManagement(true);
        connection.setUseStreamManagementResumption(true);

        XMPPConnectionListener connectionListener = new XMPPConnectionListener();

        connection.addConnectionListener(connectionListener);
        connection.setPacketReplyTimeout(XMPPTCPConnectionConfiguration.DEFAULT_CONNECT_TIMEOUT);

        connection.addStanzaAcknowledgedListener(new StanzaListener() {
            @Override
            public void processPacket(Stanza packet) throws NotConnectedException {

                String id = packet.getStanzaId();

                if (StringUtils.isNullOrEmpty(id)) {

                    return;

                }
            }
        });*/


    /* If connection with xmpp server is clesed due to any assistance then because of following
           code itself it will try to reconnect to the server. Everytime it will call
           reconnectingIn(int arg0) method(See below XMPPConnectionListener class)*/
        /*ReconnectionManager reconnectionManager = ReconnectionManager.getInstanceFor(connection);
        reconnectionManager.setEnabledPerDefault(true);
        reconnectionManager.enableAutomaticReconnection();
        reconnectionManager.setReconnectionPolicy(ReconnectionManager.ReconnectionPolicy.
                FIXED_DELAY);*/

        //connection.addSyncStanzaListener(new StanzaListener() {

            /*@Override
            public void processPacket(Stanza packet) throws NotConnectedException {

                System.out.println("ChatApp -- BackgroundXMPP -- addSyncStanzaListener --> " +
                        Common.isApplicationOpen + " = " + prefUtility.
                        getString(Common.isApplicationOpen) + ", " + Common.isFragmentOpen + " = "
                        + prefUtility.getString(Common.isFragmentOpen) + ", " + Common.isAppInRecent
                        + " = " + prefUtility.getString(Common.isAppInRecent) + ", " +
                        Common.killedFromRecent + " = " + prefUtility.getString(Common.
                        killedFromRecent));

                Message message = (Message) packet;

                System.out.println("ChatApp_stanza --> " + message.getBody());

                String getSender = message.getFrom();
                String[] splitSender = new String[2];
                splitSender = getSender.split("/");

                String sender = splitSender[1];
                if (sender.contains("@")) {

                    sender = sender.split("@")[0];

                }

                String isMsgRead = null;

                if (sender.equals(Common.CHAT_USERNAME) || prefUtility.getString(Common.
                        isFragmentOpen).equals("true")) {

                    isMsgRead = "true";

                } else {

                    isMsgRead = "false";

                }*/

                /* msg format : saveSearchIDNNO;@;action;@;msg
                   Note : if (action == "S") then saveSearchIDNNO'll give saveSearchIDNNO otherwise
                   saveSearchIDNNO = "0". */
                /*String msg = message.getBody();
                if (msg != null && !msg.equals("")) {

                    if (msg.contains(";@;") && (prefUtility.getString(Common.isAppInRecent).
                            equals("true") || prefUtility.getString(Common.isApplicationOpen).
                            equals("false"))) {

                        System.out.println("ChatApp --> XMPP -- \";@;\" CONTAINS, " + sender);

                        String[] splitMessage = msg.split(";@;");

                        String saveSearchIDNNO = null;
                        saveSearchIDNNO = splitMessage[0];

                        String action = splitMessage[1];

                        msg = splitMessage[2];

                        System.out.println("ChatApp --> XMPP, inside -- " + action + ", " + msg);

                        sendSystemNotification(msg, action, saveSearchIDNNO);

                    }
                }

                String subString = sender.substring(sender.lastIndexOf("/") + 1, sender.length());

                DelayInformation delay = message.getExtension("delay", "urn:xmpp:delay");

                if (delay == null) {

                    delay = message.getExtension("x", "jabber:x:delay");

                }

                long time = 0;

                if (delay == null)
                    time = System.currentTimeMillis();
                else
                    time = Common.getDateInMills(delay.getStamp().toString());

                System.out.println("Notification_Messages --> " + message.getBody());

                if (msg != null && !msg.equals("") && msg.length() > 0 && !sender.equals("admin")
                        && !sender.equals("Spark")) {

                    dbHelper.insertMessagesToDB(Common.CHAT_USERNAME, Common.CHAT_ROOM, "1",
                            subString, msg, String.valueOf(time), isMsgRead);

                    if (prefUtility.getString(Common.isApplicationOpen).equals("false") ||
                            (prefUtility.getString(Common.isFragmentOpen).equals("true") &&
                                    prefUtility.getString(Common.isAppInRecent).equals("true"))) {

                        // Code For Notification
                        System.out.println("ChatApp --> XMPP -- App is Closed, " +
                                message.getBody());

                        String notificationMessage = sender.concat(" : ").concat(message.getBody());

                        testMessage.add(notificationMessage);

                        chatMessagesNotification(testMessage);
                        //sendSystemNotification(msg);

                    } else {

                        if (prefUtility.getString(Common.isFragmentOpen).equals("true") &&
                                prefUtility.getString(Common.isAppInRecent).equals("false")) {

                            unreadMessageCount = 0;

                            Intent broadCastChat = new Intent("update_chat_list");
                            broadCastChat.putExtra("live_chat_broadcast",
                                    "live_chat_broadcast_success");
                            broadCastChat.putExtra("user_id", Common.CHAT_USERNAME);
                            broadCastChat.putExtra("group_name", Common.CHAT_ROOM);
                            broadCastChat.putExtra("msg_id", "1");
                            broadCastChat.putExtra("sender", subString);
                            broadCastChat.putExtra("message", msg);
                            broadCastChat.putExtra("date_time", String.valueOf(time));
                            broadCastChat.putExtra("is_msg_read", "true");
                            LocalBroadcastManager.getInstance(context).sendBroadcast(broadCastChat);

                        } else {

                            // Code For Badges
                            if (isMsgRead.equals("false")) {

                                if (!prefUtility.getString(Common.unreadMessagesCount).
                                        equals("0")) {

                                    unreadMessageCount++;

                                    prefUtility.setString(Common.unreadMessagesCount,
                                            String.valueOf(unreadMessageCount));

                                } else {

                                    unreadMessageCount = 0;

                                    unreadMessageCount++;

                                    prefUtility.setString(Common.unreadMessagesCount,
                                            String.valueOf(unreadMessageCount));

                                }

                                System.out.println("ChatApp -- XMPP --> " + prefUtility.
                                        getString(Common.unreadMessagesCount));

                                Intent updateBadges = new Intent("update_badges_broadcast");
                                updateBadges.putExtra("udate_badge", "new_messages_recieved");
                                updateBadges.putExtra("badge_count",
                                        String.valueOf(unreadMessageCount));

                                prefUtility.setString(Common.unreadMessagesCount,
                                        String.valueOf(unreadMessageCount));

                                LocalBroadcastManager.getInstance(context).
                                        sendBroadcast(updateBadges);

                                if (prefUtility.getString(Common.isAppInRecent).equals("true")) {

                                    System.out.println("ChatApp --> XMPP -- App In Recent, Fragment " +
                                            "Closed, " + message.getBody());

                                    String notificationMessage = sender.concat(" : ").
                                            concat(message.getBody());

                                    testMessage.add(notificationMessage);

                                    chatMessagesNotification(testMessage);
                                    //sendSystemNotification(msg);

                                }
                            }
                        }
                    }

                    if (prefUtility.getString(Common.gotHistory).equals("false")) {

                        prefUtility.setString(Common.gotHistory, "true");

                    }
                }*/
            /*}
        }, new StanzaTypeFilter(Message.class));
    }*/

    //private void sendSystemNotification(String msg, String action, String saveSearchIDNNO) {

        /*int number = new Random().nextInt(9999);

        long when = System.currentTimeMillis();*/

        /*stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(HomeActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(number,
                PendingIntent.FLAG_ONE_SHOT);*/  //Working Code

        /*if (prefUtility.getString(Common.isAppInRecent).equals("true")) {

            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("finishActivity"));

        }

        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra("notificationTag", "true");
        intent.putExtra("action", action);
        if (action.equals("S") && (saveSearchIDNNO != null || !saveSearchIDNNO.equals("")) &&
                !saveSearchIDNNO.equals("0") && saveSearchIDNNO.length() > 0) {

            intent.putExtra("saveSearchIDNNO", saveSearchIDNNO);

        }

        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, number, intent,
                PendingIntent.FLAG_ONE_SHOT);  //Working Code

        NotificationManager mNotificationManager = (NotificationManager) context.
                getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mNotifyBuilder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            mNotifyBuilder = new NotificationCompat.Builder(context).setContentTitle(action).
                    setStyle(new NotificationCompat.BigTextStyle().bigText(msg)).
                    setDefaults(Notification.DEFAULT_ALL).setContentText(msg).setColor(Color.
                    TRANSPARENT).setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                    R.mipmap.notification_logo)).setSmallIcon(R.drawable.small_notification_logo).
                    setPriority(Notification.PRIORITY_HIGH).setWhen(when).setAutoCancel(true);

        } else {

            mNotifyBuilder = new NotificationCompat.Builder(context).
                    setStyle(new NotificationCompat.BigTextStyle().bigText(msg)).
                    setDefaults(Notification.DEFAULT_ALL).setContentTitle(action).
                    setContentText(msg).setLargeIcon(BitmapFactory.decodeResource(context.
                    getResources(), R.mipmap.notification_logo)).
                    setSmallIcon(R.drawable.small_notification_logo).setWhen(when).
                    setPriority(Notification.PRIORITY_HIGH).setAutoCancel(true);

        }

        // Set pending intent
        mNotifyBuilder.setContentIntent(resultPendingIntent);

        // Set Vibrate, Sound and Light
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        mNotifyBuilder.setSound(notification);
        long[] pattern = {500, 500, 500, 500};
        mNotifyBuilder.setVibrate(pattern);
        mNotifyBuilder.setLights(Notification.DEFAULT_LIGHTS, 1000, 1000);

        // now you can notify with newly created notification id
        mNotificationManager.notify(action, number, mNotifyBuilder.build());*/

    //}

    // Chatting Notification Like WhatsApp
    //private void chatMessagesNotification(ArrayList<String> msgsList) {

        /*long when = System.currentTimeMillis();

        PendingIntent chatMessagesPendingIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, HomeActivity.class), PendingIntent.FLAG_ONE_SHOT);  //Working Code

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(Common.CHAT_ROOM);
        if ((msgsList.size() - 6) <= 0) {

            for (int i = 0; i < msgsList.size(); i++) {

                inboxStyle.addLine(msgsList.get(i));

            }
        } else {

            for (int i = (msgsList.size() - 6); i < msgsList.size(); i++) {

                inboxStyle.addLine(msgsList.get(i));

            }
        }

        NotificationCompat.Builder mNotifyBuilder;

        if (msgsList.size() == 1) {

            inboxStyle.setSummaryText("" + msgsList.size() + " New Message");

        } else if (msgsList.size() > 1) {

            inboxStyle.setSummaryText("" + msgsList.size() + " New Messages");

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            if (msgsList.size() == 1) {

                mNotifyBuilder = new NotificationCompat.Builder(context).
                        setContentTitle(Common.CHAT_ROOM).setStyle(inboxStyle).
                        setDefaults(Notification.DEFAULT_ALL).setColor(Color.TRANSPARENT).
                        setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                                R.mipmap.notification_logo)).
                        setContentText(msgsList.get(0)).setGroupSummary(true).
                        setGroup("chatModule").setSmallIcon(R.drawable.small_notification_logo).
                        setCategory(NotificationCompat.CATEGORY_MESSAGE).
                        setPriority(Notification.PRIORITY_HIGH).setWhen(when).setAutoCancel(true);

            } else {

                mNotifyBuilder = new NotificationCompat.Builder(context).
                        setContentTitle(Common.CHAT_ROOM).setStyle(inboxStyle).
                        setDefaults(Notification.DEFAULT_ALL).setColor(Color.TRANSPARENT).
                        setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                                R.mipmap.notification_logo)).setContentText("" + msgsList.size() +
                        " New Messages").setSmallIcon(R.drawable.small_notification_logo).
                        setCategory(NotificationCompat.CATEGORY_MESSAGE).setGroupSummary(true).
                        setGroup("chatModule").setPriority(Notification.PRIORITY_HIGH).
                        setWhen(when).setAutoCancel(true);

            }
        } else {

            mNotifyBuilder = new NotificationCompat.Builder(context).
                    setContentTitle(Common.CHAT_ROOM).setStyle(inboxStyle).
                    setDefaults(Notification.DEFAULT_ALL).setColor(Color.TRANSPARENT).
                    setContentText("" + msgsList.size() + " New Message").
                    setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                            R.mipmap.notification_logo)).setGroupSummary(true).
                    setGroup("chatModule").setCategory(NotificationCompat.CATEGORY_MESSAGE).
                    setSmallIcon(R.drawable.small_notification_logo).setWhen(when).
                    setAutoCancel(true);

        }

        mNotifyBuilder.setContentIntent(chatMessagesPendingIntent);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        mNotifyBuilder.setSound(notification);
        long[] pattern = {500, 500, 500, 500};
        mNotifyBuilder.setVibrate(pattern);
        mNotifyBuilder.setLights(Notification.DEFAULT_LIGHTS, 1000, 1000);

        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(context);

        //to post your notification to the notification bar
        notificationManagerCompat.notify(0, mNotifyBuilder.build());*/

    //}

    /*public void connect() {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected synchronized Boolean doInBackground(Void... arg0) {

                if (Global.getConnectivityStatusString(context)) {

                    if (connection.isConnected())
                        return false;

                    try {

                        connection.connect();

                        DeliveryReceiptManager dm = DeliveryReceiptManager.
                                getInstanceFor(connection);
                        dm.setAutoReceiptMode(AutoReceiptMode.always);
                        dm.addReceiptReceivedListener(new ReceiptReceivedListener() {

                            @Override
                            public void onReceiptReceived(String fromid, String toid, String msgid,
                                                          Stanza packet) {

                                Message message = (Message) packet;

                                System.out.println("ReceiptReceivedListener --> " +
                                        message.getBody());

                            }
                        });

                        System.out.println("ChatApp_Connection --> Connected SuccessFully");

                        joinGroup();

                    } catch (Exception e) {

                        System.out.println("ChatApp_ConnectionException --> " + e.getMessage());

                        return false;

                    }
                }

                return true;

            }
        }.execute();
    }*/

    /*public void login() {

        try {

            Presence presence = new Presence(Presence.Type.available);

            connection.sendStanza(presence);
            connection.login(loginUser, passwordUser);

            DelayExtensionProvider.install();

            System.out.println("ChatApp -- XMPP_LoginSuccess --> Logged In Successfully");

        } catch (Exception e) {

            System.out.println("ChatApp -- XMPP_LoginException --> " + e.getMessage());

        }
    }*/

    /*public void joinGroup() {

        try {

            if (connection.isAuthenticated()) {

                MultiUserChatManager muc = MultiUserChatManager.getInstanceFor(connection);

                MultiUserChat chat = muc.getMultiUserChat(Common.CHAT_ROOM);

                if (prefUtility.getString(Common.gotHistory).equals("false")) {

                    history = new DiscussionHistory();
                    history.setSince(null);

                } else {

                    long maxTimeMillis = dbHelper.getMaxTimeMillis();

                    SimpleDateFormat df = new SimpleDateFormat("dd'-'MM'-'y hh:mm:ss.SSS aa");
                    df.setTimeZone(TimeZone.getTimeZone("GMT"));
                    String result = df.format(maxTimeMillis);
                    Date date = df.parse(result);

                    history = new DiscussionHistory();
                    history.setSince(date);

                    String str = prefUtility.getString(Common.killedFromRecent);

                    if (str.equals("true")) {

                        if (prefUtility.getString(Common.isDiconnected).equals("true")) {

                             //If net is disconnected and then connected again then to get only new
                             //messages.
                            history.setMaxStanzas(-1);

                            System.out.println("setStanzaDisconnect --> called");

                        } else {

                            history.setMaxStanzas(0);

                        }
                    } else {

                        history.setMaxStanzas(Integer.MIN_VALUE);

                    }

                    System.out.println("BackgroundXMPP_Else --> " + maxTimeMillis + ", " + result +
                            ", " + date + ", " + str);

                }

                if (!chat.isJoined()) {

                    chat.createOrJoin(Common.CHAT_USERNAME, null, history,
                            SmackConfiguration.getDefaultPacketReplyTimeout());

                }
            } else {

                System.out.println("ChapApp -- JoinGroupAuthenticationError --> " +
                        "Client Not Connected");

            }
        } catch (Exception e) {

            System.out.println("ChapApp -- JoinGroupException --> " + e.getMessage());

        }
    }*/

    /*private class ChatManagerListenerImpl implements ChatManagerListener {

        @Override
        public void chatCreated(final Chat chat, final boolean createdLocally) {

            Log.e("working", "admin " + createdLocally);
            chat.addMessageListener(new MessageListener(context));

        }
    }

    public class XMPPConnectionListener implements ConnectionListener {

        @Override
        public void connected(final XMPPConnection connection) {

            System.out.println("ChapApp -- XMPP_Connection --> Connected");

            if (Global.getConnectivityStatusString(context)) {

                if (!connection.isAuthenticated()) {

                    login();

                } else {

                }
            }
        }

        @Override
        public void connectionClosed() {

            System.out.println("ChapApp -- connectionClosed --> Connection Closed");

        }

        @Override
        public void connectionClosedOnError(Exception arg0) {

            System.out.println("ChapApp -- connectionClosedOnError --> Connection Closed On Error");

        }

        @Override
        public void reconnectingIn(int arg0) {

            System.out.println("ChapApp -- reconnectingIn --> ReconnectingIn");

            System.out.println("ChapApp -- reconnectingIn --> Reconnecting In " + arg0);

        }

        @Override
        public void reconnectionFailed(Exception arg0) {

            System.out.println("ChapApp -- reconnectionFailed --> Reconnection Failed");

        }

        @Override
        public void reconnectionSuccessful() {

            System.out.println("ChapApp -- reconnectionSuccessful --> Reconnected Successfully");

        }

        @Override
        public void authenticated(XMPPConnection arg0, boolean arg1) {

            Log.e("xmpp", "Authenticated!");

            ChatManager.getInstanceFor(connection).addChatListener(mChatManagerListener);

            new Thread(new Runnable() {

                @Override
                public void run() {

                    try {

                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        System.out.println("ChapApp -- authenticatedExceptin --> " +
                                e.getMessage());

                    }
                }
            }).start();
        }
    }

    private class MessageListener implements ChatMessageListener {

        public MessageListener(Context context) {
        }

        @Override
        public void processMessage(Chat chat, Message message) {

            if (message.getType() == Message.Type.chat && message.getBody() != null) {
            }
        }
    }*/
}