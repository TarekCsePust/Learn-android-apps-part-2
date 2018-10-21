package com.example.hasantarek.savefileinternal_46;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Externalactivity extends ActionBarActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externalactivity);
        editText = (EditText)findViewById(R.id.msg);
        textView = (TextView)findViewById(R.id.red_msg);
        textView.setVisibility(View.GONE);
    }


    public void write(View view)
    {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath() + "/Myappfile");
            if(!dir.exists())
            {
                dir.mkdir();
            }

            File file = new File(dir,"msg.txt");
            String msg = editText.getText().toString();
            try {
                FileOutputStream filoutputStream = new FileOutputStream(file);
                filoutputStream.write(msg.getBytes());
                filoutputStream.close();
                editText.setText("");
                Toast.makeText(getBaseContext(),"Message saved",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            Toast.makeText(getBaseContext(),"Not found sd card",Toast.LENGTH_SHORT).show();
        }



    }


    public void read(View view)
    {
        File root = Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/Myappfile");
        File file = new File(dir,"msg.txt");
        String msg;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_externalactivity, menu);
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
