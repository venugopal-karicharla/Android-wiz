package com.example.venu.mywallet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sujatha on 12/31/2015.
 */
public class WalletAdapter extends BaseAdapter {
    ArrayList <WalletData> walletDatas;
    Context mparent;

    public WalletAdapter(ArrayList<WalletData> walletDatas, Context parent) {
        this.walletDatas = walletDatas;
        this.mparent = parent;
    }

    @Override
    public int getCount() {
        return walletDatas.size();
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

        WalletItem walletItem;
        if(convertView==null)
        {
            convertView=View.inflate(mparent,R.layout.each_cell,null);
            walletItem=new WalletItem();
            walletItem.editText=(TextView)convertView.findViewById(R.id.amount);
            walletItem.imageView=(ImageView)convertView.findViewById(R.id.itemView);
            convertView.setTag(walletItem);

        }
        else
        {
            walletItem=(WalletItem) convertView.getTag();
        }
        WalletData walletData=walletDatas.get(position);
        //walletItem.editText.setText(new Double(walletData.getAmount()).toString());
        String formatted = String.format("%.2f", walletData.getAmount());
        walletItem.editText.setText(formatted);
        walletItem.imageView.setBackgroundResource(walletData.getIcon());


        return convertView;
    }

    static class WalletItem
    {
        TextView editText;
        ImageView imageView;
    }



}
