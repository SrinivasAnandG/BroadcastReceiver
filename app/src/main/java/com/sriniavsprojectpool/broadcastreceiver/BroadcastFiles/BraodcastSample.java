package com.sriniavsprojectpool.broadcastreceiver.BroadcastFiles;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.widget.Toast;



public class BraodcastSample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //Validates the receiver. as we are setting one app receiver and we are sending one
        //broadcast so if power is connected the app receiver triggers and displays
        if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED"))
        {
            final PendingResult pendingResult = goAsync();
            Task asyncTask = new Task(pendingResult, intent,context);
            asyncTask.execute();
        }
        else
        {
            Toast.makeText(context, "From MY_HELLO", Toast.LENGTH_SHORT).show();
        }


    }

    public class Task extends AsyncTask<String, Integer , String>
    {
        private final PendingResult pendingResult;
        private final Intent intent;
        private final Context context;

        private Task(PendingResult pendingResult, Intent intent, Context context) {
            this.pendingResult = pendingResult;
            this.intent = intent;
            this.context = context;
        }
        @Override
        protected String doInBackground(String... strings) {
            return "hello";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(context, "From ACTION_POWER_CONNECTED", Toast.LENGTH_SHORT).show();
            pendingResult.finish();
        }
    }
}
