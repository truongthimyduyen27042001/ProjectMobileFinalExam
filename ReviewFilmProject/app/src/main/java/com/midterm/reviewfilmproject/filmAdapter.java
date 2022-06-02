package com.midterm.reviewfilmproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class filmAdapter extends RecyclerView.Adapter<filmAdapter.FilmHoder>{
    private static List<film> mFimls;
    public static Context context;
    public void setData(List<film> films) {
        mFimls = films;
    }
    public filmAdapter(List<film> films) {
        mFimls = films;
    }

    @NonNull
    @Override
    public FilmHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemfilm,parent,
                        false);
        return new FilmHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHoder holder, int position) {
        film film = mFimls.get(position);
        holder.tvNameFilm.setText(film.getName());
        if (film.isFavorite()) {
            holder.fvrButton.setBackgroundResource(R.drawable.ic_baseline_red_favorite_24);
        }
        else  {
            holder.fvrButton.setBackgroundResource(R.drawable.ic_baseline_shadow_favorite_24);
        }
    }

    @Override
    public int getItemCount() {
        return mFimls.size();
    }

    //Create a item film view

    public static class FilmHoder extends RecyclerView.ViewHolder {
        private final TextView tvNameFilm;
        private final ImageView imvPosterFilm;
        private final ImageButton fvrButton;
        public FilmHoder(View view) {
            super(view);
            tvNameFilm = (TextView) view.findViewById(R.id.tv_nameFilm);
            imvPosterFilm = (ImageView) view.findViewById(R.id.imv_posterFilm);
            fvrButton = (ImageButton) view.findViewById(R.id.ibtn_favorieBTN);
            fvrButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    film film = mFimls.get(position);
                    if (film.isFavorite()) {
                        fvrButton.setBackgroundResource(R.drawable.ic_baseline_shadow_favorite_24);
                    }
                    else  {
                        fvrButton.setBackgroundResource(R.drawable.ic_baseline_red_favorite_24);
                    }
                    film.setFavorite(!film.isFavorite());

                }
            });
        }

        public TextView getTvNameFilm() {
            return tvNameFilm;
        }
        public ImageView getImvPosterFilm() {
            return imvPosterFilm;
        }
        public ImageButton getFvrButton() {
            return fvrButton;
        }
    }

}




