package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.midterm.reviewfilmproject.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentOne fragmentOne = new FragmentOne();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentOne, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();

            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentTwo fragmentTwo = new FragmentTwo();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragmentTwo, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();

            }
        });
        return view;

    }
}