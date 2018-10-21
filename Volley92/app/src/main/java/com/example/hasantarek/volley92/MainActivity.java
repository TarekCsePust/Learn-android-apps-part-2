package com.example.hasantarek.volley92;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText name,email;
    Button button;
    String server_url = "http://192.168.141.2/androidpb92.php";
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editText);
        email = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);
        builder = new AlertDialog.Builder(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        builder.setTitle("Server message");
                        builder.setMessage("Responce: " + response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                name.setText("");
                                email.setText("");
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this,"Error..",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map <String,String> prams = new HashMap<String, String>();
                        prams.put("name",name.getText().toString());
                        prams.put("email",email.getText().toString());
                        return prams;
                    }
                };

                Mysingleton.getmInstance(MainActivity.this).addTorequest(stringRequest);
            }
        });

    }
}
