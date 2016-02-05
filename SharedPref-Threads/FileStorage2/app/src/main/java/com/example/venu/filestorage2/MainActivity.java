package com.example.venu.filestorage2;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        String filename="data.dat";
        if (isExternalStorageWritable()) {
            try {
                File ss = Environment.getExternalStorageDirectory();

                //File myFile = new File(ss+filename);
                File myFile = new File("/sdcard/" + filename);
                //mtv.setText(myFile.toString());
                myFile.createNewFile();
                FileOutputStream fOut = new FileOutputStream(myFile);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.append(s);
                myOutWriter.close();
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(isExternalStorageReadable()) {
            StringBuffer stringBuffer = new StringBuffer();
            String aDataRow = "";
            String aBuffer = "";
            try {
                File myFile = new File("/sdcard/" + filename);
                FileInputStream fIn = new FileInputStream(myFile);
                BufferedReader myReader = new BufferedReader(
                        new InputStreamReader(fIn));

                while ((aDataRow = myReader.readLine()) != null) {
                    aBuffer += aDataRow + "\n";
                }
                myReader.close();
                mtv.setText(aBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // check if external storage is mounted

    public boolean isExternalStorageWritable()
    {
        String state= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable()
    {
        String state=Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)|| (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))) {
            return true;
        }
        return false;
    }
}