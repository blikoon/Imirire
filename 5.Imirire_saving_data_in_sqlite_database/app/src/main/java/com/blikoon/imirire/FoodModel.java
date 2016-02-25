package com.blikoon.imirire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.blikoon.imirire.database.FoodCursorWrapper;
import com.blikoon.imirire.database.FoodDbSchema;
import com.blikoon.imirire.database.FoodOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gakwaya on 2/10/2016.
 */

//This class is a singleton and supposed to only have
//one instance across the whole application.
public class FoodModel
{
    private static FoodModel sFoodModel;
//    private List<Food> mFoods;
    private SQLiteDatabase mDatabase;
    private Context mContext;

    public static FoodModel get(Context context)
    {
        if(sFoodModel == null)
        {
            sFoodModel = new FoodModel(context);
        }
        return  sFoodModel;
    }

    private FoodModel(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new FoodOpenHelper(mContext).getWritableDatabase();
        populateWithInitialFoods();
    }

    public void addFood(Food f)
    {
        ContentValues values = getContentValues(f);
        mDatabase.insert(FoodDbSchema.FoodTable.NAME, null, values);
    }
    public void updateFood(Food f)
    {
        String uuidString = f.getFoodId().toString();
        ContentValues values = getContentValues(f);
        mDatabase.update(FoodDbSchema.FoodTable.NAME, values,
                FoodDbSchema.FoodTable.Cols.UUID + " = ?",
                new String[]{uuidString});


    }

    private void populateWithInitialFoods()
    {
        //Cereals
        Food food1 = new Food("Rice",0,"RiceIcon",351.0);
        addFood(food1);

        Food food2 = new Food("Peanuts",0,"RiceIcon",567.0);
        addFood(food2);

        Food food3 = new Food("Beans",0,"RiceIcon",328.9);
        addFood(food3);

        Food food4 = new Food("Peas",0,"RiceIcon",81.0);
        addFood(food4);

        Food food5 = new Food("Corn",0,"RiceIcon",365.0);
        addFood(food5);

        Food food6 = new Food("Soy",0,"RiceIcon",54.0);
        addFood(food6);

        //Vegetables

        Food food7 = new Food("Cabbages",0,"RiceIcon",26.0);
        addFood(food7);

        Food food8 = new Food("Tomatoes",0,"RiceIcon",17.8);
        addFood(food8);

        Food food9 = new Food("Onions",0,"RiceIcon",40.0);
        addFood(food9);

        Food food10 = new Food("Celery",0,"RiceIcon",15.0);
        addFood(food10);

        Food food11 = new Food("Cucumber",0,"RiceIcon",15.3);
        addFood(food11);

        Food food12 = new Food("Carrot",0,"RiceIcon",41.0);
        addFood(food12);

        Food food13 = new Food("Eggplant",0,"RiceIcon",25.0);
        addFood(food13);

        Food food14 = new Food("Peppers",0,"RiceIcon",20.1);
        addFood(food14);

        Food food15 = new Food("Cauliflower",0,"RiceIcon",25.0);
        addFood(food15);

        Food food16 = new Food("Broccoli",0,"RiceIcon",34.0);
        addFood(food16);

        Food food17 = new Food("Garlic",0,"RiceIcon",149.0);
        addFood(food17);

        Food food18 = new Food("Ginger",0,"RiceIcon",80.0);
        addFood(food18);

        Food food19 = new Food("Spinach",0,"RiceIcon",23.0);
        addFood(food19);


        //Fruits
        Food food20 = new Food("Mango",0,"RiceIcon",60.0);
        addFood(food20);

        Food food21 = new Food("Lemon",0,"RiceIcon",29.3);
        addFood(food21);

        Food food22 = new Food("Banana",0,"RiceIcon",88.9);
        addFood(food22);

        Food food23 = new Food("Apple",0,"RiceIcon",52.1);
        addFood(food23);

        Food food24 = new Food("Pineapple",0,"RiceIcon",49.9);
        addFood(food24);

        Food food25 = new Food("Avocado",0,"RiceIcon",160.0);
        addFood(food25);

        Food food26 = new Food("Grapes",0,"RiceIcon",67.0);
        addFood(food26);

        Food food27 = new Food("Tangerines",0,"RiceIcon",53.0);
        addFood(food27);

        Food food28 = new Food("Orange",0,"RiceIcon",47.0);
        addFood(food28);


        //Meat& Eggs& Mushrooms

        Food food29 = new Food("Chicken",0,"RiceIcon",239.0);
        addFood(food29);

        Food food30 = new Food("Beef",0,"RiceIcon",250.5);
        addFood(food30);

        Food food31 = new Food("Pork",0,"RiceIcon",242.3);
        addFood(food31);

        Food food32 = new Food("Eggs",0,"RiceIcon",155.0);
        addFood(food32);

        Food food33 = new Food("Mushrooms",0,"RiceIcon",38.0);
        addFood(food33);

        Food food34 = new Food("Bass fish",0,"RiceIcon",124.0);
        addFood(food34);

        //Others
        Food food35 = new Food("Potatoes",0,"RiceIcon",76.5);
        addFood(food35);

        Food food36 = new Food("Milk",0,"RiceIcon",55.2);
        addFood(food36);

        Food food37 = new Food("Wheat",0,"RiceIcon",342.4);
        addFood(food37);

        Food food38 = new Food("Sugar",0,"RiceIcon",406.3);
        addFood(food38);

    }

    public List<Food> getFoods()
    {
        List <Food> foods = new ArrayList<>();

        FoodCursorWrapper cursor = queryFoods(null,null);
        try
        {
            cursor.moveToFirst();
            while( !cursor.isAfterLast())
            {
                foods.add(cursor.getFood());
                cursor.moveToNext();
            }

        }finally {
            cursor.close();
        }
        return foods;
    }

    private static ContentValues getContentValues(Food food)
    {
        ContentValues values = new ContentValues();
        values.put(FoodDbSchema.FoodTable.Cols.UUID,food.getFoodId().toString());
        values.put(FoodDbSchema.FoodTable.Cols.NAME,food.getFoodName());
        values.put(FoodDbSchema.FoodTable.Cols.GRAM_COUNT, food.getGramCount());
        values.put(FoodDbSchema.FoodTable.Cols.CAL_COUNT,food.getCalCount());
        values.put(FoodDbSchema.FoodTable.Cols.IS_CHECKED,food.isChecked());

        return values;
    }

    private FoodCursorWrapper queryFoods(String whereClause ,String [] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                FoodDbSchema.FoodTable.NAME,
                null ,//Columns - null selects all columns
                whereClause,
                whereArgs,
                null ,//groupBy
                null, //having
                null//orderBy
        );
        return new FoodCursorWrapper(cursor);
    }




}