package com.example.hasantarek.tablayout78;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tab_id);
        viewPager = (ViewPager)findViewById(R.id.view_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.add(new Homefragment(),"Home");
        viewPagerAdapter.add(new Topfree(),"Topfree");
        viewPagerAdapter.add(new Toppaid(),"Top Paid");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
