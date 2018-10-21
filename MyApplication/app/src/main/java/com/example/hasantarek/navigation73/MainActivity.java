package com.example.hasantarek.navigation73;

import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideItem();
        toolbar = (Toolbar)findViewById(R.id.toolbar_id);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_id);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new Homefragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home Fragment");
        navigationView = (NavigationView)findViewById(R.id.navigation_id);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Homefragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home Fragment");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.delete_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Deletefragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Delete Fragment");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.setting_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Settingfrag());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Setting Fragment");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    private void hideItem()
    {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_id);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.setting_id).setVisible(false);
    }
}
