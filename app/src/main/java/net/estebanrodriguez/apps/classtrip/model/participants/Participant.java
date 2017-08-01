package net.estebanrodriguez.apps.classtrip.model.participants;

import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;

import java.util.UUID;


public abstract class Participant {

    private final String mID;
    private final String mFirstName;
    private final String mLastName;
    private final ContactInfo mContactInfo;
    private final AccessType mAccessType;

    public Participant(String firstName, String lastName, ContactInfo contactInfo, AccessType accessType) {
        mID = UUID.randomUUID().toString();
        mFirstName = firstName;
        mLastName = lastName;
        mContactInfo = contactInfo;
        mAccessType = accessType;
    }

    public Participant(String id, String firstName, String lastName, ContactInfo contactInfo, AccessType accessType) {
        mID = id;
        mFirstName = firstName;
        mLastName = lastName;
        mContactInfo = contactInfo;
        mAccessType = accessType;
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

    public AccessType getAccessType() {
        return mAccessType;
    }

}
