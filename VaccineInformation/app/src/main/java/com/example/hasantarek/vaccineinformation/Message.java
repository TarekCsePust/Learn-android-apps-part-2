package com.example.hasantarek.vaccineinformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Message extends AppCompatActivity {

    ListView listView;
    String server_url = "http://192.168.141.2/vaccination/get_msg_app.php";
    MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        listView = (ListView)findViewById(R.id.list);
        messageAdapter = new MessageAdapter(getApplicationContext(),R.layout.custom_message_layout);
        listView.setAdapter(messageAdapter);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("message");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                messageAdapter.add(new MessagedataProvider(
                                        jsonObject1.getString("Text"),
                                        jsonObject1.getString("Date")

                                ));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
        Mysingleton.getmInstance(getApplicationContext()).addTorequest(stringRequest);


    }
}
