package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class AddTripFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    @BindView(R.id.add_trip_date_start_edit_text) EditText dateStartEditText;
    @BindView(R.id.add_trip_date_end_edit_text) EditText dateEndEditText;
    @BindView(R.id.add_trip_time_start_edit_text) EditText timeStartEditText;
    @BindView(R.id.add_trip_time_end_edit_text) EditText timeEndEditText;
    @BindView(R.id.add_trip_name_edit_text) EditText nameEditText;
    @BindView(R.id.add_trip_address_edit_text) EditText addressEditText;

    EditText mClickedEditText;

    final Calendar calendar = Calendar.getInstance();
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

        String dateStart = dateStartEditText.getText().toString();
        String dateEnd = dateEndEditText.getText().toString();
        String timeStart = timeStartEditText.getText().toString();
        String timeEnd = timeEndEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();

        Trip trip = new Trip.Builder(name)
                .withStartDate(dateStart)
                .withStartTime(timeStart)
                .withPlace(address)
                .build();
    }


    @OnClick({R.id.add_trip_time_start_edit_text, R.id.add_trip_time_end_edit_text})
    public void showTimePickerDialog(View view){
        mClickedEditText = (EditText) view;
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show(getFragmentManager(),"timePicker");
    }



    @OnClick({R.id.add_trip_date_start_edit_text, R.id.add_trip_date_end_edit_text})
    public void showDatePickerDialog(View view){

        Bundle bundle = new Bundle();


        mClickedEditText = (EditText) view;
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getFragmentManager(), "datePicker");
    }



    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.add_trip);
        getActivity().setTitle(title);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        updateEditText(sdf);
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        String myFormat ="hh:mm aa";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        updateEditText(sdf);
    }

    private void updateEditText(SimpleDateFormat sdf) {
        mClickedEditText.setText(sdf.format(calendar.getTime()));
    }




}
