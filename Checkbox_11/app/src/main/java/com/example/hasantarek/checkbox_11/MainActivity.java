package com.example.hasantarek.checkbox_11;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<String> items = new ArrayList<String>();
    TextView fruitSelecttext;
    TextView selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitSelecttext = (TextView)findViewById(R.id.fruit_items);
        selected = (TextView)findViewById(R.id.fruits);
        fruitSelecttext.setEnabled(false);
    }


    public void select(View view)
    {
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId())
        {
            case R.id.apple:
                if(checked)
                {
                    items.add(((CheckBox) view).getText().toString());
                }
                else
                {
                    items.remove(((CheckBox) view).getText().toString());
                }
                break;
            case R.id.orange:
                if(checked)
                {
                    items.add(((CheckBox) view).getText().toString());
                }
                else
                {
                    items.remove(((CheckBox) view).getText().toString());
                }
                break;
            case R.id.mango:
                if(checked)
                {
                    items.add(((CheckBox) view).getText().toString());
                }
                else
                {
                    items.remove(((CheckBox) view).getText().toString());
                }
                break;
            default:
                break;

        }
    }

    public void finalselection(View view)
    {
        StringBuffer finalselect = new StringBuffer();
        for(String item:items)
        {
            finalselect.append(item);
            finalselect.append(" ");
        }

       
       fruitSelecttext.setEnabled(true);
        selected.setText(finalselect);
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
