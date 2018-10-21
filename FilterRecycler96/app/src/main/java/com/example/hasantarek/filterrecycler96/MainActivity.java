package com.example.hasantarek.filterrecycler96;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    String []countrys = {"Bangladesh","Arjentina","Armenia","Brazil","Greece",
    "Kuwait","Libya","Pakistan","Taiwan","UK"};

    int []flags = {R.drawable.bangladesh,R.drawable.arjentina,R.drawable.armenia,
    R.drawable.brazil,R.drawable.greece,R.drawable.kuwait,R.drawable.libya,
    R.drawable.pakistan,R.drawable.taiwan,R.drawable.uk};

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Country>arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        int count = 0;
        for(int id:flags)
        {
            Country country = new Country(countrys[count],id);
            arrayList.add(country);
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Country>newarrylist = new ArrayList<>();
        for (Country country:arrayList)
        {
            String name = country.getName().toLowerCase();
            if(name.contains(newText))
            {
                newarrylist.add(country);
            }
        }

        adapter.setFilter(newarrylist);
        return true;
    }
}
