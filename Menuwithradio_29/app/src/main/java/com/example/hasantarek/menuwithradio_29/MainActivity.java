package com.example.hasantarek.menuwithradio_29;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    int item_selection=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void networkselect(View view)
    {
         registerForContextMenu(view);
        openContextMenu(view);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        MenuItem menuItem_wifi = menu.findItem(R.id.wifi);
        MenuItem menuItem_bloototh = menu.findItem(R.id.bloototh);
        MenuItem menuItem_mobile = menu.findItem(R.id.mobile);
        if(item_selection == 1)
        {
            menuItem_wifi.setChecked(true);
        }
        else
        if(item_selection == 2)
        {
            menuItem_bloototh.setChecked(true);
        }
        else
        if(item_selection == 3)
        {
            menuItem_mobile.setChecked(true);
        }


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.wifi:
                Toast.makeText(MainActivity.this,"Wifi selected",Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                item_selection = 1;
                return true;
            case R.id.bloototh:
                Toast.makeText(MainActivity.this,"blootoh selected",Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                item_selection = 2;
                return true;
            case R.id.mobile:
                Toast.makeText(MainActivity.this,"use mobile data",Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                item_selection = 3;
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
