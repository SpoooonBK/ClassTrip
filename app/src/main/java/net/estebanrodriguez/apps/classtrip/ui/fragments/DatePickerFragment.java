package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        Fragment fragment = getFragmentManager().findFragmentByTag(AddTripFragment.class.getSimpleName());
        DatePickerDialog.OnDateSetListener listener = (DatePickerDialog.OnDateSetListener) fragment;

        return new DatePickerDialog(getActivity(), listener, year, month, dayOfMonth);
    }


}
