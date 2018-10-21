package com.example.hasantarek.asyntask_65;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hasan Tarek on 7/22/2017.
 */
public class Mytask extends AsyncTask<Void,Integer,String> {

    Context context;
    Button button;
    TextView textView;
    ProgressDialog progressDialog;

    Mytask(Context context,Button button,TextView textView)
    {
        this.context = context;
        this.button = button;
        this.textView = textView;
    }
    @Override
    protected String doInBackground(Void... params) {

        int i =0;
        synchronized (this)
        {
            while (i<10)
            {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Download completed";
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Download progress");
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

    }

    @Override
    protected void onPostExecute(String result) {
       textView.setText(result);
        button.setEnabled(true);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... result) {

        int prog = result[0];
        progressDialog.setProgress(prog);
        textView.setText("Donwloading on progress");
    }
}
