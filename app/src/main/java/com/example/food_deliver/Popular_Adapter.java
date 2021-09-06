package com.example.food_deliver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food_deliver.model.Popular;

import java.util.List;

public class Popular_Adapter extends RecyclerView.Adapter<Popular_Adapter.PopularViewHolder> {

     private Context context;
     private List<Popular>popularList;

    public Popular_Adapter(Context context, List<Popular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_rv_items,parent,false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.popularName.setText(popularList.get(position).getName());

        //for image add glide library

        Glide.with(context).load(popularList.get(position)).into(holder.popularImage);
    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder{

        ImageView popularImage;
        TextView popularName;


        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.all_menu_name);
            popularImage=itemView.findViewById(R.id.all_menu_image);

        }
    }
}
