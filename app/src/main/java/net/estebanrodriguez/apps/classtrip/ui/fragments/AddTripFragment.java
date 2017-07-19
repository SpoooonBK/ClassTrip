package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;
import net.estebanrodriguez.apps.classtrip.utilities.DateValidator;
import net.estebanrodriguez.apps.classtrip.utilities.TimeValidator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

import static android.app.Activity.RESULT_OK;

public class AddTripFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{


    private static final int PLACE_PICKER_REQUEST = 1;

    @BindView(R.id.add_trip_date_start_edit_text) EditText dateStartEditText;
    @BindView(R.id.add_trip_date_end_edit_text) EditText dateEndEditText;
    @BindView(R.id.add_trip_time_start_edit_text) EditText timeStartEditText;
    @BindView(R.id.add_trip_time_end_edit_text) EditText timeEndEditText;
    @BindView(R.id.add_trip_place_edit_text) EditText placeEditText;

    private EditText mClickedEditText;
    private Calendar calendar = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_trip, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.add_trip_done_fab)
    public void onAddTripDoneClicked(){
        validateDates();
        validateTimes();

    }

    private void validateDates(){
        String dateStart = dateStartEditText.getText().toString();
        String dateEnd = dateEndEditText.getText().toString();
        if(!DateValidator.isStartDateIsSameOrBeforeEndDate(dateStart, dateEnd)){
            Toast.makeText(getActivity(), getString(R.string.dates_invalid),Toast.LENGTH_LONG).show();
        }
    }

    private void validateTimes(){
        String timeStart = timeStartEditText.getText().toString();
        String timeEnd = timeEndEditText.getText().toString();
        if(!TimeValidator.isStartTimeBeforeEndTime(timeStart, timeEnd)){
            Toast.makeText(getActivity(), getString(R.string.times_invalid),Toast.LENGTH_LONG).show();
        }
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

    @OnClick(R.id.add_trip_place_edit_text)
    public void showPlacePicker(View view){
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            Timber.v("Clicked");
            Intent intent = builder.build(getActivity());
            startActivityForResult(intent, PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.add_trip);
        getActivity().setTitle(title);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PLACE_PICKER_REQUEST && resultCode == RESULT_OK){
            Place place = PlacePicker.getPlace(getActivity(), data);
            String name = place.getName().toString();
            String address = place.getAddress().toString();
            String nameAndAddress = name + "\n" + address;

            placeEditText.setText(nameAndAddress);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String myFormat = "MM/dd/yy";
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
