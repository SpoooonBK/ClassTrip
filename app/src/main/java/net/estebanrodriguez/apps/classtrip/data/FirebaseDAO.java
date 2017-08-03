package net.estebanrodriguez.apps.classtrip.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.estebanrodriguez.apps.classtrip.model.contact_info.PhoneNumber;
import net.estebanrodriguez.apps.classtrip.model.participants.Participant;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDAO implements DAO{

    private final FirebaseDatabase mFirebaseDatabase;

    private FirebaseDAO(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
    }

    public static DAO getInstance(){
        return new FirebaseDAO();
    }

    @Override
    public void add(Trip trip) {
        DatabaseReference trips = mFirebaseDatabase.getReference("trips");
        DatabaseReference tripId = trips.push();
        tripId.getKey();
    }

    @Override
    public void add(Participant participant) {
        DatabaseReference users = mFirebaseDatabase.getReference("users");
        users.child(participant.getID()).setValue(new FirebaseParticipant(participant));
    }



    private class FirebaseParticipant{

        private String mId;
        private String mFirstName;
        private String mLastName;
        private String mEmail;
        private List<FirebasePhoneNumber> mPhoneNumbers;


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
}
