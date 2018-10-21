package com.example.hasantarek.recyclerview77;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    DrawerLayout drawerLayout;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<String>arrayList = new ArrayList<>();
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.rec_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_id);
        recyclerView.setHasFixedSize(true);
        String []languages = getResources().getStringArray(R.array.languages);
        for(String lang:languages)
        {
            arrayList.add(lang);
        }

        adapter = new Recycleradapter(arrayList);
        recyclerView.setAdapter(adapter);
        actionBarDrawerToggle = new ActionBarDrawerToggle
                (this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
