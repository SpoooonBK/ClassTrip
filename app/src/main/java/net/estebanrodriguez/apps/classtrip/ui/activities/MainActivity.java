package net.estebanrodriguez.apps.classtrip.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.data.DAO;
import net.estebanrodriguez.apps.classtrip.data.FirebaseDAO;
import net.estebanrodriguez.apps.classtrip.model.contact_info.Address;
import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;
import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumber;
import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumberInfo;
import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumberType;
import net.estebanrodriguez.apps.classtrip.model.contact_info.StandardContactInfo;
import net.estebanrodriguez.apps.classtrip.model.participants.Participant;
import net.estebanrodriguez.apps.classtrip.model.participants.StandardParticipant;
import net.estebanrodriguez.apps.classtrip.ui.fragments.AllParticipantsFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.GroupsFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.MessagesFragment;
import net.estebanrodriguez.apps.classtrip.ui.fragments.TripsFragment;
import net.estebanrodriguez.apps.classtrip.utilities.Constants;
import net.estebanrodriguez.apps.classtrip.utilities.GoogleApiClientHelper;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int RC_SIGN_IN = 1;
    private static final int RC_REGISTRATION = 2;
    private static final String ANONYMOUS = "Anonymous";
    @BindView(R.id.fragment_holder)
    FrameLayout mFragmentHolder;
    @BindView(R.id.toolbar_main)
    Toolbar mMainToolbar;
    @BindView(R.id.main_bottom_navigation)
    BottomNavigationView mBottomNavigationView;
    boolean mIsMainNavHidden;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mTripsDatabaseReference;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String mUserId;
    private Participant mParticipant;
    private DAO mDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this);

        mDAO = FirebaseDAO.getInstance();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        initializeFirebaseAuthLogin();


        mTripsDatabaseReference = mFirebaseDatabase.getReference().child("trips");


        setSupportActionBar(mMainToolbar);
        displayFragment(new TripsFragment(), TripsFragment.class.getSimpleName());
        setOnNavigationItemSelectedListener();
        connectToGoogleApiClient();
    }


    //Authorization and Registration

    private void initializeFirebaseAuthLogin(){
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    onSignedInInitialized(user);

                } else {
                    onSignedOutCleanUp();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(
                                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .setTheme(R.style.LoginTheme)
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        };
    }

    private void onSignedOutCleanUp() {
        mUserId = ANONYMOUS;
    }

    private void onSignedInInitialized(FirebaseUser user) {
        mUserId = user.getUid();

        if(mParticipant == null){
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivityForResult(intent, RC_REGISTRATION);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_REGISTRATION && resultCode == RESULT_OK){

            String firstName = data.getStringExtra(Constants.FIRST_NAME);
            String lastName = data.getStringExtra(Constants.LAST_NAME);
            String fullName = firstName + " " + lastName;
            String mobileNumber = data.getStringExtra(Constants.MOBILE_NUMBER);
            String emergencyContactName = data.getStringExtra(Constants.EMERGENCY_CONTACT_NAME);
            String emergencyContactPhone = data.getStringExtra(Constants.EMERGENCY_CONTACT_PHONE);

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String userEmail = user.getEmail();
            Address address = new Address(userEmail);


            PhoneNumber mobilePhone = new PhoneNumber(fullName, mobileNumber, PhoneNumberType.MOBILE);
            PhoneNumber emergencyPhone = new PhoneNumber(emergencyContactName, emergencyContactPhone, PhoneNumberType.EMERGENCY);


            PhoneNumberInfo phoneNumberInfo = new PhoneNumberInfo();
            phoneNumberInfo.addPhoneNumber(mobilePhone);
            phoneNumberInfo.addPhoneNumber(emergencyPhone);

            ContactInfo contactInfo = new StandardContactInfo(address, phoneNumberInfo);
            mParticipant = new StandardParticipant(mUserId, firstName, lastName, contactInfo);
            mDAO.add(mParticipant);

        }
    }

    private void connectToGoogleApiClient() {

        GoogleApiClientHelper helper = new GoogleApiClientHelper(this);
        GoogleApiClient googleApiClient = helper.getGoogleApiClient();
        googleApiClient.connect();
    }

    //UI Management

    private void setOnNavigationItemSelectedListener() {

        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    public boolean isSignedIn(){
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        return (user != null);
    }

    public String getUserId() {
        return mUserId;
    }

    public Participant getParticipant() {
        return mParticipant;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        String tag = getTagByItemID(item.getItemId());

        fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            displayFragment(fragment, tag);
        } else
            fragment = getNewFragmentByItemID(item.getItemId());
        displayFragment(fragment, tag);
        return true;
    }

    private String getTagByItemID(int itemId) {

        switch (itemId) {
            case R.id.bottom_menu_item_trips: {
                return TripsFragment.class.getSimpleName();
            }
            case R.id.bottom_menu_item_participants: {
                return AllParticipantsFragment.class.getSimpleName();
            }

            case R.id.bottom_menu_item_groups: {
                return GroupsFragment.class.getSimpleName();
            }

            case R.id.bottom_menu_item_messages: {
                return MessagesFragment.class.getSimpleName();
            }
            default:
                return TripsFragment.class.getSimpleName();
        }
    }

    private Fragment getNewFragmentByItemID(int itemId) {
        switch (itemId) {
            case R.id.bottom_menu_item_trips: {
                return new TripsFragment();
            }
            case R.id.bottom_menu_item_participants: {
                return new AllParticipantsFragment();
            }

            case R.id.bottom_menu_item_groups: {
                return new GroupsFragment();
            }

            case R.id.bottom_menu_item_messages: {
                return new MessagesFragment();
            }
            default:
                return new TripsFragment();
        }
    }


    private void displayFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().popBackStackImmediate();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_holder, fragment, tag)
                .commit();
    }

    public void hideBottomNavigation() {


        mBottomNavigationView.animate()
                .translationYBy(mBottomNavigationView.getHeight())
                .alpha(0.0f);
        mIsMainNavHidden = true;

    }

    public void showBottomNavigation() {

        mBottomNavigationView.animate()
                .translationYBy(-mBottomNavigationView.getHeight())
                .alpha(1.0f);
        mIsMainNavHidden = false;

    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mIsMainNavHidden) {
            showBottomNavigation();
        }
    }
}
