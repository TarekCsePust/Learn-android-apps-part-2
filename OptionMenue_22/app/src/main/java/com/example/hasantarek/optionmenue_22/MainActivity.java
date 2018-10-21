package com.example.hasantarek.optionmenue_22;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relative_layout);
        switch (item.getItemId())
        {
            case R.id.color_red:
                relativeLayout.setBackgroundColor
                        (getResources().getColor(android.R.color.holo_red_dark));
                break;

            case R.id.color_green:
                relativeLayout.setBackgroundColor(
                        getResources().getColor(android.R.color.holo_green_dark)
                );
                break;

        }
        return true;
    }
}
