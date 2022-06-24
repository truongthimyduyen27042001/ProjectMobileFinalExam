package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.midterm.reviewfilmproject.databinding.FragmentSpecificFilmsBinding;

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


//  Search boxxxxxxxxxxx
    EditText search_box;
    private List<FilmsModel> filmsModelList1;
    private RecyclerView recyclerViewSearch;
    private FilmsAdapter filmsAdapter1;

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

//        Search boxxxxxxxxx
        search_box = binding.searchBox;
        recyclerViewSearch = binding.searchRec;
        filmsModelList1 = new ArrayList<>();
        filmsAdapter1 = new FilmsAdapter(getContext(),filmsModelList1);
        recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSearch.setAdapter(filmsAdapter1);
        recyclerViewSearch.setHasFixedSize(true);


        db= FirebaseFirestore.getInstance();
        if (type==1) {
            binding.typeOfFilm.setText("Hành động");
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
                        db.collection("Films").whereEqualTo("type","Action movie").whereEqualTo("name",editable.toString()).get()
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
            });
        }
        else if (type==2) {
            binding.typeOfFilm.setText("Lãng mạn");
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
                        db.collection("Films").whereEqualTo("type","Romantic movie").whereEqualTo("name",editable.toString()).get()
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
            });
        }
        else if (type==3) {
            binding.typeOfFilm.setText("Kinh dị");

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
                        db.collection("Films").whereEqualTo("type","Horror movie").whereEqualTo("name",editable.toString()).get()
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
            });
        }
        else if (type==4) {
            binding.typeOfFilm.setText("Anime");
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
                        db.collection("Films").whereEqualTo("type","Anime movie").whereEqualTo("name",editable.toString()).get()
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
            });
        }
        filmAdapter = new FilmsAdapter(getActivity(),listFilms);
        binding.rcvActionFilms.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.rcvActionFilms.setAdapter(filmAdapter);

        return view;
    }
}