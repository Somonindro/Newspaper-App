package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class sikkha extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;
    private String[] papernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        setTitle("Education");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        flag=new int[]{R.drawable.prothomalo,R.drawable.bdprotidin,R.drawable.ittefaq,R.drawable.amarsongbad,R.drawable.protidinersongbad,
                R.drawable.jugantor,R.drawable.songgram,R.drawable.manobjomin,R.drawable.edu1,R.drawable.edu2,R.drawable.edu3,R.drawable.edu4,R.drawable.edu5,
                R.drawable.edu6,R.drawable.edu7,R.drawable.edu8,R.drawable.edu9,R.drawable.edu10};
        papernames = getResources().getStringArray(R.array.Educationalsite1);


        recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, papernames, 64);
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
