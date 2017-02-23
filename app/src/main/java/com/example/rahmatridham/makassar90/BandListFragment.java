package com.example.rahmatridham.makassar90;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rahmatridham.makassar90.Model.Band;
import com.example.rahmatridham.makassar90.adapter.bandAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class BandListFragment extends Fragment implements AdapterView.OnItemClickListener {
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
        getAllArtist();

        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(this);
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

    private void getAllArtist() {

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config.URL_BAND, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject data = new JSONObject(response);
                    JSONArray listData = data.getJSONArray("data");

                    for (int i = 0; i < listData.length(); i++) {
                        JSONObject object = listData.optJSONObject(i);
                        Band band = new Band(object.optString("name",""),object.optString("desc",""),object.optString("img_url"));
                        bandArrayList.add(band);
                    }

                    adapter.notifyDataSetChanged();

                } catch (Exception e) {
                    Toast.makeText(BandListFragment.this.getContext(), "error get data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        error.printStackTrace();
                        Toast.makeText(BandListFragment.this.getContext(), "error response: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                try {
                    //Adding parameters to request


                    //returning parameter
                    return params;
                } catch (Exception e) {
                    Toast.makeText(BandListFragment.this.getContext(), "error params:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    return params;
                }
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Band band = bandArrayList.get(i);
        Toast.makeText(view.getContext(), band.getDesc(), Toast.LENGTH_SHORT).show();
    }
}
