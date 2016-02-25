package com.blikoon.imirire.database;

/**
 * Created by gakwaya on 2/24/2016.
 */
public class FoodDbSchema {
    public static final class FoodTable
    {
        public static final String NAME = "foods";

        public static final class Cols
        {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String GRAM_COUNT = "gramcount";
            public static final String CAL_COUNT = "calcount";
            public static final String IS_CHECKED = "ischecked";
        }
    }
}
