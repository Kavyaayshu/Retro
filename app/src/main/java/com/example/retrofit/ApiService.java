package com.example.retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<MarvelMovieInfo>> getInfo() ;

}