package com.example.hasantarek.insertdata_32;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hasan Tarek on 7/13/2017.
 */
public class UserdbHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "USERINFO.DB";
    public static final  int Database_Version = 1;
    public static final String Create_Query=
            "CREATE TABLE " + Usercontract.Newusercontract.Table_Name
            + "(" + Usercontract.Newusercontract.User_Name + " TEXT,"
            + Usercontract.Newusercontract.User_Mob + " TEXT,"
            + Usercontract.Newusercontract.User_Email + " TEXT);";
        public UserdbHelper(Context context) {
        super(context,Database_Name,null,Database_Version);
            Log.e("DATABASE OPERATION","DATABASE created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Create_Query);
        Log.e("DATABASE OPERATION","DATABASE table created...");

    }

    public void addInformations(String name,String mob,String email,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Usercontract.Newusercontract.User_Name,name);
        contentValues.put(Usercontract.Newusercontract.User_Mob,mob);
        contentValues.put(Usercontract.Newusercontract.User_Email,email);
        db.insert(Usercontract.Newusercontract.Table_Name,null,contentValues);
        Log.e("DATABASE OPERATION","DATABASE row is created...");
    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String projection[]={Usercontract.Newusercontract.User_Name,
                Usercontract.Newusercontract.User_Mob
        ,Usercontract.Newusercontract.User_Email};

        cursor = db.query(Usercontract.Newusercontract.Table_Name,
                projection,null,null,null,null,null);

        return cursor;
    }

    public Cursor getContact(String user_name,SQLiteDatabase sqLiteDatabase)
    {
        Cursor cursor;
        String projection[]={Usercontract.Newusercontract.User_Mob,
        Usercontract.Newusercontract.User_Email};
        String selection = Usercontract.Newusercontract.User_Name + " LIKE ?";
        String selection_args[]={user_name};

        cursor = sqLiteDatabase.query(Usercontract.Newusercontract.Table_Name,
                projection,selection,selection_args,null,null,null);
        return  cursor;
    }

    public void deleteContact(String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String selection = Usercontract.Newusercontract.User_Name + " LIKE ?";
        String selection_args[] = {user_name};
        sqLiteDatabase.delete(Usercontract.Newusercontract.Table_Name,selection,selection_args);
    }

    public int updateInfromation(String old_name,String new_name,String new_mobile
    ,String new_email,SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Usercontract.Newusercontract.User_Name,new_name);
        contentValues.put(Usercontract.Newusercontract.User_Mob,new_mobile);
        contentValues.put(Usercontract.Newusercontract.User_Email,new_email);
        String selection = Usercontract.Newusercontract.User_Name + " LIKE ?";
        String selection_args[] = {old_name};
        int count = sqLiteDatabase.update(Usercontract.Newusercontract.Table_Name,
                contentValues,selection,selection_args);
        return count;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
