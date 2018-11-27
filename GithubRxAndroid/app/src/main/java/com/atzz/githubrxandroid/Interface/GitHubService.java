package com.atzz.githubrxandroid.Interface;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import com.atzz.githubrxandroid.DataObject.GitHubRepo;

public interface  GitHubService {
    @GET("users/{user}/starred") Observable<List<GitHubRepo>> getStarredRepositories(@Path("user") String userName);
}
