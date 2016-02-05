package com.example.venu.lesson3ii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.util.Log;

public class RainbowButtons extends AppCompatActivity {
Button vio,ind,blu,gre,yel,ora,red;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_buttons);
        vio=(Button) findViewById(R.id.violet);
        ind=(Button) findViewById(R.id.indigo);
        blu=(Button)findViewById(R.id.blue);
        gre=(Button)findViewById(R.id.green);
        yel=(Button)findViewById(R.id.yellow);
        ora=(Button)findViewById(R.id.orange);
        red=(Button)findViewById(R.id.red);

        OnClickListener button = new OnClickListener() {
           @Override
                public void onClick(View v)
            {
               switch(v.getId())
               {
                   case R.id.violet:
                       Toast.makeText(RainbowButtons.this,"Voilet",Toast.LENGTH_LONG).show();
                       Log.i("Voilet", "Button pressed");
                       break;
                   case R.id.indigo:
                       Toast.makeText(RainbowButtons.this,"Indigo",Toast.LENGTH_LONG).show();
                       Log.i("Indigo", "Button pressed");
                       break;
                   case R.id.blue:
                       Toast.makeText(RainbowButtons.this,"blue",Toast.LENGTH_LONG).show();
                       Log.i("blue", "Button pressed");
                       break;
                   case R.id.green:
                       Toast.makeText(RainbowButtons.this,"green",Toast.LENGTH_LONG).show();
                       Log.i("green", "Button pressed");
                       break;
                   case R.id.yellow:
                       Toast.makeText(RainbowButtons.this,"yellow",Toast.LENGTH_LONG).show();
                       Log.i("yellow", "Button pressed");
                       break;
                   case R.id.orange:
                       Toast.makeText(RainbowButtons.this,"orange",Toast.LENGTH_LONG).show();
                       Log.i("orange", "Button pressed");
                       break;
                   case R.id.red:
                       Toast.makeText(RainbowButtons.this,"red",Toast.LENGTH_LONG).show();
                       Log.i("red", "Button pressed");

               }
            }
        };

        vio.setOnClickListener(button);
        ind.setOnClickListener(button);
        blu.setOnClickListener(button);
        gre.setOnClickListener(button);
        yel.setOnClickListener(button);
        ora.setOnClickListener(button);
        red.setOnClickListener(button);


    }
}
