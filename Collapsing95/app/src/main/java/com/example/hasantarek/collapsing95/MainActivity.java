package com.example.hasantarek.collapsing95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Album>arrayList = new ArrayList<>();
    int []img_id = {R.drawable.img1,
    R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        for(int id:img_id)
        {
            arrayList.add(new Album(id));
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);



    }
}
