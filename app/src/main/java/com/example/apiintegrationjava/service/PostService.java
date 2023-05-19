package com.example.apiintegrationjava.service;

import com.example.apiintegrationjava.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("/posts")
    Call<List<Post>> getPosts();

}
