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


public class AddGroupFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.add_group, container, false);
        ButterKnife.bind(this, rootview);
        return rootview;
    }

    @OnClick(R.id.add_group_done_fab)
    public void addGroup(){
        //Todo implement
        getFragmentManager().popBackStack();
    }

    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.add_group);
        getActivity().setTitle(title);
    }
}
