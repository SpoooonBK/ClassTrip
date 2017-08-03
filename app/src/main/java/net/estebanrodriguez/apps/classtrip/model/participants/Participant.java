package net.estebanrodriguez.apps.classtrip.model.participants;

import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class Participant {

    private final String mID;
    private final String mFirstName;
    private final String mLastName;
    private final ContactInfo mContactInfo;
    private final List<String> mTripIds;


    public Participant(String firstName, String lastName, ContactInfo contactInfo) {
        mID = UUID.randomUUID().toString();
        mTripIds = new ArrayList<>();
        mFirstName = firstName;
        mLastName = lastName;
        mContactInfo = contactInfo;
    }


    public Participant(String id, String firstName, String lastName, ContactInfo contactInfo) {
        mTripIds = new ArrayList<>();
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

    public List<String> getTripIds() {
        return mTripIds;
    }

    public void addTrip(Trip trip){
        mTripIds.add(trip.getTripId());
    }


}
