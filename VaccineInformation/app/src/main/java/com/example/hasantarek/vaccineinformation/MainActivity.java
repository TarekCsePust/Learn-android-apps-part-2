package com.example.hasantarek.vaccineinformation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    EditText Reg;
    Button login;
    String server_url = "http://192.168.141.2/vaccination/login_app.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reg = (EditText)findViewById(R.id.reg_no);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String reg_no = Reg.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String text = response.toString();
                        if(!text.equals("Birth registration is wrong."))
                        {


                            //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), Message.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error..",Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("reg",reg_no);
                        return params;
                    }
                };

                Mysingleton.getmInstance(getApplicationContext()).addTorequest(stringRequest);
            }
        });
    }
}
