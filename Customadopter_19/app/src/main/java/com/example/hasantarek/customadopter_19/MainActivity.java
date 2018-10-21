package com.example.hasantarek.customadopter_19;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends ActionBarActivity {


    ListView mlistview;
    int[] movieImages={R.drawable.business,
            R.drawable.dangal,
            R.drawable.kabil,
            R.drawable.raees,
            R.drawable.sultan,
            R.drawable.tublight
    };
    String[] movieNames={
            "Business Man","Dangal","Kabil",
            "Raees","Sultan","Tublight"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistview = (ListView)findViewById(R.id.list_view);
        Myadapter myadapter = new Myadapter(MainActivity.this,movieNames,movieImages);
        mlistview.setAdapter(myadapter);
        mlistview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(
                                MainActivity.this,movieNames[position],Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
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
