package com.example.recyclerview;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class jatiyo extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;
    private String[] papernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        setTitle("National Newspapers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        flag=new int[]{R.drawable.jatiyo25,R.drawable.jatiyo24,R.drawable.jatiyo23,R.drawable.jatiyo22,R.drawable.jatiyo21,
                R.drawable.jatiyo20,R.drawable.jatiyo19,R.drawable.jatiyo18,R.drawable.jatiyo17,R.drawable.jatiyo16,
                R.drawable.jatiyo15,R.drawable.jatiyo14,R.drawable.jatiyo13,R.drawable.jatiyo12,R.drawable.jatiyo11,
                R.drawable.jatiyo10,R.drawable.jatiyo9,R.drawable.jatiyo8,R.drawable.jatiyo7,R.drawable.jatiyo6,
                R.drawable.jatiyo5,R.drawable.jatiyo4,R.drawable.jatiyo3,R.drawable.jatiyo2,R.drawable.jatiyo1};
        papernames = getResources().getStringArray(R.array.Jatiyo1);


        recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, papernames, 70);
        recyclerView.setAdapter(myadapter);
        GridLayoutManager layoutManager;

        int orientation = this.getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

            switch(screenSize)
            {
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    layoutManager = new GridLayoutManager(this, 1);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    layoutManager = new GridLayoutManager(this, 2);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    layoutManager = new GridLayoutManager(this, 3);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    layoutManager = new GridLayoutManager(this, 4);
                    break;

                default:
                    layoutManager = new GridLayoutManager(this, 2);
                    break;
            }

        }

        else
        {
            int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

            switch(screenSize)
            {
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    layoutManager = new GridLayoutManager(this, 2);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    layoutManager = new GridLayoutManager(this, 4);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    layoutManager = new GridLayoutManager(this, 6);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    layoutManager = new GridLayoutManager(this, 7);
                    break;

                default:
                    layoutManager = new GridLayoutManager(this, 3);
                    break;
            }

        }

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
