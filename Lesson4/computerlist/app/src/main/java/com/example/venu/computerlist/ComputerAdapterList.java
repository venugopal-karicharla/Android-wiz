package com.example.venu.computerlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sujatha on 12/30/2015.
 */
public class ComputerAdapterList extends BaseAdapter {
    Context parentContext;
    ArrayList<ComputerClass> ComputerArrayList;

    ComputerAdapterList(Context c , ArrayList<ComputerClass> computerArrayList) {
        parentContext = c;
        ComputerArrayList = computerArrayList;
    }

    @Override
    public int getCount() {
        return ComputerArrayList.size();
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
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = View.inflate(parentContext,R.layout.layout_single_cell,null);
            viewHolder=new ViewHolder();
            viewHolder.CName=(TextView) convertView.findViewById(R.id.computerName);
            viewHolder.CPrice=(TextView) convertView.findViewById(R.id.computerPrice);
            viewHolder.CIcon=(ImageView) convertView.findViewById(R.id.computerImage);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        ComputerClass cc=ComputerArrayList.get(position);
        viewHolder.CName.setText(cc.ComputerName);
        viewHolder.CPrice.setText(cc.ComputerPrice);
        viewHolder.CIcon.setBackgroundResource(cc.ComputerIcon);

        return convertView;
    }

    static class ViewHolder
    {
        TextView CName;
        TextView CPrice;
        ImageView CIcon;
    }
}
