package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class AddTripFragment extends Fragment{

    @BindView(R.id.add_trip_date_start_edit_text) EditText dateStartEditText;
    @BindView(R.id.add_trip_date_end_edit_text) EditText dateEndEditText;
    @BindView(R.id.add_trip_time_start_edit_text) EditText timeStartEditText;
    @BindView(R.id.add_trip_time_end_edit_text) EditText timeEndEditText;
    @BindView(R.id.add_trip_name_edit_text) EditText nameEditText;
    @BindView(R.id.add_trip_address_edit_text) EditText addressEditText;

    final Calendar calendar = Calendar.getInstance();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_trip, container, false);
        ButterKnife.bind(this, rootView);
        Timber.v("add trip");

        assembleDatePickerDialog();


        return rootView;
    }

    private void assembleDatePickerDialog(){

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateText();
            }
        };

        dateStartEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(),
                        date,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DATE))
                        .show();

            }
        });
    }



    private void updateDateText() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateStartEditText.setText(sdf.format(calendar.getTime()));
    }

    @OnClick({R.id.add_trip_time_start_edit_text, R.id.add_trip_time_end_edit_text})
    public void showTimePickerDialog(View view){
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show(getFragmentManager(),"timePicker");
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




    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.add_trip);
        getActivity().setTitle(title);
    }
}
