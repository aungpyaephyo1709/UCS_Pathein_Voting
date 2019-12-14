package com.app.aungpyaephyo.ucs_patheinvoting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class myDbAdapter {


    private DatabaseHandler myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new DatabaseHandler(context);
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myhelper.UID,myhelper.NAME};
        Cursor cursor =db.query(myhelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myhelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myhelper.NAME));
            buffer.append(cid+ "   " + name  +" \n");
        }
        return buffer.toString();
    }

    public String getData(String qr){
        SQLiteDatabase db=myhelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+myhelper.TABLE_NAME+" where Name=\""+qr+"\"",null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
         //   int cid =cursor.getInt(cursor.getColumnIndex(myhelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myhelper.NAME));
            buffer.append( name );
        }
        return buffer.toString();
    }
    public long insertData(String name)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myhelper.NAME, name);
        long id = dbb.insert(myhelper.TABLE_NAME, null , contentValues);
        return id;
    }
    }


