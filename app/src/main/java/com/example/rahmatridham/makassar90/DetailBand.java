package com.example.rahmatridham.makassar90;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailBand extends AppCompatActivity {
    TextView nama, desc, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_band);

        nama = (TextView) findViewById(R.id.textView4NamaBand);
        desc = (TextView) findViewById(R.id.textView6DescBand);
        url = (TextView) findViewById(R.id.textView5bandurl);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b != null){
            nama.setText((String) b.get("namaBand"));
            desc.setText((String) b.get("descBand"));
            url.setText((String) b.get("urlBand"));
        }
    }
}
