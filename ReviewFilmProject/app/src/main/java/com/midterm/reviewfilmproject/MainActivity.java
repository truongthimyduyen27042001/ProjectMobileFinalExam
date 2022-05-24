package com.midterm.reviewfilmproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.midterm.reviewfilmproject.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private List<film> listFilms;
    private filmAdapter filmAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        film f = new film(1,"Phòng chat thứ n",2022,"Đây là một bộ phim xuất phát từ hàn quốc");
        film f1 = new film(2,"Phòng chat thứ n1",2022,"Đây là một bộ phim xuất phát từ Việt Nam");
        film f2 = new film(3,"Phòng chat thứ n2",2022,"Đây là một bộ phim xuất phát từ Nhật Bản");
        film f3 = new film(4,"Phòng chat thứ n3",2022,"Đây là một bộ phim xuất phát từ Trung Quốc");

        listFilms = new ArrayList<film>();
        listFilms.add(f);
        listFilms.add(f1);
        listFilms.add(f2);
        listFilms.add(f3);

        filmAdapter = new filmAdapter(this, listFilms);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        binding.rcvFilms.setLayoutManager(layoutManager);
        binding.rcvFilms.setAdapter(filmAdapter);

    }
}