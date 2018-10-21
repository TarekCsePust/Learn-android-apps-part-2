package com.example.hasantarek.expandable_63;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView)findViewById(R.id.exp_litview);
        List<String>Headings = new ArrayList<String>();
        List<String>L1 = new ArrayList<String>();
        List<String>L2 = new ArrayList<String>();
        HashMap<String,List<String>>child_items = new HashMap<String,List<String>>();
        String heading_items[]=getResources().getStringArray(R.array.header_titles);
        String h1[] = getResources().getStringArray(R.array.h1_items);
        String h2[] = getResources().getStringArray(R.array.h2_items);
        for (String title:heading_items)
        {
            Headings.add(title);
        }

        for (String item:h1)
        {
            L1.add(item);
        }
        for (String item:h2)
        {
            L2.add(item);
        }
        child_items.put(Headings.get(0),L1);
        child_items.put(Headings.get(1),L2);
        Myadapter myadapter = new Myadapter(this,Headings,child_items);
        expandableListView.setAdapter(myadapter);
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
