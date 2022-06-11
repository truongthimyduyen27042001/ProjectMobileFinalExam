package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.midterm.reviewfilmproject.databinding.FragmentStoreBinding;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment {

    private FragmentStoreBinding binding;

    public StoreFragment() {
    }

    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStoreBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        OverViewFilmsFragment overViewFilmsFragment = new OverViewFilmsFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, overViewFilmsFragment, null)
                .setReorderingAllowed(true)
                .addToBackStack(null) // name can be null
                .commit();

        //set event for action films
        binding.tvAllFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OverViewFilmsFragment overViewFilmsFragment = new OverViewFilmsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, overViewFilmsFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();
            }
        });
        binding.tvActionFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView typeFilm = binding.tvActionFilms;
                SpecificFilmsFragment specificFilmsFragment = new SpecificFilmsFragment();
                Bundle args = new Bundle();
                args.putSerializable("type", "1");
                specificFilmsFragment.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, specificFilmsFragment, null)
                        .setReorderingAllowed(true)

                        .addToBackStack(null) // name can be null
                        .commit();
            }
        });
        //set event for romantic films
        binding.tvRomanticFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecificFilmsFragment specificFilmsFragment = new SpecificFilmsFragment();
                Bundle args = new Bundle();
                args.putSerializable("type", "2");
                specificFilmsFragment.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, specificFilmsFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();
            }
        });
        //set event for horrified films
        binding.tvHorrifiedFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecificFilmsFragment specificFilmsFragment = new SpecificFilmsFragment();
                Bundle args = new Bundle();
                args.putSerializable("type", "3");
                specificFilmsFragment.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, specificFilmsFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();
            }
        });
        //set event for anime films
        binding.tvAnimeFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecificFilmsFragment specificFilmsFragment = new SpecificFilmsFragment();
                Bundle args = new Bundle();
                args.putSerializable("type", "4");
                specificFilmsFragment.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, specificFilmsFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();
            }
        });


        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}