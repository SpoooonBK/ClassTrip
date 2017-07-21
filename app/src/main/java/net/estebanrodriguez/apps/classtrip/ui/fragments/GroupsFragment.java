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


public class GroupsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.groups_fragment, container, false);

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick
    public void displayAddGroupsFragment(){
        String tag = AddGroupFragment.class.getSimpleName();
        ((MainActivity)getActivity()).hideBottomNavigation();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_holder, new AddGroupFragment(), tag)
                .addToBackStack(tag)
                .commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.groups);
        getActivity().setTitle(title);
    }
}
