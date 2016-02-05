package com.example.venu.lesson3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class ButtonDemo extends AppCompatActivity {
    Button btn;
    ImageView img;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_demo);
        btn = (Button) findViewById(R.id.showhide);
        img = (ImageView) findViewById(R.id.sri);

        OnClickListener button = new OnClickListener() {

           // boolean flag1 = true;
            @Override
            public void onClick(View v) {

                if (flag == false) {
                    img.setVisibility(View.VISIBLE);
                    Toast.makeText(ButtonDemo.this,"flag is false",Toast.LENGTH_LONG).show();
                    //flag1 = true;

                }
                if (flag == true) {
                    img.setVisibility(View.INVISIBLE);
                    Toast.makeText(ButtonDemo.this,"flag is true",Toast.LENGTH_LONG).show();
                    //flag1 = false;
                }
                if(flag==true)
                    flag=false;
                else
                    flag=true;

            }
        };

        btn.setOnClickListener(button);
    }
}