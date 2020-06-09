package com.newspaper.recyclerview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class chakri extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;
    private String[] papernames;
    GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        setTitle("Job");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        flag=new int[]{R.drawable.prothomalo,R.drawable.bdprotidin,R.drawable.amarsongbad,R.drawable.protidinersongbad,R.drawable.songgram,
                R.drawable.amadersomoy,R.drawable.job1,R.drawable.job2,R.drawable.job3,R.drawable.job4,R.drawable.job5,R.drawable.job6,
                R.drawable.job7,R.drawable.job8,R.drawable.job9,R.drawable.job10};
        papernames = getResources().getStringArray(R.array.Jobsite1);


        recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, papernames, 63);
        recyclerView.setAdapter(myadapter);


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
