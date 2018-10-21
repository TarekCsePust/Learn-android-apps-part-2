package com.example.hasantarek.savefileinternal_46;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.msg);
        textView = (TextView)findViewById(R.id.red_msg);
        textView.setVisibility(View.GONE);
    }

    public void write(View view)
    {
        String msg = editText.getText().toString();
        String file_name = "hello_file";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name,MODE_PRIVATE);
            fileOutputStream.write(msg.getBytes());
            fileOutputStream.close();
            Toast.makeText(getBaseContext(),"Message Save",Toast.LENGTH_SHORT).show();
            editText.setText("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(View view)
    {
        String msg;
        try {
            FileInputStream fileInputStream = openFileInput("hello_file");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((msg=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(msg + "\n");
            }

            textView.setText(stringBuffer.toString());
            textView.setVisibility(View.VISIBLE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void external(View view)
    {
        Intent intent = new Intent(getBaseContext(),Externalactivity.class);
        startActivity(intent);

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
