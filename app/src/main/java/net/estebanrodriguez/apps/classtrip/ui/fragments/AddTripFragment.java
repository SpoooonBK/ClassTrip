package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.estebanrodriguez.apps.classtrip.R;

import butterknife.ButterKnife;

public class AddTripFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_trip, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
