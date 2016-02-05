package com.example.venu.dbexample1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mbtn;
    Button msbtn;
    Button mabtn;
    EditText meta;
    TextView mtv;
    EditText met;
    private  ProductClass productClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       mbtn =(Button) findViewById(R.id.add);
       mbtn.setOnClickListener(this);
        msbtn=(Button) findViewById(R.id.viewdata);
        msbtn.setOnClickListener(this);
       met=(EditText)findViewById(R.id.product);
        mtv=(TextView)findViewById(R.id.Tdisplay);
       productClass =new ProductClass(this);
        mabtn=(Button) findViewById(R.id.autoButton);
        mabtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add:
                String s = met.getEditableText().toString();
                productClass.addProduct(s);
                met.setText("");
                break;
            case R.id.viewdata:
                String ss;
                ss = productClass.viewData();
                mtv.setText(ss);
                break;
            case R.id.autoButton:
                 Intent intent=new Intent(MainActivity.this,AutoActivity.class );
                  startActivity(intent);
        }

    }
}
