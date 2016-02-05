package com.example.venu.implicitintent4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText met;
        Button mbtn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mbtn=(Button)findViewById(R.id.buttonEmail);
            mbtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
            email.putExtra(Intent.EXTRA_EMAIL,"kvgopal70@gmail.com");
            email.putExtra(Intent.EXTRA_SUBJECT, "Test");
            email.putExtra(Intent.EXTRA_TEXT, "This is a Test from Android");
            startActivity(Intent.createChooser(email, "Choose an email client from..."));

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
