package com.example.timesaver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.os.Build.VERSION_CODES.P;

public class ScreenOnOffBroadcast extends BroadcastReceiver {

    private long startTimer;
    private long endTimer;
    private long screenOnTimeSingle;
    private long screenOnTime;

    public void onReceive(Context context, Intent intent) {
        Log.e("msgmsg", "ScreenTimeService onReceive");

        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.e("msgmsg", "Screen on");
            startTimer = System.currentTimeMillis();
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.e("msgmsg", "Screen off");
            endTimer = System.currentTimeMillis();
            screenOnTimeSingle = endTimer - startTimer;

            screenOnTime += screenOnTime;

        }
    }
}
