package com.blikoon.imirire;

import android.content.Context;

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
    private List<Food> mFoods;

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
        mFoods = new ArrayList<>();
        populateWithInitialFoods();
    }

    private void populateWithInitialFoods()
    {
        //Cereals
        Food food1 = new Food("Rice",0,"RiceIcon",351.0);

        for(int i = 0 ; i < 50 ;i++) {
            mFoods.add(food1);
        }

    }

    public List<Food> getFoods()
    {
        return mFoods;
    }

}