package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;
import net.estebanrodriguez.apps.classtrip.model.itinerary.TripItinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Trip {

    private String mTripId;
    private List<String> mOrganizerIds;
    private String mTripName;
    private Itinerary mItinerary;

    private Trip(Builder builder) {
        mTripName = builder.mName;
        mTripId = UUID.randomUUID().toString();
        mItinerary = new TripItinerary();
        mOrganizerIds = new ArrayList<>();
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

    public static class Builder{

        private String mName;
        private String mStartDate;
        private String mEndDate;
        private String mStartTime;
        private String mEndTime;
        private String mPlace;
        private String mOrganizerId;



        public Builder(String name){
            mName = name;
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

        public Builder withOrganizer(String organizerId){
            mOrganizerId = organizerId;
            return this;
        }

        public Trip build(){

            return new Trip(this);
        }


    }




}
