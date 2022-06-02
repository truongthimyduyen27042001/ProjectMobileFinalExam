package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.midterm.reviewfilmproject.databinding.FragmentStoreBinding;

import java.util.List;

public class StoreFragment extends Fragment {

    private FragmentStoreBinding binding;
    private List<film> listFilms;
    private filmAdapter filmAdapter;
    private filmTrendAdapter filmTrendAdapter;
    private List<film> listTrendFilms;
    public StoreFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
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
                SpecificFilmsFragment specificFilmsFragment = new SpecificFilmsFragment();
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