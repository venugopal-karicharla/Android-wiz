package com.example.venu.dbexample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by sujatha on 1/7/2016.
 */
public class AutoActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    ProductClass productClass = new ProductClass(this);
    AutoCompleteTextView mactv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autotext_main);
        mactv = (AutoCompleteTextView) findViewById(R.id.eTauto);
        String[] prods = productClass.viewDataItems();
        Intent intent = getIntent();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, prods);
        mactv.setAdapter(adapter);
        mactv.setThreshold(1);
    }
}


