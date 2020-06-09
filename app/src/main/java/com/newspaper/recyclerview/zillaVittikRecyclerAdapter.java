package com.newspaper.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class zillaVittikRecyclerAdapter extends RecyclerView.Adapter<zillaVittikRecyclerAdapter.ViewHolder> {

    private List<Pair<String, Integer>> ab;
    private List<Pair<String, Integer>> clone = new ArrayList<>();
    private String[] districtnames;
    private Context context;

    public zillaVittikRecyclerAdapter(List<Pair<String, Integer>> ab, String[] districtnames) {
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
        demos.setImageResource(ab.get(position).second);
        context = holder.itemView.getContext();

        demos.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.left_to_right));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = 0;
                String value = ab.get(position).first;

                for(int i=0; i<61; i++)
                {
                    if(value.equals(districtnames[i]))
                    {
                        x=i;
                        break;
                    }
                }

                if(!isInternetAvailable())
                {
                    Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                    return;
                }

                else
                {
                    Intent intent1=new Intent(context, zillanewspaper.class);
                    intent1.putExtra("key",x);
                    context.startActivity(intent1);
                }

            }
        });
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

    public boolean isInternetAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }


    public void filter(String text) {
        ab.clear();
        if(text.isEmpty()){
            ab.addAll(clone);
        } else{
            text = text.toLowerCase();
            for(Pair<String,Integer> item: clone){
                if(item.first.toLowerCase().contains(text)){
                    ab.add(item);
                }
            }

        }
        notifyDataSetChanged();
    }

}
