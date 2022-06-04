package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.midterm.reviewfilmproject.databinding.FragmentSpecificFilmsBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SpecificFilmsFragment extends Fragment {

    FragmentSpecificFilmsBinding binding;
    private List<FilmsModel> listFilms;
    private FilmsAdapter filmAdapter;
    List<FilmsModel> filmsModelList5;
    FilmTrendAdapter filmsAdapter5;
    FirebaseFirestore db;
    int type;

    public SpecificFilmsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSpecificFilmsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.rcvFilmsTrend.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        filmsModelList5 = new ArrayList<>();
        filmsAdapter5 = new FilmTrendAdapter(getActivity(),filmsModelList5);
        binding.rcvFilmsTrend.setAdapter(filmsAdapter5);

        //test
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = getParentFragment().getArguments();
        }
        if (arguments != null) {
            type = Integer.parseInt(arguments.getSerializable("type").toString());
        }

        listFilms = new ArrayList<FilmsModel>();
        db= FirebaseFirestore.getInstance();
        if (type==1) {

            db.collection("Films").whereEqualTo("type","Action movie")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    listFilms.add(f);
                                    filmAdapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            db.collection("Films").whereEqualTo("type","Action movie").whereEqualTo("istrending", true)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    filmsModelList5.add(f);
                                    filmsAdapter5.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else if (type==2) {
            db.collection("Films").whereEqualTo("type","Romantic movie")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    listFilms.add(f);
                                    filmAdapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            db.collection("Films").whereEqualTo("type","Romantic movie").whereEqualTo("istrending", true)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    filmsModelList5.add(f);
                                    filmsAdapter5.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else if (type==3) {
            db.collection("Films").whereEqualTo("type","Horror movie")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    listFilms.add(f);
                                    filmAdapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            db.collection("Films").whereEqualTo("type","Horror movie").whereEqualTo("istrending", true)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    filmsModelList5.add(f);
                                    filmsAdapter5.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else if (type==4) {
            db.collection("Films").whereEqualTo("type","Anime movie")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    listFilms.add(f);
                                    filmAdapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            db.collection("Films").whereEqualTo("type","Anime movie").whereEqualTo("istrending", true)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for (QueryDocumentSnapshot document : task.getResult()){
                                    FilmsModel f = document.toObject(FilmsModel.class);
                                    filmsModelList5.add(f);
                                    filmsAdapter5.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        filmAdapter = new FilmsAdapter(getActivity(),listFilms);
        binding.rcvActionFilms.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.rcvActionFilms.setAdapter(filmAdapter);

        return view;
    }
}