package com.madebymahadevbhaktshubh.commonpracticeapp.apis;

import com.madebymahadevbhaktshubh.commonpracticeapp.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices
{
    @GET("json_user_fetch.php")
    Call<List<MovieModel>> getMovieList();
}
