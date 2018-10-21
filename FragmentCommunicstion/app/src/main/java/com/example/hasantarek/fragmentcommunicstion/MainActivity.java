package com.example.hasantarek.fragmentcommunicstion;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity implements FragmentRadio.onColorchangeListner {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout)findViewById(R.id.main_activity);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentRadio fragmentRadio = new FragmentRadio();
        fragmentTransaction.add(R.id.fragment_container,fragmentRadio);
        fragmentTransaction.commit();
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

    @Override
    public void colorChanged(String color) {

        if(color.equals("Red"))
        {
            linearLayout.setBackgroundColor(Color.RED);
        }
        else
        if(color.equals("Green"))
        {
            linearLayout.setBackgroundColor(Color.GREEN);
        }
        else
        if(color.equals("Blue"))
        {
            linearLayout.setBackgroundColor(Color.BLUE);
        }

    }
}
