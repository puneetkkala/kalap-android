package com.kalapuneet.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater kalapInflater = LayoutInflater.from(getContext());
        View customView = kalapInflater.inflate(R.layout.custom_row, parent, false);
        String singleFoodItem = getItem(position);
        TextView kalapText = (TextView) customView.findViewById(R.id.kalapTxt);
        ImageView kalapImg = (ImageView) customView.findViewById(R.id.kalapImg);

        kalapText.setText(singleFoodItem);
        kalapImg.setImageResource(R.drawable.puneet);

        return customView;
    }
}
