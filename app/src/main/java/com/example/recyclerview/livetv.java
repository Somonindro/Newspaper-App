package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class livetv extends AppCompatActivity {

    private int[] flag;
    private String[] tvnames;
    private Myadapter myadapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livetv);

        setTitle("Live Tv Streaming");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        flag = new int[] {R.drawable.tv1, R.drawable.tv2, R.drawable.tv3, R.drawable.tv4,
                R.drawable.tv5, R.drawable.tv6, R.drawable.tv7, R.drawable.tv8,
                R.drawable.tv9, R.drawable.tv10, R.drawable.tv11, R.drawable.tv12,
                R.drawable.tv13, R.drawable.tv14 };

        tvnames = getResources().getStringArray(R.array.tvchannel1);

        recyclerView = recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, tvnames, 66);
        recyclerView.setAdapter(myadapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return false;
        }
    }

}