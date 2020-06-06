package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {

    private Context context;
    private int[] flag;
    private String[] papernames;
    private List<Pair<String, Integer>> pii = new ArrayList<>();
    private List<Pair<String, Integer>> clone = new ArrayList<>();
    private int intentVar;
    Intent intent2;

    public Myadapter(Context context, int[] flag, String[] papernames, int intentVar) {
        this.context = context;
        this.flag = flag;
        this.papernames = papernames;
        this.intentVar = intentVar;

        int length = papernames.length;

        for(int i=0; i<length; i++)
        {
            pii.add(new Pair(papernames[i], flag[i]));
        }

        clone.addAll(pii);
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample, viewGroup, false);
        return new Myviewholder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, final int position) {

        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.zillaWiseImage);
        TextView textView = cardView.findViewById(R.id.zillaWiseText);

        cardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.left_to_right));
        imageView.setImageResource(pii.get(position).second);
        textView.setText(pii.get(position).first);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = intentVar;

                if(intentVar == 66)
                {
                    intent2 = new Intent(context, commonweb2.class);
                }
                else
                {
                    intent2 = new Intent(context, commonweb.class);
                }

                intent2.putExtra("key1", position);
                intent2.putExtra("key2",x);
                context.startActivity(intent2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return flag.length;
    }

    public class Myviewholder extends RecyclerView.ViewHolder{

        private CardView cardView;

        public Myviewholder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }


}

