package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment{



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        Fragment fragment = getFragmentManager().findFragmentByTag(AddTripFragment.class.getSimpleName());

        TimePickerDialog.OnTimeSetListener listener = (TimePickerDialog.OnTimeSetListener) fragment;


        return new TimePickerDialog(
                getActivity(), listener, hour, minute, DateFormat.is24HourFormat(getActivity()));

    }

}
