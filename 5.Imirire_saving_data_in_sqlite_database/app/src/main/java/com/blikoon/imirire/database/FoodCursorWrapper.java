package com.blikoon.imirire.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.blikoon.imirire.Food;

import java.util.UUID;

/**
 * Created by gakwaya on 2/24/2016.
 */
public class FoodCursorWrapper extends CursorWrapper {

    public FoodCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Food getFood()
    {
        String uuidString = getString(getColumnIndex(FoodDbSchema.FoodTable.Cols.UUID));
        String foodName = getString(getColumnIndex(FoodDbSchema.FoodTable.Cols.NAME));

        double gramCount = getDouble(getColumnIndex(FoodDbSchema.FoodTable.Cols.GRAM_COUNT));
        double calCount = getDouble(getColumnIndex(FoodDbSchema.FoodTable.Cols.CAL_COUNT));
        int isChecked = getInt(getColumnIndex(FoodDbSchema.FoodTable.Cols.IS_CHECKED));

        Food food = new Food(foodName,gramCount,"",calCount,UUID.fromString(uuidString));
        food.setIsChecked(isChecked != 0);

        return  food;

    }

}
