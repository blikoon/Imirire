package com.blikoon.imirire;

import java.util.UUID;

/**
 * Created by gakwaya on 2/10/2016.
 */

public class Food {
    private String mFoodName;
    private double mGramCount;
    private double mCalCount;
    private boolean isChecked;
    private UUID mFoodId;

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public double getCalCount() {
        return mCalCount;
    }

    public void setCalCount(double calCount) {
        this.mCalCount = calCount;
    }

    public double getGramCount() {
        return mGramCount;
    }

    public void setGramCount(double gramCount) {
        mGramCount = gramCount;
    }



    public Food(String foodName ,double gramCount,String foodIcon,double calCount)
    {
        mFoodName = foodName;
        mGramCount = gramCount;
        mCalCount=calCount;
        isChecked=false;
        mFoodId = UUID.randomUUID();
    }

    public String getFoodName() {
        return mFoodName;
    }

    public void setFoodName(String foodName) {
        mFoodName = foodName;
    }

}
