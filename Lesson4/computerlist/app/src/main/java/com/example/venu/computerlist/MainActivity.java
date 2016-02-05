package com.example.venu.computerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview=(ListView) findViewById(R.id.ListView);
        final String [] cN={"IBM","MAC","DELL","Lenovo","HP","MAC AIR","ASUS","INTEL","AMD"};
        final String [] cP={"120$","100$","105$","95$","110$","150$","85$","50$","52$"};
        final int[] cI={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,
                R.drawable.c8,R.drawable.c9,R.drawable.c10,};
        ArrayList <ComputerClass> computerClasses = new ArrayList<ComputerClass>();
        for (int i=0;i<cN.length;i++)
        {
            ComputerClass cc=new ComputerClass();
            cc.setComputerName(cN[i]);
            cc.setComputerPrice(cP[i]);
            cc.setComputerIcon(cI[i]);
            computerClasses.add(cc);
        }

        ComputerAdapterList myComputerAdapterList = new ComputerAdapterList(this,computerClasses);
        listview.setAdapter(myComputerAdapterList);
        listview.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,cN[position],Toast.LENGTH_LONG).show();
            }
        });


    }
}
