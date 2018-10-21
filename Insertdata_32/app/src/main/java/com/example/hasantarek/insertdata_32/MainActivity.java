package com.example.hasantarek.insertdata_32;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void action(View view)
    {
        if(view.getId()==R.id.add)
        {
            Intent intent = new Intent(getBaseContext(),Addcontactactivity.class);
            startActivity(intent);
        }
        else
        if(view.getId() == R.id.viewc)
        {
            Intent intent = new Intent(getBaseContext(),Datalistactivity.class);
            startActivity(intent);
        }
        else
            if(view.getId() == R.id.update)
            {

                Intent intent = new Intent(getBaseContext(),Updateactivity.class);
                startActivity(intent);
            }
        else
            if(view.getId()==R.id.delete)
            {

                Intent intent = new Intent(getBaseContext(),Searchactivity.class);
                startActivity(intent);
            }
        else
            if(view.getId() == R.id.search)
        {
            Intent intent = new Intent(getBaseContext(),Searchactivity.class);
            startActivity(intent);
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
