package com.blikoon.imirire.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gakwaya on 2/24/2016.
 */
public class FoodOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME= "foodDb.db";

    public FoodOpenHelper(Context context)
    {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate( SQLiteDatabase db)
    {
        db.execSQL("create table " + FoodDbSchema.FoodTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                FoodDbSchema.FoodTable.Cols.UUID + "," +
                FoodDbSchema.FoodTable.Cols.NAME + "," +
                FoodDbSchema.FoodTable.Cols.GRAM_COUNT + "," +
                FoodDbSchema.FoodTable.Cols.CAL_COUNT + ","+
                FoodDbSchema.FoodTable.Cols.IS_CHECKED+ ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,
                          int newVersion)
    {

    }
}
