package com.example.hasantarek.dailynotification;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hasan Tarek on 10/15/2017.
 */
public class shraepref {

    Context context;
    public shraepref(Context context) {

        this.context = context;
    }

    public void id(int id)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("id",id);
        editor.commit();
    }
}