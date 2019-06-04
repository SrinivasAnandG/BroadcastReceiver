package com.sriniavsprojectpool.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.sriniavsprojectpool.broadcastreceiver.BroadcastFiles.BraodcastSample;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Broadcast receiver registration with the application so that if activity process killed
        //the receiver won't get killed untill the app is get killed.


        //If reciver is registered through the manifest the system may conclude this register to be week
        // and unimportant and it get killed when system requires memory to reclaim
        BroadcastReceiver broadcastReceiver = new BraodcastSample();
        IntentFilter intentFilter = new IntentFilter(getPackageName().toString());
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(getPackageName()+".MY_HELLO");
        getApplicationContext().registerReceiver(broadcastReceiver,intentFilter);


        //we are sending broadcast so that app can listen when this peice of code executes
        Intent intent = new Intent();
        intent.setAction(getPackageName()+".MY_HELLO");
        sendBroadcast(intent);

    }

}
