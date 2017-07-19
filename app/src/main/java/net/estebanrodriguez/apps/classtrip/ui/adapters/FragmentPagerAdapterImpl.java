package net.estebanrodriguez.apps.classtrip.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.estebanrodriguez.apps.classtrip.ui.fragments.GroupsFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.MessagesFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.ParticipantFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.TripsFragment;


public class FragmentPagerAdapterImpl extends FragmentPagerAdapter {

    FragmentManager mFragmentManager;

    public FragmentPagerAdapterImpl(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;

    }

    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0: return TripsFragment.getInstance();
            case 1: return ParticipantFragment.getInstance();
            case 2: return GroupsFragment.getInstance();
            case 3: return MessagesFragment.getInstance();
            default:return TripsFragment.getInstance();
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
