package com.example.hasantarek.volley91;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/14/2017.
 */
public class Backgroundtask {

    private Context context;
    private ArrayList<Contact>arrayList = new ArrayList<>();
    String server_url = "http://192.168.141.2/androidpb91.php";

    public Backgroundtask( Context context) {
        this.context = context;
    }

    public ArrayList<Contact> getList()
    {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,
                server_url, (String) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;

                        while (count<response.length())
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Contact contact = new Contact(jsonObject.getString("Name"),
                                        jsonObject.getString("Email"));
                                arrayList.add(contact);
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context,"Error..",Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        Mysingleton.getmInstance(context).addTorequest(jsonArrayRequest);

        return arrayList;
    }
}
