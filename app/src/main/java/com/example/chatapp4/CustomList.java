package com.example.chatapp4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtName = (TextView) rowView.findViewById(R.id.contact_name);
        TextView txtLastM = (TextView) rowView.findViewById(R.id.contact_last_m);
        TextView txtTime = (TextView) rowView.findViewById(R.id.contact_time);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtName.setText(web[position]);
        txtLastM.setText("Last Message");
        txtTime.setText("Last Time");
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}