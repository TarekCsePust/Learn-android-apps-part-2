package com.example.hasantarek.video_69;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends Activity {

    Button button;
    static final int video_req=100;
    boolean status = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getFile()));
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                startActivityForResult(intent,video_req);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == video_req)
        {
            if(resultCode == RESULT_OK)
            {
                Toast.makeText(MainActivity.this,"Video sucessfully recorded",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"Video sucessfully not recorded",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private File getFile()
    {
        File file = new File("sdcard/video_app");
        if(!file.exists())
        {
            file.mkdir();
        }

        File input_file = new File(file,"video.mp4");
        return input_file;
    }

}
