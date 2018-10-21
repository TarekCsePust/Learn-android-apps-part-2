package com.example.hasantarek.asyntask102;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/18/2017.
 */
public class BackgroundTask extends AsyncTask<Void,Contact,Void> {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    RecyclerAdapter adapter;
    Context context;
    ArrayList<Contact>arrayList = new ArrayList<>();

    public BackgroundTask(RecyclerView recyclerView, ProgressBar progressBar,Context context) {
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(Void... params) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.readInfromation(sqLiteDatabase);
        String name;
        int id;
        while (cursor.moveToNext())
        {
            id = cursor.getInt(cursor.getColumnIndex("id"));
            name = cursor.getString(cursor.getColumnIndex("name"));
            publishProgress(new Contact(id,name));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cursor.close();
        dbHelper.close();
        return null;
    }

    @Override
    protected void onProgressUpdate(Contact... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressBar.setVisibility(View.GONE);
    }
}
