package com.blikoon.fragmentstute;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class MainActivity extends AppCompatActivity
implements  Fragment1.OnFragment1ClickListener{

    public void onFragment1Message( String message)
    {

        Fragment2 fragment2 = new Fragment2();
        Bundle args = new Bundle();
        args.putString("fragment1_message",message);
        fragment2.setArguments(args);


        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction
                .replace(R.id.fragment_container, fragment2);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load the Fragment in the place holder
        if(findViewById(R.id.fragment_container) != null)
        {

            //Should check for savedInstancestate but leave it for now.
            Fragment1 fragment1 = new Fragment1();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.fragment_container, fragment1);
            transaction.commit();

        }



    }
}
