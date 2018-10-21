package com.example.hasantarek.insertdata_32;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Addcontactactivity extends ActionBarActivity {

    EditText contactName,contactMobile,contactEmail;
    Context context = this;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontactactivity);
        contactName = (EditText)findViewById(R.id.name);
        contactMobile = (EditText)findViewById(R.id.number);
        contactEmail = (EditText)findViewById(R.id.email);
    }

    public void savecontact(View view)
    {

        String name = contactName.getText().toString();
        String mobile = contactMobile.getText().toString();
        String email = contactEmail.getText().toString();
        UserdbHelper userdbHelper = new UserdbHelper(context);
        sqLiteDatabase = userdbHelper.getWritableDatabase();
        userdbHelper.addInformations(name,mobile,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_SHORT).show();
        userdbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addcontactactivity, menu);
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
