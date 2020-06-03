package com.example.recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class zillaVittikRecyclerAdapter extends RecyclerView.Adapter<zillaVittikRecyclerAdapter.ViewHolder> {

    private List<String> ab;
    private List<String> clone = new ArrayList<String>();
    private String[] districtnames;
    private final static int FADE_DURATION = 500;

    public zillaVittikRecyclerAdapter(List<String> ab, String[] districtnames) {
        this.ab = ab;
        clone.addAll(ab);
        this.districtnames = districtnames;
    }

    @NonNull
    @Override
    public zillaVittikRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.showzillavittik, parent, false);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull final zillaVittikRecyclerAdapter.ViewHolder holder, final int position) {
        TextView textView = holder.textView;
        TextView demos = textView.findViewById(R.id.zillatextview);
        demos.setText(ab.get(position));

        demos.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.left_to_right));

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = 0;
                String value = ab.get(position);

                for(int i=0;i<61;i++)
                {
                    if(value.equals(districtnames[i]))
                    {
                        x=i;
                        break;
                    }
                }

                Intent intent1=new Intent(holder.itemView.getContext(), zillanewspaper.class);
                intent1.putExtra("key",x);
                holder.itemView.getContext().startActivity(intent1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ab.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull TextView itemView) {
            super(itemView);
            textView = itemView;
        }
    }


    public void filter(String text) {
        ab.clear();
        if(text.isEmpty()){
            ab.addAll(clone);
        } else{
            text = text.toLowerCase();
            for(String item: clone){
                if(item.toLowerCase().contains(text)){
                    ab.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}
