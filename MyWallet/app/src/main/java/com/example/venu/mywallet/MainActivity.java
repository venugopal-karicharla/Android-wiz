package com.example.venu.mywallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double[] amounts={1000,123.00,25.00,16.00,19.00,22.00,100.00,200.00};
        int [] images={R.drawable.deposit,R.drawable.bills,R.drawable.groce2,R.drawable.milk,R.drawable.veg,R.drawable.save,R.drawable.rest,R.drawable.others};

        ArrayList<WalletData> walletDatas= new ArrayList<>();
        for (int i=0;i<amounts.length;i++)
        {
            WalletData wd=new WalletData();
            wd.setAmount(amounts[i]);
            wd.setIcon(images[i]);
            walletDatas.add(wd);
        }
        WalletAdapter walletAdapter=new WalletAdapter(walletDatas,this);
        ListView listView=(ListView) findViewById(R.id.listView);

        listView.setAdapter(walletAdapter);
    }
}
