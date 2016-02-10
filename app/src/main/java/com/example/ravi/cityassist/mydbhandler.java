package com.example.ravi.cityassist;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class mydbhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "Registration";
    private static final String TABLE_PRODUCTS = "Registrationtable";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME ="_username";
    private static final String COLUMN_NAME = "_name";
    private static final String COLUMN_AGE = "_age";
    private static final String COLUMN_PASSWORD = "_password";
    private static final String COLUMN_EMAIL = "_email";
    private Context getContext;
    public Tag tas;

    public mydbhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+ TABLE_PRODUCTS + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_USERNAME + " TEXT,"+
                COLUMN_NAME + " TEXT,"+
                COLUMN_AGE + " INTEGER,"+
                COLUMN_PASSWORD + " TEXT,"+
                COLUMN_EMAIL + " TEXT" +
                ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {;
        db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_NAME);
        onCreate(db);
    }

    public void dbadd(dbaccess register){
        ContentValues content = new ContentValues();

      //  content.put(COLUMN_ID,register.get_id());
        content.put(COLUMN_USERNAME,register.get_username());
        content.put(COLUMN_NAME,register.get_name());
        content.put(COLUMN_AGE,register.get_age());
        content.put(COLUMN_PASSWORD, register.get_password());
        content.put(COLUMN_EMAIL,register.get_email());

        try {
            long var = 0L;

            SQLiteDatabase db = this.getWritableDatabase();

            db.insert(TABLE_PRODUCTS, null, content);
            Toast.makeText(getContext,"hello 555",Toast.LENGTH_SHORT).show();
            db.close();
        }catch (Exception e){
            Log.e(String.valueOf(tas),"Problem is here");

            Toast.makeText(getContext,"hello ",Toast.LENGTH_SHORT).show();
        }

    }
//    public void check(){
//        SQLiteDatabase db = this.getWritableDatabase();
//    }

    public ArrayList<dbaccess> dbtostring(){

        ArrayList<dbaccess> dataList = new ArrayList<>();
        dbaccess register;

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                register = new dbaccess();
                register.set_id(cursor.getInt(0));
                register.set_username(cursor.getString(1));
                register.set_name(cursor.getString(2));
                register.set_age(cursor.getInt(3));
                register.set_password(cursor.getString(4));
                register.set_email(cursor.getString(5));
                dataList.add(register);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        if(dataList.size()<=0){
            dataList = null;
        }
        return dataList;
    }

}
