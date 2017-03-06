package com.example.rahmatridham.makassar90.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahmatridham.makassar90.Model.Band;
import com.example.rahmatridham.makassar90.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rahmatridham on 2/16/2017.
 */

public class bandAdapter extends BaseAdapter {
    ArrayList<Band> bandArrayList;
    Context context;

    public bandAdapter(ArrayList<Band> bandArrayList, Context context) {
        this.bandArrayList = bandArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bandArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return bandArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Band band = bandArrayList.get(i);
        int type = getItemViewType(i);
        View v;
        if (type == 1) {
            v = inflater.inflate(R.layout.list_row_sponsor, null, false);

        } else {
            v = inflater.inflate(R.layout.list_row_bandlist, null, false);

            ImageView fotoBand = (ImageView) v.findViewById(R.id.imageViewFotoBand);
            TextView namaBand = (TextView) v.findViewById(R.id.textViewNamaBand);

//            fotoBand.setImageResource(R.drawable.dnif);
            Picasso.with(v.getContext()).load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSFretQXpsKyZ4eFR7_lfyraH3sgEqxe5jMh7NrBoxeYgReA26j").into(fotoBand);
            namaBand.setText(band.getName());
        }
        return v;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return (bandArrayList.get(position).getName().equals("default")) ? 1 : 0;
    }
}
