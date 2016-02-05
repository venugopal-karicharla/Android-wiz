package com.example.venu.implicitintent2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mone,mtwo,mthree,mfour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mone=(TextView) findViewById(R.id.one);
        mtwo=(TextView) findViewById(R.id.two);
        mthree=(TextView) findViewById(R.id.three);
        mfour=(TextView) findViewById(R.id.four);
        mone.setOnClickListener(this);
        mtwo.setOnClickListener(this);
        mthree.setOnClickListener(this);
        mfour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        Intent implicitIntent=new Intent(Intent.ACTION_VIEW);
        switch (viewID)
        {
            case R.id.one:
                implicitIntent.setData(Uri.parse("http://google.com"));
                break;
            case R.id.two:
                implicitIntent.setData(Uri.parse("http://indianrail.gov.in"));
                break;
            case R.id.three:
                implicitIntent.setData(Uri.parse("http://yahoo.co.in"));
                break;
            case R.id.four:
                implicitIntent.setData(Uri.parse("http://youtube.com"));
                break;
        }
        startActivity(implicitIntent);
    }
}
