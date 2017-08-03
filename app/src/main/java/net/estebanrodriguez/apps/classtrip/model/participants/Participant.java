package net.estebanrodriguez.apps.classtrip.model.participants;

import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;

import java.util.UUID;


public abstract class Participant {

    private final String mID;
    private final String mFirstName;
    private final String mLastName;
    private final ContactInfo mContactInfo;


    public Participant(String firstName, String lastName, ContactInfo contactInfo) {
        mID = UUID.randomUUID().toString();
        mFirstName = firstName;
        mLastName = lastName;
        mContactInfo = contactInfo;
    }


    public Participant(String id, String firstName, String lastName, ContactInfo contactInfo) {
        mID = id;
        mFirstName = firstName;
        mLastName = lastName;
        mContactInfo = contactInfo;
    }

    public String getID() {
        return mID;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getName() {
        String fullname = mFirstName + " " + mLastName;
        return fullname;
    }

    public ContactInfo getContactInfo() {
        return mContactInfo;
    }


}
