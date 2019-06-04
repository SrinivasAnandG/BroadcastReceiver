package com.sriniavsprojectpool.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

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
        BroadcastReceiver broadcastReceiver = new BraodcastSample();
        IntentFilter intentFilter = new IntentFilter(getPackageName().toString());
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        getApplicationContext().registerReceiver(broadcastReceiver,intentFilter);



    }

}
