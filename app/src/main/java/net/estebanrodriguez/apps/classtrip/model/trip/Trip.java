package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;
import net.estebanrodriguez.apps.classtrip.model.itinerary.TripItinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Trip {

    private String mTripId;
    private List<String> mOrganizerIds;
    private Itinerary mItinerary;

    private Trip(Builder builder) {
        mTripId = UUID.randomUUID().toString();
        mItinerary = new TripItinerary();
        mOrganizerIds = new ArrayList<>();
        addOrganizerID(builder.mOrganizerId);
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

    public void addOrganizerID(String id){
       mOrganizerIds.add(id);
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
        private String mPlace;
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
            mPlace = place;
            return this;
        }

        public Trip build(){

            return new Trip(this);
        }


    }




}
