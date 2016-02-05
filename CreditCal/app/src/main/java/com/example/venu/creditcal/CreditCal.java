package com.example.venu.creditcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreditCal extends AppCompatActivity implements View.OnClickListener {
    Button compute,clear;
    EditText tbal,tinst,tpayment,tfcb,tmr,tip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_cal);
        compute=(Button)findViewById(R.id.cal);
        clear=(Button) findViewById(R.id.clear);
        tbal=(EditText) findViewById(R.id.tbal);
        tinst=(EditText) findViewById(R.id.tinst);
        tpayment=(EditText) findViewById(R.id.tpayment);
        tfcb=(EditText) findViewById(R.id.tfcb);
        tmr=(EditText) findViewById(R.id.tmr);
        tip=(EditText) findViewById(R.id.tip);

        compute.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.cal:
                String s= tbal.getText().toString();
                Double balance= new Double(s);
                double b=balance.doubleValue();
                s= tinst.getText().toString();
                balance= new Double(s);
                double i=balance.doubleValue();
                s= tpayment.getText().toString();
                balance= new Double(s);
                double mp=balance.doubleValue();
                double monthlyFloatInterestPaid=Math.round(b * (i / (100 * 12)));
                double monthlyPrinciple=mp-monthlyFloatInterestPaid;
                double monthlyBalance=b-monthlyPrinciple;
                tfcb.setText(new Double(monthlyBalance).toString());
                tmr.setText("9");
                tip.setText(new Double(monthlyFloatInterestPaid).toString());

                break;
            case R.id.clear:
                break;
        }

    }
}
