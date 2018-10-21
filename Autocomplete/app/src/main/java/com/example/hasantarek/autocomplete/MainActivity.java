package com.example.hasantarek.autocomplete;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class MainActivity extends ActionBarActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private String countrys[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        countrys = getResources().getStringArray(R.array.country_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countrys);
        autoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.multi);
        //ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,countrys);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextView.setThreshold(1);

        autoCompleteTextView.setAdapter(adapter);
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
