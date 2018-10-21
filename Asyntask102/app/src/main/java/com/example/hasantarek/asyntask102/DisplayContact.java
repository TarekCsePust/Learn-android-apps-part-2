package com.example.hasantarek.asyntask102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

public class DisplayContact extends AppCompatActivity {

    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        progressBar = (ProgressBar)findViewById(R.id.progress_id);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new BackgroundTask(recyclerView,progressBar,this).execute();

    }
}
