package com.example.hasantarek.asyntask_67;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends ActionBarActivity {

    String img_address = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSz9NXlgQ3Kr2Ykts0tYzICHEJ-t4PJqPwOk9sHcfBy9ACcAKKr";
    Button button;
    ProgressDialog progressDialog;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.btn);
        imageView = (ImageView)findViewById(R.id.image_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Download().execute(img_address);
            }
        });
    }

    class Download extends AsyncTask<String,Integer,String>
    {

        @Override
        protected void onPreExecute() {
           progressDialog = new ProgressDialog(MainActivity.this);
           progressDialog.setMax(100);
           progressDialog.setTitle("Download image");
           progressDialog.setProgress(0);
           progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
           progressDialog.show();
        }



        @Override
        protected String doInBackground(String... params) {
            String path = params[0];
            int file_length = 0;

            try {
                URL url = new URL(path);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                file_length = urlConnection.getContentLength();
                File file = new File("sdcard/photoalbum");
                if(!file.exists())
                {
                    file.mkdir();
                }
                File input_file = new File(file,"image.jpg");
                InputStream inputStream = new BufferedInputStream(url.openStream(),8192);
                byte[]data = new byte[1024];
                int total = 0;
                int count = 0;
                OutputStream outputStream = new FileOutputStream(input_file);
                while ((count=inputStream.read(data))!=-1)
                {
                    total+=count;
                    outputStream.write(data,0,count);
                    int lenght = (int)total*100/file_length;
                    publishProgress(lenght);
                }

                inputStream.close();
                outputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Download complete";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.hide();
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
            String path = "sdcard/photoalbum/image.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));
        }
    }
}
