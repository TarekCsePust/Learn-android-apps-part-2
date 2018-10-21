package com.example.hasantarek.insertdata_32;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Updateactivity extends ActionBarActivity {

    EditText Update_name,Update_email,Update_mobile,Search_name;
    TextView Update_text;
    UserdbHelper userdbHelper;
    SQLiteDatabase sqLiteDatabase;
    Button Update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateactivity);
        Update_name = (EditText)findViewById(R.id.uname);
        Update_mobile = (EditText)findViewById(R.id.umobile);
        Update_email = (EditText)findViewById(R.id.uemail);
        Update_text = (TextView)findViewById(R.id.utext);
        Search_name = (EditText)findViewById(R.id.sname);
        Update_btn = (Button)findViewById(R.id.bupdate);
        Update_btn.setVisibility(View.GONE);
        Update_text.setVisibility(View.GONE);
        Update_name.setVisibility(View.GONE);
        Update_mobile.setVisibility(View.GONE);
        Update_email.setVisibility(View.GONE);

    }


    public void search(View view)
    {
        String sname;
        sname = Search_name.getText().toString();
        userdbHelper = new UserdbHelper(getApplicationContext());
        sqLiteDatabase = userdbHelper.getReadableDatabase();
        Cursor cursor = userdbHelper.getContact(sname,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            Update_mobile.setText(cursor.getString(0).toString());
            Update_email.setText(cursor.getString(1).toString());
            Update_name.setText(sname);
            Update_name.setVisibility(View.VISIBLE);
            Update_mobile.setVisibility(View.VISIBLE);
            Update_email.setVisibility(View.VISIBLE);
            Update_text.setVisibility(View.VISIBLE);
            Update_btn.setVisibility(View.VISIBLE);
        }
    }


    public void update(View view)
    {
        String name,mobile,email,Oldname;
        Oldname = Search_name.getText().toString();
        name = Update_name.getText().toString();
        mobile = Update_mobile.getText().toString();
        email = Update_email.getText().toString();
        userdbHelper = new UserdbHelper(getApplicationContext());
        sqLiteDatabase = userdbHelper.getWritableDatabase();
        int Count = userdbHelper.updateInfromation(Oldname,name,mobile,email,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),Count + " row updated",Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_updateactivity, menu);
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
