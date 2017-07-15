package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.estebanrodriguez.apps.classtrip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TripsFragment extends Fragment {

    @BindView(R.id.trips_list) RecyclerView trips;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.trips_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.add_trip_fab)
    public void addTrip(){
        displayAddTripFragment();

    }

    private void displayAddTripFragment(){
    }
}
