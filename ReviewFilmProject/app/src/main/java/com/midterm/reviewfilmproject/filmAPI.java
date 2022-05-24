package com.midterm.reviewfilmproject;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface filmAPI {
    @GET("/todolist/films")
    public Single<List<film>> getFilms();

}
