package com.esgi.euterpe.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Marine on 01/05/14.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;	//To increment if database schema change
    public static final String DATABASE_NAME = "Euterpe.db";

    private static final String SQL_CREATE_SCORES =
            "CREATE TABLE "+ DatabaseContract.GameBase.TABLE_NAME +" (" +
                    DatabaseContract.GameBase.COLUMN_NAME_ID +" INTEGER PRIMARY KEY,"+
                    DatabaseContract.GameBase.COLUMN_NAME_MUSIC +" TEXT,"+

                    " )";
    private static final String SQL_DELETE_SCORES =
            "DROP TABLE IF EXISTS " + DatabaseContract.GameBase.TABLE_NAME;


    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
