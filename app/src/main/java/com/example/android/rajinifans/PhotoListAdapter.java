package com.example.android.rajinifans;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class PhotoListAdapter extends BaseAdapter {

    String [] titles;
    String[] descriptions;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public PhotoListAdapter(Activity activity, String[] photoTitles, int[] photoSrc) {
        titles=photoTitles;
        context=activity;
        imageId=photoSrc;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null)
            rowView = inflater.inflate(R.layout.photo_list_item, null);
        TextView tv=(TextView) rowView.findViewById(R.id.image_title);
        ImageView img=(ImageView) rowView.findViewById(R.id.image_content);
        tv.setText(titles[position]);
        img.setImageResource(imageId[position]);
        return rowView;
    }
}
