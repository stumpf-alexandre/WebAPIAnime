package com.example.als.myanime;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyViewHolder> {
    private Context context;
    private List<Anime> data;
    RequestOptions options;

    public AnimeAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.adapter_anime, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.rating.setText(data.get(position).getRating());
        holder.studio.setText(data.get(position).getStudio());
        holder.category.setText(data.get(position).getCategorie());

        Glide.with(context).load(data.get(position).getImage()).apply(options).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView rating;
        TextView studio;
        TextView category;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            studio = itemView.findViewById(R.id.studio);
            category = itemView.findViewById(R.id.category);
            img = itemView.findViewById(R.id.thumbnail);
        }
    }
}