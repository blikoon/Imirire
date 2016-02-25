package com.blikoon.imirire;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView mFoodListRecyclerView;
    private FoodAdapter mAdapter;
    private TextView caloryDisplayTextView;


    //The FoodHolder class
    private class FoodHolder extends RecyclerView.ViewHolder
    {
        private CheckBox foodItemCheckBox;
        private TextView foodNameTextView;
        private EditText gramInputField;
        private Food mFood;

        public FoodHolder(View itemView)
        {
            super(itemView);
            foodItemCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_food_checkbox);
            foodNameTextView = (TextView) itemView.findViewById(R.id.list_item_food_name);
            gramInputField = (EditText) itemView.findViewById(R.id.list_item_gram_input_field);
        }

        public void bindFood(Food food)
        {
            mFood = food;
            if(mFood == null)
            {
                Log.d("Imirire","Got a null food object");
            }else
            {
                foodItemCheckBox.setChecked(mFood.isChecked());
                foodNameTextView.setText(mFood.getFoodName().toString());

                if(mFood.getGramCount()!=0.0)
                {
                    gramInputField.setText(String.valueOf(mFood.getGramCount()));
                }

            }
        }
    }

    //FoodHolder class ends here.


    //FoodAdapter class Implementation

    private class FoodAdapter extends RecyclerView.Adapter<FoodHolder>
    {
        private List<Food> mFoods;

        public FoodAdapter (List<Food> foods)
        {
            mFoods = foods;
        }

        public FoodHolder onCreateViewHolder( ViewGroup parent,
                                              int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater
                    .inflate(R.layout.list_item_food, parent,
                            false);
            return new FoodHolder(view);
        }

        public void onBindViewHolder(FoodHolder holder ,int position)
        {
            Food food = mFoods.get(position);
            holder.bindFood(food);
        }

        @Override
        public int getItemCount()
        {
            return mFoods.size();
        }

    }

    //FoodAdapter class ends here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFoodListRecyclerView = (RecyclerView)
                findViewById(R.id.food_list_recycler_view);
        mFoodListRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        //Display textView
        caloryDisplayTextView = (TextView)findViewById(R.id.calorie_display);


        FoodModel model = FoodModel.get(getBaseContext());
        List<Food> foods = model.getFoods();

        mAdapter = new FoodAdapter(foods);
        mFoodListRecyclerView.setAdapter(mAdapter);
    }
}
