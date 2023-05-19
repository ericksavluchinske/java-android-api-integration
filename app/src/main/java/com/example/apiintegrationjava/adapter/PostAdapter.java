package com.example.apiintegrationjava.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiintegrationjava.R;
import com.example.apiintegrationjava.model.Post;
import com.example.apiintegrationjava.view.PostDetails;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    private Context context;
    private ArrayList<Post> postList;

    public PostAdapter(Context context, ArrayList<Post> postList){
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.post_list_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.postTitle.setText(postList.get(position).getTitle());
        holder.postBody.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        public TextView postTitle, postBody;

        public PostViewHolder(View itemView){
            super(itemView);

            postTitle = itemView.findViewById(R.id.tvPostTitle);
            postBody = itemView.findViewById(R.id.tvPostBody);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    if (position!=RecyclerView.NO_POSITION){

                        Post selectedPost = postList.get(position);

                        Toast.makeText(context,selectedPost.getTitle(),Toast.LENGTH_LONG).show();
                        Log.i("TAG", "onClick: " + selectedPost.getTitle());

                        Intent intent = new Intent(context, PostDetails.class);

                        intent.putExtra("title",selectedPost.getTitle());
                        intent.putExtra("body",selectedPost.getBody());

                        intent.putExtra("id",selectedPost.getId());
                        intent.putExtra("userId",selectedPost.getUserId());

                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}