package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.midterm.reviewfilmproject.databinding.FragmentGiftsBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private FragmentGiftsBinding binding;

    FirebaseFirestore db;
    FirebaseAuth auth;

    RecyclerView recyclerView;
    MyFavoriteAdapter myFavoriteAdapter;
    List<FilmsModel> filmsModelList;

    public FavoriteFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGiftsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));

        filmsModelList = new ArrayList<>();
        myFavoriteAdapter = new MyFavoriteAdapter(getActivity(),filmsModelList);
        recyclerView.setAdapter(myFavoriteAdapter);

        db.collection("AddToFavorite").document(auth.getCurrentUser().getUid())
            .collection("CurrentUser").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot documentSnapshot : task.getResult().getDocuments()){
                        String documentId = documentSnapshot.getId();
                        FilmsModel filmsModel = documentSnapshot.toObject(FilmsModel.class);
                        filmsModel.setDocumentId(documentId);
                        filmsModelList.add(filmsModel);
                        myFavoriteAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        return view;
    }
}