package com.example.hasantarek.pickimagegalary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageviewActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        imageView = (ImageView)findViewById(R.id.imageView2);
        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
        bitmap = BitmapFactory.decodeFile(path);
        Drawable drawable = new BitmapDrawable(getResources(),bitmap);
        imageView.setBackground(drawable);
    }
}
