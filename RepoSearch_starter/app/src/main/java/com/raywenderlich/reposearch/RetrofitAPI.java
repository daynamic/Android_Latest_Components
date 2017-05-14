package com.raywenderlich.reposearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asharm93 on 5/14/17.
 */

public interface RetrofitAPI {

    @GET("/repositories")
    Call<ArrayList<Repository>> retrieveRepositories();
}
