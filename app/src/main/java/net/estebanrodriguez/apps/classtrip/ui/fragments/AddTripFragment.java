package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.model.trip.ClassTrip;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class AddTripFragment extends Fragment{

    @BindView(R.id.add_trip_date_edit_text) EditText dateEditText;
    @BindView(R.id.add_trip_time_edit_text) EditText timeEditText;
    @BindView(R.id.add_trip_name_edit_text) EditText nameEditText;
    @BindView(R.id.add_trip_address_edit_text) EditText addressEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_trip, container, false);
        ButterKnife.bind(this, rootView);
        Timber.v("add trip");
        return rootView;
    }

    @OnClick(R.id.add_trip_done_fab)
    public void onAddTrip(){

        String date = dateEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();

        Trip trip = new ClassTrip(name);
    }

    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.add_trip);
        getActivity().setTitle(title);
    }
}
