package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class international extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);
    }
        /*

        flag=new int[]{R.drawable.international1,R.drawable.international2,R.drawable.international3,R.drawable.international4,R.drawable.international5,
                R.drawable.international6,R.drawable.international7,R.drawable.international8,R.drawable.international9,R.drawable.international10,
                R.drawable.international11,R.drawable.international12,R.drawable.international13,R.drawable.international14,R.drawable.international15,
                R.drawable.international16,R.drawable.international17,R.drawable.international18,R.drawable.international19,R.drawable.international20,R.drawable.international21};

        recyclerView=(RecyclerView)findViewById(R.id.recyclerviewid);

        myadapter=new Myadapter(this,flag);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myadapter.setOnItemClickListener(new Myadapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent=new Intent(international.this,commonweb.class);
                intent.putExtra("key5",position);
                intent.putExtra("key4",2);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Intent intent=new Intent(international.this,commonweb.class);
                intent.putExtra("key5",position);
                intent.putExtra("key4",2);
                startActivity(intent);
            }

        });
    }
         */
}
