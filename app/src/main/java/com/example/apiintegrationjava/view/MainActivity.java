package com.example.apiintegrationjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.apiintegrationjava.R;
import com.example.apiintegrationjava.adapter.PostAdapter;
import com.example.apiintegrationjava.model.Post;
import com.example.apiintegrationjava.service.PostService;
import com.example.apiintegrationjava.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Post> postList = new ArrayList<>();

    private RecyclerView recyclerView;

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPosts();
    }

    public void getPosts(){

        PostService postService = RetrofitInstance.getService();
        Call<List<Post>> call = postService.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccessful()){
                    postList = response.body();
                    showOnRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    private void showOnRecyclerView(){

        recyclerView = (RecyclerView) findViewById(R.id.rvPosts);
        postAdapter = new PostAdapter(this, (ArrayList<Post>) postList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
    }
}