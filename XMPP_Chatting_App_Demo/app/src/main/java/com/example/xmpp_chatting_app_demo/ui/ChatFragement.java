package com.example.xmpp_chatting_app_demo.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.xmpp_chatting_app_demo.Common;
import com.example.xmpp_chatting_app_demo.R;
import com.example.xmpp_chatting_app_demo.adapters.ChatMessagesAdapter;
import com.example.xmpp_chatting_app_demo.bean.ChatMessage;
import com.example.xmpp_chatting_app_demo.dataBase.AppDataBase;
import com.example.xmpp_chatting_app_demo.xmpp.BackgroundXMPP;

import java.util.ArrayList;

/**
 * Created by peacock on 8/10/16.
 */

public class ChatFragement extends DialogFragment implements View.OnClickListener {

    private Activity activity;

    private ArrayList<ChatMessage> chatMessagesList;

    private SharedPreferences preferences;

    private AppDataBase dbHepler;

    private RecyclerView rv_chatList;

    private EditText et_message;

    private LinearLayoutManager llManager;

    private ChatMessagesAdapter chatMessagesAdapter;

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            String key = intent.getStringExtra("live_chat_broadcast");

            if (key.equals("live_chat_broadcast_success")) {

                String user_id = intent.getStringExtra("user_id");

                String group_name = intent.getStringExtra("group_name");

                String msg_id = intent.getStringExtra("msg_id");

                String sender = intent.getStringExtra("sender");

                String message = intent.getStringExtra("message");

                String date_time = intent.getStringExtra("date_time");

                String is_msg_read = intent.getStringExtra("is_msg_read");

                if (chatMessagesList != null && chatMessagesList.size() > 0) {

                    chatMessagesList.add(new ChatMessage(user_id, group_name, msg_id, sender,
                            message, date_time, is_msg_read));

                    chatMessagesAdapter.notifyMe(chatMessagesList);

                    rv_chatList.scrollToPosition(chatMessagesAdapter.getItemCount() - 1);

                } else {

                    setRecyclerView();

                }
            }
        }
    };

    public static ChatFragement newInstance() {

        ChatFragement chatFragement = new ChatFragement();

        return chatFragement;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        activity = getActivity();

        preferences = activity.getSharedPreferences(Common.sharedPreferences,
                Activity.MODE_PRIVATE);
        preferences.edit().putString(Common.isFragmentOpen, "true").commit();
        //preferences.edit().putString(Common.unreadMessagesCount, "0").commit();

        dbHepler = new AppDataBase(activity);

        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DisplayMetrics displaymetrics = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.
                SOFT_INPUT_ADJUST_RESIZE);
        getDialog().setCancelable(true);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setLayout(displaymetrics.widthPixels, displaymetrics.heightPixels -
                65);

        View chat_layout = inflater.inflate(R.layout.chat_layout, container, false);

        chat_layout.setFocusableInTouchMode(true);
        chat_layout.setFocusable(true);

        et_message = (EditText) chat_layout.findViewById(R.id.et_message);

        rv_chatList = (RecyclerView) chat_layout.findViewById(R.id.rv_chatList);

        chat_layout.findViewById(R.id.ibtn_sendMessage).setOnClickListener(this);

        chatMessagesList = new ArrayList<>();

        setRecyclerView();

        return chat_layout;

    }

    @Override
    public void onStart() {
        super.onStart();

        if (getDialog() == null) {

            return;

        }

        getDialog().getWindow().setWindowAnimations(R.style.ChatLayoutAnimation);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);

    }

    private void setRecyclerView() {

        chatMessagesList = dbHepler.getAllMessages(Common.CHAT_ROOM);

        System.out.println("DB_Count_Array --> " + chatMessagesList.size());

        if (chatMessagesList != null && chatMessagesList.size() > 0) {

            llManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
            llManager.setStackFromEnd(true);

            chatMessagesAdapter = new ChatMessagesAdapter(activity, chatMessagesList);

            rv_chatList.setLayoutManager(llManager);
            rv_chatList.setAdapter(chatMessagesAdapter);

            rv_chatList.scrollToPosition(chatMessagesAdapter.getItemCount() - 1);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.ibtn_sendMessage:

                String message = et_message.getText().toString().trim();

                if (message.trim().length() > 0) {

                    BackgroundXMPP.sendMsgtoGroup(message.trim());

                    et_message.getText().clear();

                }

                break;

            case R.id.et_message:

                if (chatMessagesList != null && chatMessagesList.size() > 0) {

                    rv_chatList.scrollToPosition(llManager.findLastCompletelyVisibleItemPosition());

                }

                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        dbHepler.setAllMessagesAsRead();

        preferences.edit().putString(Common.isAppInRecent, "false").commit();

        if (chatMessagesAdapter != null) {

            chatMessagesList = dbHepler.getAllMessages(Common.CHAT_ROOM);

            chatMessagesAdapter.notifyMe(chatMessagesList);

            rv_chatList.scrollToPosition(chatMessagesAdapter.getItemCount() - 1);

        }

        LocalBroadcastManager.getInstance(activity).registerReceiver(receiver,
                new IntentFilter("update_chat_list"));

        System.out.println("ChatApp -- ChatFragement -- onResume --> " + Common.isApplicationOpen +
                " = " + preferences.getString(Common.isApplicationOpen, "") + ", " +
                Common.isFragmentOpen + " = " + preferences.getString(Common.isFragmentOpen, "") +
                ", " + Common.isAppInRecent + " = " + preferences.getString(Common.isAppInRecent,
                "") + ", " + Common.killedFromRecent + " = " + preferences.
                getString(Common.killedFromRecent, ""));
    }

    @Override
    public void onPause() {
        super.onPause();

        preferences.edit().putString(Common.isAppInRecent, "true").commit();

        LocalBroadcastManager.getInstance(activity).unregisterReceiver(receiver);

        System.out.println("ChatApp -- ChatFragement -- onPause --> " + Common.isApplicationOpen +
                " = " + preferences.getString(Common.isApplicationOpen, "") + ", " +
                Common.isFragmentOpen + " = " + preferences.getString(Common.isFragmentOpen, "") +
                ", " + Common.isAppInRecent + " = " + preferences.getString(Common.isAppInRecent,
                "") + ", " + Common.killedFromRecent + " = " + preferences.
                getString(Common.killedFromRecent, ""));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        preferences.edit().putString(Common.isFragmentOpen, "false").commit();
        preferences.edit().putString(Common.isAppInRecent, "false").commit();

        System.out.println("ChatApp -- ChatFragement -- onDestroy --> " + Common.isApplicationOpen +
                " = " + preferences.getString(Common.isApplicationOpen, "") + ", " +
                Common.isFragmentOpen + " = " + preferences.getString(Common.isFragmentOpen, "") +
                ", " + Common.isAppInRecent + " = " + preferences.getString(Common.isAppInRecent,
                "") + ", " + Common.killedFromRecent + " = " + preferences.
                getString(Common.killedFromRecent, ""));

    }
}
