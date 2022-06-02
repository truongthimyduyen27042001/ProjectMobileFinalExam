package com.midterm.reviewfilmproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class filmTrendAdapter extends RecyclerView.Adapter<filmTrendAdapter.FilmTrendHolder> {
    private List<film> mFimls;

    public filmTrendAdapter(List<film> films) {
        mFimls = films;
    }

    @NonNull
    @Override
    public FilmTrendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_film_trend,parent,
                        false);
        return new FilmTrendHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmTrendHolder holder, int position) {
//        holder.tvName.setText(mFimls.get(position).getName());
//        holder.tvDesc.setText(mFimls.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mFimls.size();
    }
    public static class FilmTrendHolder extends RecyclerView.ViewHolder {
//        private final TextView tvName;
//        private final TextView tvDesc;

        public FilmTrendHolder(@NonNull View itemView) {
            super(itemView);
//            tvName = (TextView) view.findViewById(R.id.tv_name);
//            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
        }
        //        public TextView getName() {
//            return tvName;
//        }
//        public TextView getDesc() {
//            return tvDesc;
//        }

    }
}
