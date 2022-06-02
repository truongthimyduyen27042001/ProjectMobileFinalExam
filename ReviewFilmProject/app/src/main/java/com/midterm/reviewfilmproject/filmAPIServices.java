package com.midterm.reviewfilmproject;


import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class filmAPIServices {
    private static final  String BASE_URL = "https://60dc2b83c2b6280017feb762.mockapi.io/";
    private  filmAPI api;
    public filmAPIServices(){
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(filmAPI.class);
    }
    public Single<List<film>> getFilms(){
        return api.getFilms();
    }
}
