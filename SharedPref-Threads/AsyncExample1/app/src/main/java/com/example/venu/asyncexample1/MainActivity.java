package com.example.venu.asyncexample1;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mbtn;
    ProgressBar mpb1, mpb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn=(Button) findViewById(R.id.download);
        mpb1= (ProgressBar) findViewById(R.id.progressBar1);
        mpb2= (ProgressBar) findViewById(R.id.progressBar2);
        mbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            new ProgressActivity(mpb1,mpb2).execute(new String[]{"100","150"});
}
}
