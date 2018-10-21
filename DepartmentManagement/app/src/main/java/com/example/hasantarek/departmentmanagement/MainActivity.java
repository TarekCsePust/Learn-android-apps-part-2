package com.example.hasantarek.departmentmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button button;
    String server_url="http://192.168.141.2/androidb94/insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences
                        (getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
                 final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String>prams = new HashMap<String, String>();
                        prams.put("fcm_token",token);
                        return prams;
                    }
                };

                Mysingleton.getmInstance(MainActivity.this).addTorequest(stringRequest);
            }
        });
    }
}
