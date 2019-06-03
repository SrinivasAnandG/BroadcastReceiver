package com.sriniavsprojectpool.broadcastreceiver.BroadcastFiles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BraodcastSample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        StringBuilder sb = new StringBuilder();
        sb.append(intent.toUri(Intent.URI_INTENT_SCHEME).toString());
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();


    }
}
