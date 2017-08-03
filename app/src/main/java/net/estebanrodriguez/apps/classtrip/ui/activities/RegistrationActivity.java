package net.estebanrodriguez.apps.classtrip.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.utilities.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;


public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.user_registration_name_first_edit_text)
    EditText mfirstNameEditText;
    @BindView(R.id.user_registration_name_last_edit_text)
    EditText mLastNameEditText;
    @BindView(R.id.user_registration_mobile_phone_edit_text)
    EditText mMobilePhoneEditText;
    @BindView(R.id.user_registration_emergency_name_edit_text)
    EditText mEmergencyContactNameEditText;
    @BindView(R.id.user_registration_emergency_phone_edit_text)
    EditText mEmergencyPhoneEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);
        ButterKnife.bind(this);
        Timber.v("Registration OnCreate");
    }

    @OnClick(R.id.user_registration_done_fab)
    public void onRegistrationDoneClicked(){
        String firstName = mfirstNameEditText.getText().toString();
        String lastName = mLastNameEditText.getText().toString();
        String mobileNumber = mMobilePhoneEditText.getText().toString();
        String emergencyContactName = mEmergencyContactNameEditText.getText().toString();
        String emergencyContactPhone = mEmergencyPhoneEditText.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(Constants.FIRST_NAME, firstName);
        resultIntent.putExtra(Constants.LAST_NAME, lastName);
        resultIntent.putExtra(Constants.MOBILE_NUMBER, mobileNumber);
        resultIntent.putExtra(Constants.EMERGENCY_CONTACT_NAME, emergencyContactName);
        resultIntent.putExtra(Constants.EMERGENCY_CONTACT_PHONE, emergencyContactPhone);

        setResult(RESULT_OK, resultIntent);
        onBackPressed();
    }


}
