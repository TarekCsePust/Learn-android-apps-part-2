package com.example.hasantarek.camera_68;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;


public class MainActivity extends Activity {

    Button button;
    ImageView imageView;
    static final int cam_req=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,cam_req);
            }
        });

    }


   private File getFile()
   {
       File folder = new File("sdcard/camera_app");
       if(!folder.exists())
       {
           folder.mkdir();
       }

       File img_file = new File(folder,"cam_img.jpg");
       return img_file;
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/camera_app/cam_img.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}
