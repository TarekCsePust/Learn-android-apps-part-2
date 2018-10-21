package com.example.hasantarek.volley_88;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String server_url = "http://192.168.141.2/androidpb86.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                                server_url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                textView.setText(response);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                textView.setText("Error...");
                                error.printStackTrace();
                            }
                        });

                        Mysingleton.getInstance(getApplicationContext()).addrequestqueue(stringRequest);

                    }
                }
        );


    }
}
