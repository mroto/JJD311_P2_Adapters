package com.mroto.jjd311_p2_adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Item> {
    private Context mContext;
    private List<Item> itemList;

    public MyListAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //super.getView(position, convertView, parent);
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_view_custom_layout, null);


        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_view_custom_row_layout);

        TextView textViewTitle = (TextView) convertView.findViewById(R.id.text_view_custom_title);
        textViewTitle.setText(this.itemList.get(position).getTitle());

        TextView textViewBody = (TextView) convertView.findViewById(R.id.text_view_custom_body);
        textViewBody.setText(this.itemList.get(position).getBody());

        return convertView;
    }
}
