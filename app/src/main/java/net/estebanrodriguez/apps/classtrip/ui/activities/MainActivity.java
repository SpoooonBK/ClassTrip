package net.estebanrodriguez.apps.classtrip.ui.activities;

import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.gms.common.api.GoogleApiClient;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.ui.fragments.AllParticipantsFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.GroupsFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.MessagesFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.ParticipantFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.TripsFragment;
import net.estebanrodriguez.apps.classtrip.utilities.GoogleApiClientHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.fragment_holder) FrameLayout mFragmentHolder;
    @BindView(R.id.toolbar_main) Toolbar mMainToolbar;
    @BindView(R.id.main_bottom_navigation) BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this);

        setSupportActionBar(mMainToolbar);
        displayFragment(new TripsFragment(), TripsFragment.class.getSimpleName());
        setOnNavigationItemSelectedListener();
        connectToGoogleApiClient();
    }


    private void connectToGoogleApiClient(){

        GoogleApiClientHelper helper = new GoogleApiClientHelper(this);
        GoogleApiClient googleApiClient = helper.getGoogleApiClient();
        googleApiClient.connect();
    }

    private void setOnNavigationItemSelectedListener(){

        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        String tag = getTagByItemID(item.getItemId());

        fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment != null){
            displayFragment(fragment, tag);
        }else
            fragment = getNewFragmentByItemID(item.getItemId());
            displayFragment(fragment, tag);
        return true;
    }

    private String getTagByItemID(int itemId){

        switch (itemId){
            case R.id.bottom_menu_item_trips:{
                return TripsFragment.class.getSimpleName();
            }
            case R.id.bottom_menu_item_participants:{
                return AllParticipantsFragment.class.getSimpleName();
            }

            case R.id.bottom_menu_item_groups:{
                return GroupsFragment.class.getSimpleName();
            }

            case R.id.bottom_menu_item_messages:{
                return MessagesFragment.class.getSimpleName();
            }
            default: return TripsFragment.class.getSimpleName();
        }
    }

    private Fragment getNewFragmentByItemID(int itemId) {
        Fragment fragment;
        switch (itemId){
            case R.id.bottom_menu_item_trips:{
                return new TripsFragment();
            }
            case R.id.bottom_menu_item_participants:{
                return new AllParticipantsFragment();
            }

            case R.id.bottom_menu_item_groups:{
                return new GroupsFragment();
            }

            case R.id.bottom_menu_item_messages:{
                return new MessagesFragment();
            }
            default: return new TripsFragment();
        }
    }


    private void displayFragment(Fragment fragment, String tag){
        getSupportFragmentManager().popBackStackImmediate();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_holder, fragment, tag)
                .commit();
    }



}
