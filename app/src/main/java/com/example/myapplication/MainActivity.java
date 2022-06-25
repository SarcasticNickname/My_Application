package com.example.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
                          implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {

        View control_view = findViewById(R.id.fragment_container);
        if (control_view != null) {
            // Start transaction
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Configuring transaction
            WorkoutDetailFragment detailFragment = new WorkoutDetailFragment();
            detailFragment.setWorkoutId(id);
            transaction.replace(R.id.fragment_container, detailFragment);
            //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            // Committing
            transaction.commit();

        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id);
            startActivity(intent);
        }
    }
}