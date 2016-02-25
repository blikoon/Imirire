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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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
            foodItemCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    mFood.setIsChecked(isChecked);
                    gramInputField.setText(String.valueOf(""));
                    if (!isChecked) {
                        //If the user unchecks a food
                        // 1.clear its gram input field
                        // 2.Set the food gram count to 0
                        mFood.setGramCount(0.0);
                        // mAdapter.notifyDataSetChanged();
                        gramInputField.setText(String.valueOf(0.0));

                    }
                    updateDisplay();
                }
            });

            foodNameTextView = (TextView) itemView.findViewById(R.id.list_item_food_name);
            gramInputField = (EditText) itemView.findViewById(R.id.list_item_gram_input_field);
            gramInputField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String dataString = s.toString();

                    if(dataString.isEmpty())
                    {
                        Log.d("Imirire","Empty string");
                        if(gramInputField.hasFocus())
                        {
                            Log.d("Imirire","gramInputField Has Focus");
                            mFood.setGramCount(0.0);
                            updateDisplay();

                        }
                    }else
                    {

                        double itemGramCount = Double.parseDouble(s.toString());
                        mFood.setGramCount(itemGramCount);
                        updateDisplay();

                    }

                }
            });

            gramInputField.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gramInputField.setText(String.valueOf(""));

                }
            });
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

        public double computeCaloryTotal()
        {
            double calTotal=0;
            for(int i=0;i<mFoods.size();i++)
            {
                Food food = mFoods.get(i);
                if(food.isChecked()) {
                    double internalCal = mFoods.get(i).getCalCount() * mFoods.get(i).getGramCount() / 100;
                    calTotal += internalCal;
                }
            }
            return  calTotal;
        }
        public void clearSelectedFoods()
        {
            for(int i=0;i<mFoods.size();i++)
            {
                Food food = mFoods.get(i);
                if(food.isChecked())
                {
                    // set its gram count to 0
                    // set the food as unchecked
                    food.setGramCount(0);
                    food.setIsChecked(false);

                }
            }
        }

    }

    //FoodAdapter class ends here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mFoodListRecyclerView = (RecyclerView)
                findViewById(R.id.food_list_recycler_view);
        mFoodListRecyclerView.addItemDecoration(
                new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL_LIST));
        mFoodListRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        //Display textView
        caloryDisplayTextView = (TextView)findViewById(R.id.calorie_display);


        FoodModel model = FoodModel.get(getBaseContext());
        List<Food> foods = model.getFoods();

        mAdapter = new FoodAdapter(foods);
        mFoodListRecyclerView.setAdapter(mAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clear_data:
                clearData();
                return true;
            case R.id.add_food:
                addFood();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void clearData()
    {
        mAdapter.clearSelectedFoods();
        mAdapter.notifyDataSetChanged();
        updateDisplay();

    }

    private void addFood()
    {

    }

    private void updateDisplay()
    {
        //Not implemented yet.
        double calTotal = mAdapter.computeCaloryTotal();
        //caloryDisplayTextView.setText(String.valueOf(calTotal));
        caloryDisplayTextView.setText(String.format("%.2f", calTotal));
        Log.d("Imirire", "Calling updateDisplay ,the total is :"+
                String.format("%.2f", calTotal));
    }
}
