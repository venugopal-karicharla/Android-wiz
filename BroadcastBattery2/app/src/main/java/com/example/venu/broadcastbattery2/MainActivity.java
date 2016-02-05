package com.example.venu.broadcastbattery2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=(TextView) findViewById(R.id.textView);
    //    tv.setText((new Float(batteryLevel())).toString());
        tv.setText("Battery Charging:"+(new Float(batteryLevel2Way(this))).toString());
    }

public float batteryLevel()
{
    Intent intent=this.getApplicationContext().registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    return intent.getIntExtra("level",-1);
}

public float batteryLevel2Way(Context context)
{
    Intent intent=context.registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
    int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,100);
    return level/(float)scale;
}
}