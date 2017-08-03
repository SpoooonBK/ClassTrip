package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.itinerary.ItineraryItem;
import net.estebanrodriguez.apps.classtrip.model.participants.AccessType;
import net.estebanrodriguez.apps.classtrip.model.participants.Participant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Trip {

    private String mTripId;
    private List<ItineraryItem> mItineraryItems;
    private Map<String, AccessType> mParticipantAccessMap;

    private Trip(Builder builder) {
        mItineraryItems = new ArrayList<>();
        mParticipantAccessMap = new HashMap<>();
        addParticipant(builder.mOrganizer, AccessType.ORGANIZER);
        setInitialItinerary(builder);
    }

    public String getTripId() {
        return null;
    }

    public void setTripId(String id){mTripId = id;}

    public String getName() {
        return null;
    }

    public List<ItineraryItem> getItinerary() {
        return mItineraryItems;
    }

    public void setInitialItinerary(Builder builder){
        ItineraryItem.Builder itineraryBuilder = new ItineraryItem.Builder();

        if(builder.mPlaceId != null){
            itineraryBuilder.withPlaceId(builder.mPlaceId);
        }
        if(builder.mStartDate != null){
            itineraryBuilder.withStartDate(builder.mStartDate);
        }
        if(builder.mEndDate != null){
            itineraryBuilder.withEndDate(builder.mEndDate);
        }
        if(builder.mStartTime != null){
            itineraryBuilder.withStartTime(builder.mStartTime);
        }
        if(builder.mEndTime != null){
            itineraryBuilder.withEndTime(builder.mEndTime);
        }
        if(builder.mNote != null){
            itineraryBuilder.withNote(builder.mNote);
        }
        mItineraryItems.add(itineraryBuilder.build());
    }

    public void addParticipant(Participant participant, AccessType accessType){
       mParticipantAccessMap.put(participant.getID(), accessType);
    }

    public int itinerarySize(){
        return mItineraryItems.size();
    }


    public static class Builder{

        private String mStartDate;
        private String mEndDate;
        private String mStartTime;
        private String mEndTime;
        private String mPlaceId;
        private String mNote;
        private Participant mOrganizer;



        public Builder(Participant organizer){
            mOrganizer = organizer;
        }

        public Builder withStartDate(String startDate){
            mStartDate = startDate;
            return this;
        }

        public Builder withEndDate(String endDate){
            mEndDate = endDate;
            return this;
        }

        public Builder withStartTime(String startTime){
            mStartTime = startTime;
            return this;
        }

        public Builder withEndTime(String endTime){
            mEndTime = endTime;
            return this;
        }

        public Builder withPlace(String place){
            mPlaceId = place;
            return this;
        }

        public Builder withNote(String note){
            mNote = note;
            return this;
        }

        public Trip build(){

            return new Trip(this);
        }
    }


}
