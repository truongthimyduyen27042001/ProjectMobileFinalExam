package com.midterm.reviewfilmproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MyFavoriteAdapter extends RecyclerView.Adapter<MyFavoriteAdapter.ViewHolder>{

    private Context context;
    private List<FilmsModel> filmsModelList;
    FirebaseFirestore firestore;
    FirebaseAuth auth;

    public MyFavoriteAdapter(Context context, List<FilmsModel> filmsModelList) {
        this.context = context;
        this.filmsModelList = filmsModelList;
        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    @NonNull
    @Override
    public MyFavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFavoriteAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_favorite_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyFavoriteAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(filmsModelList.get(position).getImg_url()).into(holder.actionImg);
        holder.name.setText(filmsModelList.get(position).getName());
        holder.year.setText(filmsModelList.get(position).getYear());
        holder.appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firestore.collection("AddToFavorite").document(auth.getCurrentUser().getUid())
                        .collection("CurrentUser")
                        .document(filmsModelList.get(position).getDocumentId())
                        .delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    filmsModelList.remove(filmsModelList.get(position));
                                    notifyDataSetChanged();
                                    Toast.makeText(context,"Item delete",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context,"Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView actionImg;
        TextView name,year;
        AppCompatButton appCompatButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            actionImg = itemView.findViewById(R.id.imv_posterFilm);
            name = itemView.findViewById(R.id.fvr_name);
            year = itemView.findViewById(R.id.fvr_year);
            appCompatButton = itemView.findViewById(R.id.play);
        }
    }
}
