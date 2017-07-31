package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;
import net.estebanrodriguez.apps.classtrip.model.itinerary.TripItinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Trip {

    private String mId;
    private List<String> mOrganizerIds;
    private String mTripName;
    private Itinerary mItinerary;

    private Trip(Builder builder) {
        mTripName = builder.mName;
        mId = UUID.randomUUID().toString();
        mItinerary = new TripItinerary();
        mOrganizerIds = new ArrayList<>();
    }

    public String getId() {
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

        public Builder(String name){
            mName = name;
        }

        public Builder withStartDate(String date){
            //Todo Implement
            return this;
        }

        public Builder withEndDate(String date){
            //Todo Implement
            return this;
        }

        public Builder withStartTime(String startTime){
            //Todo Implement
            return this;
        }

        public Builder withEndTime(String endTime){
            //Todo Implement
            return this;
        }

        public Builder withPlace(String place){
            //Todo Implement
            return this;
        }

        public Trip build(){

            return new Trip(this);
        }


    }




}
