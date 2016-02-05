package com.example.venu.implicitintent3;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
       Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }
}
