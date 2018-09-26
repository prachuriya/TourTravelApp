package com.example.android.tourtravelapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TourArrayAdapter extends ArrayAdapter<ListArray> {
    public TourArrayAdapter(@NonNull Context context, @NonNull List<ListArray> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ListArray currentItem= getItem(position);
        View listItemView=convertView;
        if(listItemView==null)
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        ImageView imageTour= listItemView.findViewById(R.id.image_icon);
        imageTour.setImageResource(currentItem.getImage());

        TextView name=listItemView.findViewById(R.id.name);
        name.setText(currentItem.getName());

        TextView rating=listItemView.findViewById(R.id.rating);
        rating.setText(Double.toString(currentItem.getRating()));
        ImageView location=listItemView.findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                Uri uri=Uri.parse(currentItem.getUrl());
                intent.setData(uri);
                getContext().startActivity(intent);
            }
        });

        ImageView phoneno=listItemView.findViewById(R.id.phoneno);
        phoneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                Uri uri= Uri.parse("tel:"+currentItem.getCallNumber());
                intent.setData(uri);
                getContext().startActivity(intent);
            }
        });
        return listItemView;
    }
}
