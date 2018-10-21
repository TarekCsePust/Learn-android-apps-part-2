package com.example.hasantarek.sharedprefrence_30;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    EditText Message;
    SeekBar seekBar;
    float font_size;
    String font_color;
    String text_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Message = (EditText)findViewById(R.id.message);
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(
                getString(R.string.pref_file),MODE_PRIVATE
        );

        text_info = sharedPreferences.getString(getString(R.string.text_info),"");
        font_color = sharedPreferences.getString(getString(R.string.font_color),"");
        font_size = sharedPreferences.getFloat(getString(R.string.font_size),25);
        Message.setText(text_info);
        Message.setTextSize(TypedValue.COMPLEX_UNIT_PX,font_size);
        if(font_size == 25)
        {
            seekBar.setProgress(0);
        }
        else
        {
            seekBar.setProgress((int)font_size);
        }

        if(font_color.equals("Red"))
        {
            Message.setTextColor(Color.parseColor("#fc0116"));
        }
        else
        if(font_color.equals("Blue"))
        {
            Message.setTextColor(Color.parseColor("#0810f5"));
        }
        else
        if(font_color.equals("Green"))
        {
            Message.setTextColor(Color.parseColor("#03ff20"));
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Message.setTextSize(TypedValue.COMPLEX_UNIT_PX,progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                font_size = Message.getTextSize();
            }
        });
    }

    public void changecolor(View view)
    {
        switch (view.getId())
        {
            case R.id.red:
                Message.setTextColor(Color.parseColor("#fc0116"));
                font_color = "Red";
                break;
            case R.id.blue:
                Message.setTextColor(Color.parseColor("#0810f5"));
                font_color = "Blue";
                break;
            case R.id.green:
                Message.setTextColor(Color.parseColor("#03ff20"));
                font_color = "Green";
                break;
        }

    }

    public void save(View view)
    {
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(
                getString(R.string.pref_file),MODE_PRIVATE
        );

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(getString(R.string.font_size),font_size);
        editor.putString(getString(R.string.font_color),font_color);
        editor.putString(getString(R.string.text_info),Message.getText().toString());
        editor.commit();
    }

    public void clear(View view)
    {
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(
                getString(R.string.pref_file),MODE_PRIVATE
        );

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

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
