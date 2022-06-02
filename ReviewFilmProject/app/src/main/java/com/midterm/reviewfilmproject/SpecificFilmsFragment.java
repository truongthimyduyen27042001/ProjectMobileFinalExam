package com.midterm.reviewfilmproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.midterm.reviewfilmproject.databinding.FragmentSpecificFilmsBinding;

import java.util.ArrayList;
import java.util.List;


public class SpecificFilmsFragment extends Fragment {

    FragmentSpecificFilmsBinding binding;
    private List<film> listFilms;
    private filmAdapter filmAdapter;
    private filmTrendAdapter filmTrendAdapter;
    private List<film> listTrendFilms;

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

        film f = new film(1,"Phòng chat thứ n",2022,"Đây là một bộ phim xuất phát từ hàn quốc",false);
        film f1 = new film(2,"Phòng chat thứ n1",2022,"Đây là một bộ phim xuất phát từ Việt Nam",true);
        film f2 = new film(3,"Phòng chat thứ n2",2022,"Đây là một bộ phim xuất phát từ Nhật Bản",false);
        film f3 = new film(4,"Phòng chat thứ n3",2022,"Đây là một bộ phim xuất phát từ Trung Quốc",true);
        film f4 = new film(1,"Phòng chat thứ n",2022,"Đây là một bộ phim xuất phát từ hàn quốc",false);
        film f5 = new film(5,"Phòng chat thứ n1",2022,"Đây là một bộ phim xuất phát từ Việt Nam",true);
        film f6 = new film(6,"Phòng chat thứ n2",2022,"Đây là một bộ phim xuất phát từ Nhật Bản",false);
        film f7 = new film(7,"Phòng chat thứ n3",2022,"Đây là một bộ phim xuất phát từ Trung Quốc",false);
        film f8 = new film(8,"Phòng chat thứ n",2022,"Đây là một bộ phim xuất phát từ hàn quốc",true);
        film f9 = new film(9,"Phòng chat thứ n1",2022,"Đây là một bộ phim xuất phát từ Việt Nam",true);
        film f10 = new film(10,"Phòng chat thứ n2",2022,"Đây là một bộ phim xuất phát từ Nhật Bản",false);
        film f11 = new film(11,"Phòng chat thứ n3",2022,"Đây là một bộ phim xuất phát từ Trung Quốc",true);

        listFilms = new ArrayList<film>();
        listFilms.add(f);
        listFilms.add(f1);
        listFilms.add(f2);
        listFilms.add(f3);

        listTrendFilms = new ArrayList<film>();
        listTrendFilms.add(f);
        listTrendFilms.add(f1);
        listTrendFilms.add(f2);
        listTrendFilms.add(f3);
        listTrendFilms.add(f4);
        listTrendFilms.add(f5);
        listTrendFilms.add(f6);
        listTrendFilms.add(f7);
        listTrendFilms.add(f8);
        listTrendFilms.add(f9);
        listTrendFilms.add(f10);
        listTrendFilms.add(f11);

        filmAdapter = new filmAdapter(listFilms);
        filmTrendAdapter = new filmTrendAdapter(listTrendFilms);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        binding.rcvActionFilms.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.rcvActionFilms.setAdapter(filmAdapter);

        binding.rcvFilmsTrend.setLayoutManager(layoutManager2);
        binding.rcvFilmsTrend.setAdapter(filmTrendAdapter);

        return view;
    }
}