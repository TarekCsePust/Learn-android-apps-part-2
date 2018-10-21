package com.example.hasantarek.togglebtn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    private TextView text;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.msg);
        text.setVisibility(View.INVISIBLE);
        aSwitch = (Switch)findViewById(R.id.swt);
        aSwitch.setText("wifi off");
        aSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked)
                        {
                            text.setText("wifi on");
                            text.setVisibility(View.VISIBLE);
                            aSwitch.setText("wifi on");
                        }
                        else
                        {
                            text.setText("wifi off");
                            aSwitch.setText("wifi off");
                        }
                    }
                }

        );
    }

    public void change(View view)
    {
         boolean checked = ((ToggleButton)view).isChecked();
        if(checked)
        {
            text.setText("vibrate on");
            text.setVisibility(View.VISIBLE);
        }
        else
        {
            text.setText("vibrate off");

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
