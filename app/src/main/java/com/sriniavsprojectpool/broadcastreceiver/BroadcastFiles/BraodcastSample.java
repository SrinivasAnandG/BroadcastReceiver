package com.sriniavsprojectpool.broadcastreceiver.BroadcastFiles;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.arch.core.executor.TaskExecutor;

public class BraodcastSample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final PendingResult pendingResult = goAsync();
        Task asyncTask = new Task(pendingResult, intent,context);
        asyncTask.execute();

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
            Toast.makeText(context, "hello1", Toast.LENGTH_SHORT).show();
            pendingResult.finish();
        }
    }
}
