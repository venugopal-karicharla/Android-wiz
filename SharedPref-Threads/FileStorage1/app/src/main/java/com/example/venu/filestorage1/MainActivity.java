package com.example.venu.filestorage1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        Button mbtn;
        EditText met;
        TextView mtv;
        FileOutputStream mfos=null;
        File mfile;
        FileInputStream mfis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn=(Button) findViewById(R.id.submit);
        met=(EditText) findViewById(R.id.matter);
        mtv=(TextView) findViewById(R.id.result);
        mbtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        String s=met.getText().toString();

        try {

            mfile=new File(this.getFilesDir(),"data.dat");
            mfos = openFileOutput("data.dat", Context.MODE_PRIVATE);

            mfos.write(s.getBytes());
            mfos.close();
            //if(mfos==null)
           //     Toast.makeText(this,"not ok",Toast.LENGTH_SHORT).show();
        } catch(Exception e){}

        try
        {
            mfile=new File(this.getFilesDir(),"data.dat");
            mfis=openFileInput("data.dat");
            byte [] temp=new byte[(int)mfile.length()];

            mfis.read(temp);
            String ss=new String(temp);
            mtv.setText(ss);
            mfis.close();
       } catch (Exception e){//Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
       e.printStackTrace();}


    }
}
