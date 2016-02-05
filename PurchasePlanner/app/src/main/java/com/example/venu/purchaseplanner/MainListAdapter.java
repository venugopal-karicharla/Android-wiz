package com.example.venu.purchaseplanner;

/**
 * Created by sujatha on 1/20/2016.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sujatha on 12/31/2015.
 */
public class MainListAdapter extends BaseAdapter {
    ArrayList <DataClass> listnames;
    Context mparent;

    public MainListAdapter(ArrayList<DataClass> listnames, Context mparent) {
        this.listnames = listnames;
        this.mparent = mparent;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listnames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HeadItem headItem;
        if(convertView==null)
        {
            convertView=View.inflate(mparent,R.layout.main_list_cell,null);
            headItem =new HeadItem();
            headItem.dateView=(TextView)convertView.findViewById(R.id.date);
            headItem.listName=(TextView)convertView.findViewById(R.id.item);
            convertView.setTag(headItem);

        }
        else
        {
            headItem =(HeadItem) convertView.getTag();
        }
        DataClass dataClass=listnames.get(position);
        headItem.dateView.setText((dataClass.getMlistName()).toString());
        headItem.listName.setText(dataClass.getMdate());
        return convertView;
    }

    static class HeadItem
    {
        TextView listName;
        TextView dateView;
    }



}

