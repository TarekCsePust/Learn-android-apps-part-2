package com.example.hasantarek.asyntask102;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hasan Tarek on 8/18/2017.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int database_version=1;
    private static final String create_table = "create table"+DbContact.table_name+
            "(id integer primary key autoincrement,"+DbContact.name + " text);";


    private static final String drop_table = "drop table if exists " +DbContact.table_name;

    public DbHelper(Context context)
    {
        super(context,DbContact.Db_name,null,database_version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_table);
        Log.d("Db_Operation", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(drop_table);
        onCreate(db);

    }

    public void SaveToLocaldb(String name,SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContact.name,name);
        sqLiteDatabase.insert(DbContact.table_name, null, contentValues);
        Log.d("Db_Operation", "One row inserted");

    }


    public Cursor readInfromation(SQLiteDatabase sqLiteDatabase)
    {
        String projection[]={"id",DbContact.name};
        return (sqLiteDatabase.query(DbContact.table_name,projection,null,null,null,null,null));

    }
}
