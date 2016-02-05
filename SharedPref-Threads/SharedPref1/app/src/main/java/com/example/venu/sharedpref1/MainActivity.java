package com.example.venu.sharedpref1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String mpassword;
    boolean mchecked;
    String mfreq;

    EditText metpass;
    CheckBox mcb;
    EditText metfreq;
    TextView mtvresult;
    Button mbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
          metpass=(EditText) findViewById(R.id.password);
          mcb=(CheckBox) findViewById(R.id.check);
          metfreq=(EditText) findViewById(R.id.remaindernum);
          mtvresult=(TextView) findViewById(R.id.result);
          mbtn=(Button) findViewById(R.id.submit);
          mbtn.setOnClickListener(this);

          FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
 }



    @Override
    public void onClick(View v) {

        SharedPreferences sharedPreferences= getSharedPreferences("APP_PREF",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("password", metpass.getText().toString());
        editor.putBoolean("lock", mcb.isChecked());
        editor.putString("freq", metfreq.getText().toString());
        editor.commit();


        String result="Password=  ";

        result+=sharedPreferences.getString("password","No value exists");
        result+=";  is checked = ";
        result+= sharedPreferences.getBoolean("lock",true);
        result+="; Alaram Frequency = ";
        result+=sharedPreferences.getString("freq", "Not Set");

        mtvresult.setText(result);


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
