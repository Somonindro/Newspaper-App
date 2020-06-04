package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class english extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        flag=new int[]{R.drawable.eng1,R.drawable.eng2,R.drawable.eng3,R.drawable.eng4,R.drawable.eng5,R.drawable.eng6,R.drawable.eng7,
                R.drawable.eng8,R.drawable.eng9,R.drawable.eng10,R.drawable.eng11,R.drawable.eng12,R.drawable.eng13,R.drawable.eng14,
                R.drawable.eng15,R.drawable.eng16,R.drawable.eng17,R.drawable.eng18,R.drawable.eng19,R.drawable.eng20,R.drawable.eng21};

        recyclerView=(RecyclerView)findViewById(R.id.recyclerviewid);

        myadapter=new Myadapter(this,flag);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myadapter.setOnItemClickListener(new Myadapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent=new Intent(english.this,commonweb.class);
                intent.putExtra("key3",position);
                intent.putExtra("key4",1);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Intent intent=new Intent(english.this,commonweb.class);
                intent.putExtra("key3",position);
                intent.putExtra("key4",1);
                startActivity(intent);
            }

        });

    }
}
