package com.example.venu.implicitintent1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText met;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.button);
        met= (EditText) findViewById(R.id.search);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent implicitIntent=new Intent(Intent.ACTION_VIEW);
        implicitIntent.setData(Uri.parse("https://www.google.co.in/?gws_rd=ssl#q="+met.getText().toString()));
        startActivity(implicitIntent);

    }
}
