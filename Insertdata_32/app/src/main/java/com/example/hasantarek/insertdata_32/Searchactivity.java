package com.example.hasantarek.insertdata_32;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Searchactivity extends ActionBarActivity {

    EditText SearchName;
    TextView DisplayMobile,DisplayEmail;
    UserdbHelper userdbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchactivity);
        SearchName = (EditText)findViewById(R.id.sname);
        DisplayMobile = (TextView)findViewById(R.id.smobile);
        DisplayEmail = (TextView)findViewById(R.id.semail);
        DisplayMobile.setVisibility(View.GONE);
        DisplayEmail.setVisibility(View.GONE);
    }

    public void search(View view)
    {
        String sname;
        sname = SearchName.getText().toString();
        userdbHelper = new UserdbHelper(getApplicationContext());
        sqLiteDatabase = userdbHelper.getReadableDatabase();
        Cursor cursor = userdbHelper.getContact(sname,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            DisplayMobile.setText(cursor.getString(0).toString());
            DisplayEmail.setText(cursor.getString(1).toString());
            DisplayMobile.setVisibility(View.VISIBLE);
            DisplayEmail.setVisibility(View.VISIBLE);
        }
        else
        {
            Toast.makeText(
                    getApplicationContext(),"No data found",Toast.LENGTH_SHORT
           ).show();
        }

    }

    public void delete(View view)
    {

        String sname;
        sname = SearchName.getText().toString();
        userdbHelper = new UserdbHelper(getApplicationContext());
        sqLiteDatabase = userdbHelper.getReadableDatabase();
        userdbHelper.deleteContact(sname,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),"COntact deleted",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_searchactivity, menu);
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
