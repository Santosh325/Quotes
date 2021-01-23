package com.example.infodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.infodatabase.InfoContract.InfoListEntry.TABLE_NAME;

public class InfoDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "info";
    public static final int VERSION = 1;
    Context context;
    public InfoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String INFO_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                InfoContract.InfoListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                InfoContract.InfoListEntry.NAME + " TEXT NOT NULL, " +
                InfoContract.InfoListEntry.ADDRESS + " TEXT NOT NULL, " +
                InfoContract.InfoListEntry.PHONE + " TEXT NOT NULL);";
        db.execSQL(INFO_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
     onCreate(db);
    }

   public void addInfo(Information information){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(InfoContract.InfoListEntry.NAME,information.getName());
        cv.put(InfoContract.InfoListEntry.ADDRESS,information.getAddress());
        cv.put(InfoContract.InfoListEntry.PHONE,information.getPhone());
        db.insert(TABLE_NAME,null,cv);
   }


}
