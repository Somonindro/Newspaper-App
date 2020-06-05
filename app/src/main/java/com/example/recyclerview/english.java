package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class english extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;
    private String[] papernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        setTitle("English Newspapers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        flag=new int[]{R.drawable.eng1,R.drawable.eng2,R.drawable.eng3,R.drawable.eng4,R.drawable.eng5,R.drawable.eng6,R.drawable.eng7,
                R.drawable.eng8,R.drawable.eng9,R.drawable.eng10,R.drawable.eng11,R.drawable.eng12,R.drawable.eng13,R.drawable.eng14,
                R.drawable.eng15,R.drawable.eng16,R.drawable.eng17,R.drawable.eng18,R.drawable.eng19,R.drawable.eng20,R.drawable.eng21};
        papernames = getResources().getStringArray(R.array.Englishnewspaper1);


        recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, papernames, 60);
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
