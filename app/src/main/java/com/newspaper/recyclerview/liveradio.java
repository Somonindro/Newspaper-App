package com.newspaper.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

public class liveradio extends AppCompatActivity {

    private int[] flag;
    private String[] radio;
    private Myadapter myadapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liveradio);

        setTitle("Live Radio Streaming");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        flag = new int[]{R.drawable.radio1, R.drawable.radio2, R.drawable.radio3, R.drawable.radio4,
                R.drawable.radio5, R.drawable.radio6, R.drawable.radio7 };

        radio = getResources().getStringArray(R.array.radio1);

        recyclerView = (RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, radio, 67);
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

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}