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
        mFoods.add(food1);

        Food food2 = new Food("Peanuts",0,"RiceIcon",567.0);
        mFoods.add(food2);

        Food food3 = new Food("Beans",0,"RiceIcon",328.9);
        mFoods.add(food3);

        Food food4 = new Food("Peas",0,"RiceIcon",81.0);
        mFoods.add(food4);

        Food food5 = new Food("Corn",0,"RiceIcon",365.0);
        mFoods.add(food5);

        Food food6 = new Food("Soy",0,"RiceIcon",54.0);
        mFoods.add(food6);

        //Vegetables

        Food food7 = new Food("Cabbages",0,"RiceIcon",26.0);
        mFoods.add(food7);

        Food food8 = new Food("Tomatoes",0,"RiceIcon",17.8);
        mFoods.add(food8);

        Food food9 = new Food("Onions",0,"RiceIcon",40.0);
        mFoods.add(food9);

        Food food10 = new Food("Celery",0,"RiceIcon",15.0);
        mFoods.add(food10);

        Food food11 = new Food("Cucumber",0,"RiceIcon",15.3);
        mFoods.add(food11);

        Food food12 = new Food("Carrot",0,"RiceIcon",41.0);
        mFoods.add(food12);

        Food food13 = new Food("Eggplant",0,"RiceIcon",25.0);
        mFoods.add(food13);

        Food food14 = new Food("Peppers",0,"RiceIcon",20.1);
        mFoods.add(food14);

        Food food15 = new Food("Cauliflower",0,"RiceIcon",25.0);
        mFoods.add(food15);

        Food food16 = new Food("Broccoli",0,"RiceIcon",34.0);
        mFoods.add(food16);

        Food food17 = new Food("Garlic",0,"RiceIcon",149.0);
        mFoods.add(food17);

        Food food18 = new Food("Ginger",0,"RiceIcon",80.0);
        mFoods.add(food18);

        Food food19 = new Food("Spinach",0,"RiceIcon",23.0);
        mFoods.add(food19);


        //Fruits
        Food food20 = new Food("Mango",0,"RiceIcon",60.0);
        mFoods.add(food20);

        Food food21 = new Food("Lemon",0,"RiceIcon",29.3);
        mFoods.add(food21);

        Food food22 = new Food("Banana",0,"RiceIcon",88.9);
        mFoods.add(food22);

        Food food23 = new Food("Apple",0,"RiceIcon",52.1);
        mFoods.add(food23);

        Food food24 = new Food("Pineapple",0,"RiceIcon",49.9);
        mFoods.add(food24);

        Food food25 = new Food("Avocado",0,"RiceIcon",160.0);
        mFoods.add(food25);

        Food food26 = new Food("Grapes",0,"RiceIcon",67.0);
        mFoods.add(food26);

        Food food27 = new Food("Tangerines",0,"RiceIcon",53.0);
        mFoods.add(food27);

        Food food28 = new Food("Orange",0,"RiceIcon",47.0);
        mFoods.add(food28);


        //Meat& Eggs& Mushrooms

        Food food29 = new Food("Chicken",0,"RiceIcon",239.0);
        mFoods.add(food29);

        Food food30 = new Food("Beef",0,"RiceIcon",250.5);
        mFoods.add(food30);

        Food food31 = new Food("Pork",0,"RiceIcon",242.3);
        mFoods.add(food31);

        Food food32 = new Food("Eggs",0,"RiceIcon",155.0);
        mFoods.add(food32);

        Food food33 = new Food("Mushrooms",0,"RiceIcon",38.0);
        mFoods.add(food33);

        Food food34 = new Food("Bass fish",0,"RiceIcon",124.0);
        mFoods.add(food34);

        //Others
        Food food35 = new Food("Potatoes",0,"RiceIcon",76.5);
        mFoods.add(food35);

        Food food36 = new Food("Milk",0,"RiceIcon",55.2);
        mFoods.add(food36);

        Food food37 = new Food("Wheat",0,"RiceIcon",342.4);
        mFoods.add(food37);

        Food food38 = new Food("Sugar",0,"RiceIcon",406.3);
        mFoods.add(food38);

    }

    public List<Food> getFoods()
    {
        return mFoods;
    }

}