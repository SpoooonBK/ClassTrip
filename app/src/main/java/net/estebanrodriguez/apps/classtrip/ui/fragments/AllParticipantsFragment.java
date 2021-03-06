package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.ui.activities.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class AllParticipantsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.all_participants_fragment, container, false);
        ButterKnife.bind(this, rootview);
        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.participants);
        getActivity().setTitle(title);
    }

    @OnClick(R.id.add_participant_fab)
    public void displayAddParticipantFragment(){
        ((MainActivity)getActivity()).hideBottomNavigation();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_holder, new AddParticipantFragment())
                .addToBackStack(AddParticipantFragment.class.getSimpleName())
                .commit();
    }


}
