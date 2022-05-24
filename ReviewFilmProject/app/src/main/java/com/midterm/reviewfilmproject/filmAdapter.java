package com.midterm.reviewfilmproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class filmAdapter extends RecyclerView.Adapter<filmAdapter.FilmHoder>{
    private List<film> mFimls;

    public void setData(List<film> films) {
        mFimls = films;
    }
    public filmAdapter(MainActivity mainActivity, List<film> films) {
        mFimls = films;
    }

    @NonNull
    @Override
    public FilmHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemfilm,parent,
                        false);
        return new FilmHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHoder holder, int position) {
        holder.tvName.setText(mFimls.get(position).getName());
        holder.tvDesc.setText(mFimls.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mFimls.size();
    }

    //Create a item film view

    public static class FilmHoder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvDesc;

        public FilmHoder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
        }

        public TextView getName() {
            return tvName;
        }
        public TextView getDesc() {
            return tvDesc;
        }
    }

}




