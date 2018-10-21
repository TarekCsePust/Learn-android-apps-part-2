package com.example.hasantarek.volley90;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView name,email,reg;
    String server_url = "http://192.168.141.2/androidpb90.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView)findViewById(R.id.textView);
        email = (TextView)findViewById(R.id.textView2);
        reg = (TextView)findViewById(R.id.textView3);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, server_url,
                        (String) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            name.setText(response.getString("Name"));
                            email.setText(response.getString("Email"));
                            reg.setText(response.getString("Reg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this,"Something error",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });

                Mysingleton.getmInstance(MainActivity.this).addTorequest(jsonObjectRequest);
            }
        });
    }
}
