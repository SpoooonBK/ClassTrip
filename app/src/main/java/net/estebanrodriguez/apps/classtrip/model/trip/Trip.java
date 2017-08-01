package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.groups.Group;
import net.estebanrodriguez.apps.classtrip.model.groups.StandardGroup;
import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;
import net.estebanrodriguez.apps.classtrip.model.itinerary.ItineraryItem;
import net.estebanrodriguez.apps.classtrip.model.itinerary.TripItinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Trip {

    private String mTripId;
    private Group mAllParticipants;
    private List<String> mGroupIds;
    private Itinerary mItinerary;

    private Trip(Builder builder) {
        mTripId = UUID.randomUUID().toString();
        mItinerary = new TripItinerary();
        mGroupIds = new ArrayList<>();
        mAllParticipants = new StandardGroup();
        addOrganizerID(builder.mOrganizerId);
        setInitialItinerary(builder);
    }

    public String getTripId() {
        return null;
    }

    public String getName() {
        return null;
    }

    public Itinerary getItinerary() {
        return mItinerary;
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
        mItinerary.addItem(itineraryBuilder.build());
    }

    public void addOrganizerID(String id){
       mAllParticipants.add(id);
    }

    public void removeOrganizer(String id){
        mOrganizerIds.remove(id);
    }

    public String[] getOrganizerIds(){
        return mOrganizerIds.toArray(new String[mOrganizerIds.size()]);
    }

    public static class Builder{

        private String mStartDate;
        private String mEndDate;
        private String mStartTime;
        private String mEndTime;
        private String mPlaceId;
        private String mNote;
        private String mOrganizerId;



        public Builder(String organizerId){
            mOrganizerId = organizerId;
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
