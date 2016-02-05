package com.example.venu.dbexample2;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mbtn;
    EditText meta;
    MultiAutoCompleteTextView mactv;
    private  DataBaseClass productClass;

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
        meta=(EditText)findViewById(R.id.product);
        mactv=(MultiAutoCompleteTextView)findViewById(R.id.act);
        productClass =new DataBaseClass(this);

       // String[] prods = productClass.viewDataItems();
        //StringBuffer[] stp=new StringBuffer[];
        String temp=" ";
       // String[] prods={"My","name","is","Venu","Gopal"};
        List<String> myList=new ArrayList<String>();
       myList= productClass.viewDataItems();
        String [] prods=myList.toArray(new String[myList.size()]);
    /*    int i=0;
        do
        {
            stp.=prods[i];
            i++;
        } while (prods[i]!=null);
        meta.setText(stp.length);
*/
            ArrayAdapter <String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, prods);
            mactv.setAdapter(adapter);
            mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add:
                String s = meta.getEditableText().toString();
                productClass.addProduct(s);
                meta.setText("");
                break;
        }

    }
}
