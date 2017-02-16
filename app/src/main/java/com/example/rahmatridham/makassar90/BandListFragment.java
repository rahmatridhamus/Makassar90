package com.example.rahmatridham.makassar90;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rahmatridham.makassar90.Model.Band;
import com.example.rahmatridham.makassar90.adapter.bandAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BandListFragment extends Fragment {
    ArrayList<Band> bandArrayList;
    bandAdapter adapter;
    ListView listView;

    public BandListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_band_list, container, false);
        bandArrayList = new ArrayList<>();
        adapter = new bandAdapter(bandArrayList, BandListFragment.this.getContext());
        listView = (ListView) v.findViewById(R.id.listBand);
        listView.setAdapter(adapter);

        getData();
        adapter.notifyDataSetChanged();
        return v;
    }

    void getData() {
        Band a = new Band("Kangen Band", "Alaaaaay", "");
        Band b = new Band("AIkustik", "Alaaaaay", "");
        Band c = new Band("Yonglek", "Alaaaaay", "");
        Band d = new Band("Kufuku", "Alaaaaay", "");

        bandArrayList.add(a);
        bandArrayList.add(b);
        bandArrayList.add(c);
        bandArrayList.add(d);
    }

}
