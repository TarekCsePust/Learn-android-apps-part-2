package com.example.hasantarek.volley91;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact>arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Backgroundtask backgroundtask = new Backgroundtask(DisplayList.this);
        arrayList = backgroundtask.getList();
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
