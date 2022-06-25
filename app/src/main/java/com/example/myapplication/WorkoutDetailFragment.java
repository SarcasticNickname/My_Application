package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.stopwatch_container, stopwatchFragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        } else {
            workoutId = savedInstanceState.getLong("workoutId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = WorkoutDetailFragment.this.getView();
        if (view != null) {
            // Setting title.
            TextView title = view.findViewById(R.id.textTitle);
            Workout workout =  Workout.workouts[(int)workoutId];
            title.setText(workout.getName());
            // Setting description.
            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}