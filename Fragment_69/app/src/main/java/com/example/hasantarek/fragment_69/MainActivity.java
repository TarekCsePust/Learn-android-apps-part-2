package com.example.hasantarek.fragment_69;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    boolean status = false;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(!status)
                {
                    FragmentOne f1 = new FragmentOne();
                    fragmentTransaction.add(R.id.frag_container,f1);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    button.setText("Load 2nd fragment");
                    status = true;


                }
                else
                {

                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.frag_container,f2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    button.setText("Load 1st fragment");
                    status = false;

                }
            }
        });
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
