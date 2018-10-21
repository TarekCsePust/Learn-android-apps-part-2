package com.example.hasantarek.pickimagegalary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    ImageView imageView;
    static final int selected_pic = 1;
    SharedPreferences sharedPreferences;
    Bitmap bitmap;
    String filepath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        imageView = (ImageView)findViewById(R.id.imageView);
        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.hasantarek.pickimagegalary",MODE_PRIVATE);
        String savedPicturePath = sharedPreferences.getString("imagepath","null");
        Toast.makeText(getApplicationContext(),savedPicturePath,Toast.LENGTH_LONG).show();
        if(!savedPicturePath.equals("null")){
            bitmap = BitmapFactory.decodeFile(savedPicturePath);
            Drawable d = new BitmapDrawable(bitmap);
            imageView.setBackground(d);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,selected_pic);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case selected_pic:
                if(resultCode == RESULT_OK)
                {
                    Uri uri = data.getData();
                    String[]projection = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                    cursor.moveToFirst();
                    int colummnindex = cursor.getColumnIndex(projection[0]);
                     filepath = cursor.getString(colummnindex);
                    Toast.makeText(MainActivity.this,filepath,Toast.LENGTH_LONG).show();
                    sharedPreferences.edit().putString("imagepath",filepath);
                    cursor.close();
                     bitmap = BitmapFactory.decodeFile(filepath);
                    Drawable drawable = new BitmapDrawable(bitmap);
                    imageView.setBackground(drawable);
                }
                break;
            default:
                break;
        }
    }

    public void submit(View view)
    {
        Intent intent = new Intent(getApplicationContext(),ImageviewActivity.class);
        intent.putExtra("path",filepath);
        startActivity(intent);
    }
}
