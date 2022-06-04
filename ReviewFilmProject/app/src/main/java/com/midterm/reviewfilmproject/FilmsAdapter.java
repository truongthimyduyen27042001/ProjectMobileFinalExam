package com.midterm.reviewfilmproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private Context context;
    private List<FilmsModel> filmsModelList;

    public FilmsAdapter(Context context, List<FilmsModel> filmsModelList) {
        this.context = context;
        this.filmsModelList = filmsModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfilm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(filmsModelList.get(position).getImg_url()).into(holder.actionImg);
        holder.name.setText(filmsModelList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("detail",filmsModelList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView actionImg;
        TextView name,type,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            actionImg = itemView.findViewById(R.id.imv_posterFilm);
            name = itemView.findViewById(R.id.tv_nameFilm);
        }
    }
}