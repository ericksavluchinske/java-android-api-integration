package com.example.apiintegrationjava.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apiintegrationjava.R;
import com.example.apiintegrationjava.model.Post;

public class PostDetails extends AppCompatActivity {

    private TextView postTitle, postBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        postTitle = (TextView) findViewById(R.id.tvTitle);
        postBody = (TextView) findViewById(R.id.tvBody);

        Bundle data = getIntent().getExtras();

        String title = data.getString("title");
        String body = data.getString("body");
        int id = data.getInt("id");
        int userId = data.getInt("userId");

        postTitle.setText(title);
        postBody.setText(body);
    }
}