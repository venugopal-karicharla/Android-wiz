package com.example.venu.intent1;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.venu.intent1.R;

/**
 * Created by sujatha on 1/3/2016.
 */
public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView mOne= (TextView)findViewById(R.id.one);
        TextView mTwo= (TextView)findViewById(R.id.two);
        TextView mThree= (TextView)findViewById(R.id.three);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
       // Toast.makeText(SubActivity.this,"OK",Toast.LENGTH_LONG);
       // mTwo.setText(bundle.getString("NAME"));
        if(bundle!=null)
        {
           // bundle.getString("")
            mOne.setText("Hello!     "+bundle.getString("NAME"));
           // mOne.setText("Hello!");
            mTwo.setText("Your Age is"+bundle.getString("AGE"));
            mThree.setText("You Belong to    "+bundle.getString("NATIONALITY"));
        }

    }
}

