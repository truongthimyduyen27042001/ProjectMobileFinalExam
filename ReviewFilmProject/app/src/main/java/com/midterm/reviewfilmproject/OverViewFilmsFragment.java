package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.midterm.reviewfilmproject.databinding.FragmentOverViewFilmsBinding;

import java.util.ArrayList;
import java.util.List;


public class OverViewFilmsFragment extends Fragment {
    private FragmentOverViewFilmsBinding binding;
    ScrollView scrollView;
    ProgressBar progressBar;
    public OverViewFilmsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    RecyclerView ActionRec;
    RecyclerView AnimeRec;
    RecyclerView RomanRec;
    RecyclerView HorrorRec;
    RecyclerView TrendRec;
    FirebaseFirestore db;
    // Action film

    List<FilmsModel> filmsModelListTrend;
    FilmsAdapter filmsAdapterTrend;
    List<FilmsModel> filmsModelList;
    FilmsAdapter filmsAdapter;
    List<FilmsModel> filmsModelList2;
    FilmsAdapter filmsAdapter2;
    List<FilmsModel> filmsModelList3;
    FilmsAdapter filmsAdapter3;
    List<FilmsModel> filmsModelList4;
    FilmsAdapter filmsAdapter4;
    List<FilmsModel> filmsModelList5;
    FilmTrendAdapter filmsAdapter5;


    EditText search_box;
    private List<FilmsModel> filmsModelList1;
    private RecyclerView recyclerViewSearch;
    private FilmsAdapter filmsAdapter1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOverViewFilmsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        db = FirebaseFirestore.getInstance();

        TrendRec = binding.rcvFilmsTrend;
        ActionRec = binding.rcvActionFilms;
        AnimeRec = binding.rcvAnimeFilms;
        RomanRec = binding.rcvRomanticFilms;
        HorrorRec = binding.rcvHorrifiedFilms;
        scrollView = binding.scrollView;
        progressBar = binding.progressbar;
        TrendRec =   binding.rcvFilmsTrend;

        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

//        ActionRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
//        actionFilmsModelList = new ArrayList<>();
//        actionFilmsAdapter = new ActionFilmsAdapter(getActivity(),actionFilmsModelList);
//        ActionRec.setAdapter(actionFilmsAdapter);

        TrendRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        filmsModelListTrend = new ArrayList<>();
        filmsAdapterTrend = new FilmsAdapter(getActivity(), filmsModelListTrend);
        TrendRec.setAdapter(filmsAdapterTrend);

        ActionRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        filmsModelList = new ArrayList<>();
        filmsAdapter = new FilmsAdapter(getActivity(),filmsModelList);
        ActionRec.setAdapter(filmsAdapter);

        AnimeRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        filmsModelList2 = new ArrayList<>();
        filmsAdapter2 = new FilmsAdapter(getActivity(),filmsModelList2);
        AnimeRec.setAdapter(filmsAdapter2);

        RomanRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        filmsModelList3 = new ArrayList<>();
        filmsAdapter3 = new FilmsAdapter(getActivity(),filmsModelList3);
        RomanRec.setAdapter(filmsAdapter3);

        HorrorRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        filmsModelList4 = new ArrayList<>();
        filmsAdapter4 = new FilmsAdapter(getActivity(),filmsModelList4);
        HorrorRec.setAdapter(filmsAdapter4);

        TrendRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        filmsModelList5 = new ArrayList<>();
        filmsAdapter5 = new FilmTrendAdapter(getActivity(),filmsModelList5);
        TrendRec.setAdapter(filmsAdapter5);
      
        db.collection("Films").whereEqualTo("type", "Action movie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                FilmsModel filmsModel = document.toObject(FilmsModel.class);
                                filmsModelList.add(filmsModel);
                                filmsAdapter.notifyDataSetChanged();

                                progressBar.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                            }
                        } else {
                            Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        db.collection("Films").whereEqualTo("type", "Anime movie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                FilmsModel filmsModel2 = document.toObject(FilmsModel.class);
                                filmsModelList2.add(filmsModel2);
                                filmsAdapter2.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        db.collection("Films").whereEqualTo("type", "Horror movie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                FilmsModel filmsModel3 = document.toObject(FilmsModel.class);
                                filmsModelList4.add(filmsModel3);
                                filmsAdapter4.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        db.collection("Films").whereEqualTo("type", "Romantic movie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                FilmsModel filmsModel4 = document.toObject(FilmsModel.class);
                                filmsModelList3.add(filmsModel4);
                                filmsAdapter3.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        db.collection("Films").whereEqualTo("istrending", true)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                FilmsModel filmsModel5 = document.toObject(FilmsModel.class);
                                filmsModelList5.add(filmsModel5);
                                filmsAdapter5.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "ERROR"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        //set event for choice actions film
        search_box = binding.searchBox;
        recyclerViewSearch = binding.searchRec;
        filmsModelList1 = new ArrayList<>();
        filmsAdapter1 = new FilmsAdapter(getContext(),filmsModelList1);
        recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSearch.setAdapter(filmsAdapter1);
        recyclerViewSearch.setHasFixedSize(true);
        search_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    filmsModelList1.clear();
                    filmsAdapter1.notifyDataSetChanged();
                }else{
                    searchFilm(editable.toString());
                }
            }
        });

        return view;
    }
    private void searchFilm(String film){

        db.collection("Films").whereEqualTo("name",film).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful() && task.getResult() != null){
                            filmsModelList1.clear();
                            filmsAdapter1.notifyDataSetChanged();
                            for(DocumentSnapshot doc : task.getResult().getDocuments()){
                                FilmsModel filmsModel = doc.toObject(FilmsModel.class);

                                filmsModelList1.add(filmsModel);
                                filmsAdapter1.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}