package com.example.dzz007.swipeoptimizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SQLiteDatabaseHandler extends SQLiteAssetHelper {
    private static String DB_NAME = "data.sqlite";

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public SQLiteDatabaseHandler(Context context) {
        super(context, DB_NAME, null, 11);
        setForcedUpgrade();
    }

    ArrayList<Item> returnData(int location, int type, double maximum) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cur = db.query("data", new String [] {"Name", "Price"},
                "Location=?1 and Type=?2 and Price <= ?3", new String [] {String.valueOf(location), String.valueOf(type), String.valueOf(maximum)}, null,
                null, "Price desc");
        ArrayList<Item> result = new ArrayList<>();

        cur.moveToFirst();

        if(cur.getCount() == 0) {
            cur.close();
            return result;
        }

        do {
            result.add(new Item(Double.parseDouble(cur.getString(1)), cur.getString(0)));
        } while(cur.moveToNext());

        cur.close();
        db.close();
        return result;
    }
}
