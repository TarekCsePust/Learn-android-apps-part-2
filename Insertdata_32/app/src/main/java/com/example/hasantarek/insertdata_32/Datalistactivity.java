package com.example.hasantarek.insertdata_32;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class Datalistactivity extends ActionBarActivity {

    ListView listView;
    UserdbHelper userdbHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    Listdataadapter listdataadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datalistactivity);
        listView = (ListView)findViewById(R.id.list_item);
        listdataadapter = new Listdataadapter(getBaseContext(),R.layout.row_layout);
        listView.setAdapter(listdataadapter);
        userdbHelper = new UserdbHelper(getBaseContext());
        sqLiteDatabase = userdbHelper.getReadableDatabase();
        cursor = userdbHelper.getInformation(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String n,m,e;
                n = cursor.getString(0);
                m = cursor.getString(1);
                e = cursor.getString(2);
                Dataprovider dataprovider = new Dataprovider(n,m,e);
                listdataadapter.add(dataprovider);
            }while (cursor.moveToNext());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datalistactivity, menu);
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
