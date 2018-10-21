package com.example.hasantarek.volley89;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    String server_url = "http://192.168.141.2/android_89.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageRequest imageRequest = new ImageRequest(server_url, new
                        Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {

                                imageView.setImageBitmap(response);
                            }
                        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this,"The image is not download",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                });

                Mysingleton.getmInstance(MainActivity.this).addTorequest(imageRequest);

            }
        });
    }
}
