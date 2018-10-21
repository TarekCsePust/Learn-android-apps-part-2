package com.example.hasantarek.imageslider_71;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    ViewPager viewPager;
    Customadopter customadopter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.view_id);
        customadopter = new Customadopter(this);
        viewPager.setAdapter(customadopter);
    }





}
