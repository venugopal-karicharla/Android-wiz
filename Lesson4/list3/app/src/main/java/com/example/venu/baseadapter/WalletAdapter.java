package com.example.venu.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sujatha on 12/29/2015.
 */
public class WalletAdapter extends BaseAdapter {

    List<Chapter> mChapterList = getDataForListView();


    @Override
    public int getCount() {
        return mChapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return mChapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listitem,parent,false);
        }

        TextView chapterName=(TextView) convertView.findViewById(R.id.textView1);
        TextView chapterDesc=(TextView) convertView.findViewById(R.id.textView2);
        Chapter chapter= mChapterList.get(position);
        chapterName.setText(chapter.chapterName);
        chapterDesc.setText(chapter.ChapterDesc);
    return convertView;
    }


    public List<Chapter> getDataForListView() {
        List<Chapter> chapterList = new ArrayList<Chapter>();
        for (int i = 0; i <= 10; i++) {
            Chapter chapter = new Chapter();
            chapter.chapterName = "Chapter" + i;
            chapter.ChapterDesc = "Chapter Desvription" + i;
            chapterList.add(chapter);
        }
        return chapterList;
    }
}