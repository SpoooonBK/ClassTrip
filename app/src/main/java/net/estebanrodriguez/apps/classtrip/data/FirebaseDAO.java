package net.estebanrodriguez.apps.classtrip.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumber;
import net.estebanrodriguez.apps.classtrip.model.itinerary.ItineraryItem;
import net.estebanrodriguez.apps.classtrip.model.participants.AccessType;
import net.estebanrodriguez.apps.classtrip.model.participants.Participant;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirebaseDAO implements DataAccessObject {

    private final FirebaseDatabase mFirebaseDatabase;
    private final static FirebaseDAO INSTANCE = new FirebaseDAO();

    private FirebaseDAO(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
    }

    public static DataAccessObject getInstance(){
        return INSTANCE;
    }

    @Override
    public String add(Trip trip) {
        DatabaseReference trips = mFirebaseDatabase.getReference("trips");
        DatabaseReference tripId = trips.push();
        String tripKey = tripId.getKey();
        trip.setTripId(tripId.getKey());
        tripId.setValue(new FirebaseTrip(trip));
        return tripKey;
    }

    @Override
    public void add(Participant participant) {
        DatabaseReference users = mFirebaseDatabase.getReference("users");
        users.child(participant.getID()).setValue(new FirebaseParticipant(participant));
    }

    @Override
    public void update(Participant participant) {
        DatabaseReference participantReference = mFirebaseDatabase.getReference("users").child(participant.getID());
        participantReference.setValue(new FirebaseParticipant(participant));
    }


    private class FirebaseParticipant{

        private String mId;
        private String mFirstName;
        private String mLastName;
        private String mEmail;
        private List<FirebasePhoneNumber> mPhoneNumbers;
        private List<String> mTripIds;


        public FirebaseParticipant() {//default constructor for Firebase Write
        }

        public FirebaseParticipant(Participant participant) {
            mId = participant.getID();
            mFirstName = participant.getFirstName();
            mLastName = participant.getLastName();
            mEmail = participant.getContactInfo().getEmail();
            List<PhoneNumber> phoneNumbers = participant.getContactInfo().getPhoneNumbers();
            mPhoneNumbers = new ArrayList<>();
            for(PhoneNumber phoneNumber: phoneNumbers){
                FirebasePhoneNumber firebasePhoneNumber = new FirebasePhoneNumber(phoneNumber);
                mPhoneNumbers.add(firebasePhoneNumber);
            }
            mTripIds = new ArrayList<>();
            for(String tripId: participant.getTripIds()){
                mTripIds.add(tripId);
            }
        }

        public String getId() {
            return mId;
        }

        public String getFirstName() {
            return mFirstName;
        }

        public String getLastName() {
            return mLastName;
        }

        public String getEmail() {
            return mEmail;
        }

        public List<FirebasePhoneNumber> getPhoneNumbers() {
            return mPhoneNumbers;
        }

        public List<String> getTripIds() {
            return mTripIds;
        }
    }

    private class FirebasePhoneNumber{

        private String mContactName;
        private String mPhoneNumber;
        private String mPhoneNumberType;

        public FirebasePhoneNumber() {
        }

        public FirebasePhoneNumber(PhoneNumber phoneNumber){
            mContactName = phoneNumber.getContactName();
            mPhoneNumber = phoneNumber.getPhoneNumber();
            mPhoneNumberType = phoneNumber.getType().toString();
        }

        public String getContactName() {
            return mContactName;
        }

        public String getPhoneNumber() {
            return mPhoneNumber;
        }

        public String getPhoneNumberType() {
            return mPhoneNumberType;
        }
    }

    private class FirebaseTrip {
        private String mId;
        private List<ItineraryItem> mItineraryItems;
        private Map<String, String> mParticipantAccessMap;

        public FirebaseTrip() {
        }

        public FirebaseTrip(Trip trip) {
            mId = trip.getTripId();
            mItineraryItems = trip.getItinerary();
            mParticipantAccessMap = new HashMap<>();

            Set<Map.Entry<String, AccessType>> participantSet = trip.getParticipantAccessMap().entrySet();
            for(Map.Entry entry: participantSet){
                String participantId = (String) entry.getKey();
                String accessType = ((AccessType) entry.getValue()).toString();
                mParticipantAccessMap.put(participantId, accessType);
            }
        }

        public String getId() {
            return mId;
        }

        public List<ItineraryItem> getItineraryItems() {
            return mItineraryItems;
        }

        public Map<String, String> getParticipantAccessMap() {
            return mParticipantAccessMap;
        }
    }


}
