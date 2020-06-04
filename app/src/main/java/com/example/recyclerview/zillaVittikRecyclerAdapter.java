package com.example.recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class zillaVittikRecyclerAdapter extends RecyclerView.Adapter<zillaVittikRecyclerAdapter.ViewHolder> {

    private List<Integer> ab;
    private List<Integer> clone = new ArrayList<Integer>();
    private String[] districtnames;
    private final static int FADE_DURATION = 500;

    public zillaVittikRecyclerAdapter(List<Integer> ab, String[] districtnames) {
        this.ab = ab;
        clone.addAll(ab);
        this.districtnames = districtnames;
    }

    @NonNull
    @Override
    public zillaVittikRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) LayoutInflater.from(parent.getContext()).inflate(R.layout.showzillavittik, parent, false);
        return new ViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull final zillaVittikRecyclerAdapter.ViewHolder holder, final int position) {
        ImageView imageView = holder.imageView;
        ImageView demos = imageView.findViewById(R.id.zillaImageView);
        demos.setImageResource(ab.get(position));

        demos.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.left_to_right));

        /*//These things needed to be modified here
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = 0;
                Integer value = ab.get(position);

                for(int i=0; i<61; i++)
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
*/
    }

    @Override
    public int getItemCount() {
        return ab.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            imageView = itemView;
        }
    }


    public void filter(String text) {
        ab.clear();
        if(text.isEmpty()){
            ab.addAll(clone);
        } else{
            /*
            text = text.toLowerCase();
            for(String item: clone){
                if(item.toLowerCase().contains(text)){
                    ab.add(item);
                }
            }
            */
        }
        notifyDataSetChanged();
    }

}
