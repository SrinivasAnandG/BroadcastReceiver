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



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = new BraodcastSample();
        IntentFilter intentFilter = new IntentFilter(getPackageName().toString());
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(broadcastReceiver,intentFilter);
    }
}
