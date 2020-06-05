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

public class international extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;
    private String[] papernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);

        setTitle("International Newspapers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        flag=new int[]{R.drawable.international1,R.drawable.international2,R.drawable.international3,R.drawable.international4,R.drawable.international5,
                R.drawable.international6,R.drawable.international7,R.drawable.international8,R.drawable.international9,R.drawable.international10,
                R.drawable.international11,R.drawable.international12,R.drawable.international13,R.drawable.international14,R.drawable.international15,
                R.drawable.international16,R.drawable.international17,R.drawable.international18,R.drawable.international19,R.drawable.international20,R.drawable.international21};
        papernames = getResources().getStringArray(R.array.Internationalsite1);


        recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, papernames, 61);
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
