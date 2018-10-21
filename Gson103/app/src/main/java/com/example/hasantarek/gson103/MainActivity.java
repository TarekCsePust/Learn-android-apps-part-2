package com.example.hasantarek.gson103;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String server_url = "http://192.168.141.2/androidpb103.php";
    RecylcerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        getInfromation();


    }

    public void getInfromation()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        List<Contact> arrayList = Arrays.asList(gson.fromJson(response,Contact[].class));
                        adapter = new RecylcerAdapter(arrayList);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Some wrong",Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        Mysingleton.getmInstance(this).addTorequest(stringRequest);
    }
}
