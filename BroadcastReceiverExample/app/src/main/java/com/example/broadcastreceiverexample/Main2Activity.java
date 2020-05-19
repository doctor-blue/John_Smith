package com.example.broadcastreceiverexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    private LocalBroadcastManager broadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       broadcastManager= LocalBroadcastManager.getInstance(Main2Activity.this);
        IntentFilter filter=new IntentFilter("com.example.broadcastreceiverexample.localbroadcast");
       broadcastManager.registerReceiver(myReceiver,filter);
    }
    private BroadcastReceiver myReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(Main2Activity.class.getSimpleName(), "onReceive: Local Broadcast receiver ");
        }
    };

    public void sendLocalBroadcast(View view) {
        Intent intent=new Intent("com.example.broadcastreceiverexample.localbroadcast");
        broadcastManager.sendBroadcast(intent);
    }
}
