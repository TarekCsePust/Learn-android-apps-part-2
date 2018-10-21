package com.example.hasantarek.asyntask102;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String server_url = "http://192.168.141.2/androidpb102.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void download(View v)
    {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        DbHelper dbHelper = new DbHelper(MainActivity.this);
                        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            int count=0;
                            String name;
                            while (count<jsonArray.length())
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(count);
                                name = jsonObject.getString("Name");
                                dbHelper.SaveToLocaldb(name,sqLiteDatabase);
                                count++;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        dbHelper.close();
                        Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Mysingleton.getmInstance(MainActivity.this).addTorequest(stringRequest);
    }

    public void display(View v)
    {
        startActivity(new Intent(this,DisplayContact.class));
    }
}
