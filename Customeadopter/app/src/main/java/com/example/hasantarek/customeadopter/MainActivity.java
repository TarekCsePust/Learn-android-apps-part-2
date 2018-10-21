package com.example.hasantarek.customeadopter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private int []images={
            R.drawable.business,R.drawable.sultan,R.drawable.kabil,
            R.drawable.raees,R.drawable.tublight
    };
    private  String []movies;
    private  String []ratings;
     Movieadpter movieadpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        movies = getResources().getStringArray(R.array.movie_name);
        ratings = getResources().getStringArray(R.array.movie_rating);
        movieadpter = new Movieadpter(getApplicationContext(),R.layout.row_custom);
        listView.setAdapter(movieadpter);
        int i=0;
        for(String movie:movies)
        {
            Moviedataprovider data = new Moviedataprovider(images[i],movie,ratings[i]);
            movieadpter.add(data);
            i++;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
