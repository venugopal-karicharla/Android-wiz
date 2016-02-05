package com.example.venu.asyncexample1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by sujatha on 1/9/2016.
 */
public class ProgressActivity extends AsyncTask<String,Integer,String> {
    ProgressBar mpb1;
    ProgressBar mpb2;
    public ProgressActivity (ProgressBar pb1,ProgressBar pb2)
    {
    mpb1=pb1;
    mpb2=pb2;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        try {
            mpb1.setProgress(values[0].intValue());
            Thread.sleep(100);
            mpb2.setProgress(values[0].intValue());
        } catch (InterruptedException e) {
        }
    }


    @Override
    protected String doInBackground(String... params) {
        int sl=new Integer(params[0]).intValue();
        for (int i=0;i<=100;i++)
        {
           try {
               Thread.sleep(sl);
               publishProgress(new Integer(i));
           }
           catch(InterruptedException e){}
        }
        return null;
    }
}
