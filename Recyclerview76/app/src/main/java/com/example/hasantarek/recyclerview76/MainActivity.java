package com.example.hasantarek.recyclerview76;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Listprovider> arrayList = new ArrayList<Listprovider>();

   int image_id[]=
           {
                   R.drawable.img1,R.drawable.img2,R.drawable.img3,
                   R.drawable.img4,R.drawable.img5,R.drawable.img6
           };
    String []pro= getResources().getStringArray(R.array.actor);
    String []act= getResources().getStringArray(R.array.production);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        int count=0;
        for (String po : pro)
        {
            Listprovider listprovider = new Listprovider(image_id[count],po,act[count]);
            arrayList.add(listprovider);
            count++;
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
