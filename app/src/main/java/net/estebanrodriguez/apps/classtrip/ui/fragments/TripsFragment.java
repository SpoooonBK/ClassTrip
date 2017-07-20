package net.estebanrodriguez.apps.classtrip.ui.fragments;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.estebanrodriguez.apps.classtrip.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import timber.log.Timber;



public class TripsFragment extends Fragment {

    private final String ADD_TRIP = "add_trip";
    private Unbinder mUnbinder;

    @BindView(R.id.trips_list) RecyclerView trips;
    @BindView(R.id.add_trip_fab) FloatingActionButton mFloatingActionButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.trips_fragment, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);

        trips.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        mFloatingActionButton.hide();
                        case RecyclerView.SCROLL_STATE_SETTLING:
                            mFloatingActionButton.show();
                }
            }
        });


        return rootView;
    }

    @OnClick(R.id.add_trip_fab)
    public void displayAddTripFragment(){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_holder, new AddTripFragment(), AddTripFragment.class.getSimpleName())
                .addToBackStack(ADD_TRIP)
                .commit();
    }


    public static Fragment getInstance(){
        return new TripsFragment();
    }



    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.trips);
        getActivity().setTitle(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
