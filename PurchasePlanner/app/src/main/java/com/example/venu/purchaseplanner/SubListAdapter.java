package com.example.venu.purchaseplanner;

/**
 * Created by sujatha on 1/21/2016.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sujatha on 1/21/2016.
 */
public class SubListAdapter extends BaseAdapter {
    ArrayList<DataClass> listNames;
    Context mParent;

    public SubListAdapter(ArrayList<DataClass> listNames, Context mParent) {
        this.listNames = listNames;
        this.mParent = mParent;
    }

    @Override
    public int getCount() {
        return listNames.size();
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

        SubItem subItem;
        if(convertView==null)
        {
            convertView=View.inflate(mParent,R.layout.sublist_cell,null);
            subItem =new SubItem();
            subItem.item=(TextView)convertView.findViewById(R.id.subitem);
            subItem.quantity=(TextView)convertView.findViewById(R.id.qty);
            subItem.unit=(TextView)convertView.findViewById(R.id.unit);
            convertView.setTag(subItem);

        }
        else
        {
            subItem =(SubItem) convertView.getTag();
        }
        DataClass dataClass= listNames.get(position);
        subItem.item.setText((dataClass.getMitemName()));
         subItem.quantity.setText(dataClass.getMqty());
        subItem.unit.setText(dataClass.getMunits());
        return convertView;
    }

    static class SubItem
    {
        TextView item;
        TextView quantity;
        TextView unit;
    }



}
