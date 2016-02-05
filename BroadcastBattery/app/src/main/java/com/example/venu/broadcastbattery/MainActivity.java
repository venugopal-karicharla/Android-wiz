package com.example.venu.broadcastbattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(mBatInfoReceiver, new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED));

    }

    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
            //int level = i.getIntExtra("level", 0);
            int level = i.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            int scale= i.getIntExtra(BatteryManager.EXTRA_SCALE   ,-1);
            float pct= level/(float)1.0;
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
            pb.setProgress((int)pct);
            TextView tv = (TextView) findViewById(R.id.textview);
            tv.setText("Battery Level: " + Float.toString(pct) + "%");
        }

    };









}
