package net.estebanrodriguez.apps.classtrip.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import net.estebanrodriguez.apps.classtrip.R;
import net.estebanrodriguez.apps.classtrip.model.contact_info.Address;
import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;
import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumber;
import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumberInfo;
import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumberType;
import net.estebanrodriguez.apps.classtrip.model.contact_info.StandardContactInfo;
import net.estebanrodriguez.apps.classtrip.model.participants.AccessType;
import net.estebanrodriguez.apps.classtrip.model.participants.Participant;
import net.estebanrodriguez.apps.classtrip.model.participants.StandardParticipant;

import butterknife.BindView;
import butterknife.OnClick;

public class AddParticipantFragment extends Fragment {

    @BindView(R.id.add_participant_name_first_edit_text) EditText mFirstNameEditText;
    @BindView(R.id.add_participant_name_last_edit_text) EditText mLastNameEditText;
    @BindView(R.id.add_participant_email_edit_text) EditText mEmailEditText;
    @BindView(R.id.add_participant_phone_edit_text) EditText mPhoneEditText;
    @BindView(R.id.add_participant_emergency_name_edit_text) EditText mEmergencyNameEditText;
    @BindView(R.id.add_participant_emergency_phone_edit_text) EditText mEmergencyPhoneEditText;
    @BindView(R.id.add_participant_role_radio_group) RadioGroup mRadioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.add_participant,container, false);

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        String title = getString(R.string.add_participant);
        getActivity().setTitle(title);
    }

    @OnClick(R.id.add_participant_done_fab)
    public void addParticipant(){
        String firstName = mFirstNameEditText.getText().toString();
        String lastName = mLastNameEditText.getText().toString();
        String email = mEmailEditText.getText().toString();


        Address address = new Address(email);
        PhoneNumberInfo phoneNumberInfo = setPhoneNumberInfo();

        ContactInfo contactInfo = new StandardContactInfo(address, phoneNumberInfo);


    }

    public PhoneNumberInfo setPhoneNumberInfo(){

        String firstName = mFirstNameEditText.getText().toString();
        String lastName = mLastNameEditText.getText().toString();
        String fullName = firstName + " " + lastName;

        String phone = mPhoneEditText.getText().toString();
        String emergencyContactName = mEmergencyNameEditText.getText().toString();
        String emergencyContactPhone = mEmergencyPhoneEditText.getText().toString();

        PhoneNumber phoneNumber = new PhoneNumber(phone, PhoneNumberType.MOBILE);
        phoneNumber.setName(fullName);

        PhoneNumber emergencyContact = new PhoneNumber(emergencyContactPhone, PhoneNumberType.EMERGENCY);
        emergencyContact.setName(emergencyContactName);

        PhoneNumberInfo phoneNumberInfo = new PhoneNumberInfo();
        phoneNumberInfo.addPhoneNumber(phoneNumber);
        phoneNumberInfo.addPhoneNumber(emergencyContact);
        return phoneNumberInfo;
    }


}
