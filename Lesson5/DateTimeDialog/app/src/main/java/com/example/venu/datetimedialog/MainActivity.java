package com.example.venu.datetimedialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mbDate,mbTime;
    TextView mtvDateTime;
    int mDay,mMonth,mYear,mHour,mMin,mSec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbDate=(Button)this.findViewById(R.id.datebutton);
        mbTime=(Button) findViewById(R.id.timebutton);
        mtvDateTime=(TextView) findViewById(R.id.datetime);
        mbDate.setOnClickListener(this);
        mbTime.setOnClickListener(this);

    }
    DatePickerDialog.OnDateSetListener mOnDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int x=monthOfYear+1;
            mtvDateTime.setText(dayOfMonth + "/" +x + "/" + year);
        }
    };

    TimePickerDialog.OnTimeSetListener mOnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mtvDateTime.setText(hourOfDay + ":" + minute);
        }
    };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 101:
                return new DatePickerDialog(MainActivity.this,mOnDateSetListener,mYear,mMonth,mDay);
            case 102:
                return new TimePickerDialog(MainActivity.this,mOnTimeSetListener,mHour,mMin,true);
        }
        return null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.datebutton:
                showDialog(101);
                break;
            case R.id.timebutton:
                showDialog(102);
                break;
        }

    }

}
