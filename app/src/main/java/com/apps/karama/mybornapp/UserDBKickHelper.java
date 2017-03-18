package com.apps.karama.mybornapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by rama on 6/10/2016.
 */
public class UserDBKickHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "KICKCOUNTER.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + UserKick.NewKickCounter.TABLE_KICKCOUNTE + "(" + UserKick.NewKickCounter.tanggal + "TEXT," + UserKick.NewKickCounter.count_kick + "TEXT," + UserKick.NewKickCounter.waktu_gerakan + "TEXT);";

    public UserDBKickHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "Database created/opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created...");
    }

    public void addInformations(Kick kick) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.rawQuery("inset into "+ UserKick.NewKickCounter.TABLE_KICKCOUNTE +" Values ('"+ kick.getDate() +"','"+ kick.getCount() +"','"+ kick.getWaktu_gerakan()+"')", null);
    }

    public ArrayList<Kick> getInformations() {
        ArrayList<Kick> kicks = new ArrayList<Kick>();

        Cursor cursor;
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery("select * from " + UserKick.NewKickCounter.TABLE_KICKCOUNTE, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Kick kick = new Kick();
            kick.setDate(cursor.getString(1));
            kick.setCount(cursor.getString(2));
            kick.setWaktu_gerakan(cursor.getString(3));

            kicks.add(kick);
        }

        return kicks;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
