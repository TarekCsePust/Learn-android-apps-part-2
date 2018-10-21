package com.example.hasantarek.asyntask_66;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView listView;
    String names[]={"Tarek","Hasan","Nasima","Morsalim","Habib","Bipul","Akash",
            "Nitun","Lucky","Tarikul"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new Mytask().execute();
    }


    class Mytask extends AsyncTask<Void,String,String>
    {
        ArrayAdapter<String>adapter;
        int count = 0;
        ProgressBar progressBar;
        @Override
        protected void onPreExecute() {
            adapter =(ArrayAdapter<String>)listView.getAdapter();
            progressBar = (ProgressBar)findViewById(R.id.prog_id);
            progressBar.setMax(10);
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            for (String name:names)
            {
                publishProgress(name);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "All data views are complete";
        }


        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            progressBar.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
        }
    }

}
