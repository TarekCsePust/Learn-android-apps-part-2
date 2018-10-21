package com.example.hasantarek.radio_12;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dept = (TextView)findViewById(R.id.selected);
        dept.setEnabled(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void select(View view)
    {
         boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.cse:
                if(checked)
                {
                    dept.setText(((RadioButton) view).getText());
                    dept.setEnabled(true);
                }
                else
                {
                    dept.setEnabled(false);
                }
                break;
            case R.id.eee:
                if(checked)
                {
                    dept.setText(((RadioButton) view).getText());
                    dept.setEnabled(true);
                }
                else
                {
                    dept.setEnabled(false);
                }
                break;
            default:
                break;

        }
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
