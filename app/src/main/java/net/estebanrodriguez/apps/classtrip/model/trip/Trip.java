package net.estebanrodriguez.apps.classtrip.model.trip;

import com.google.android.gms.common.api.GoogleApiClient;

import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;
import net.estebanrodriguez.apps.classtrip.model.itinerary.ItineraryItem;
import net.estebanrodriguez.apps.classtrip.model.itinerary.TripItinerary;

import java.util.UUID;

public final class Trip {

    private String mId;
    private String mTripName;
    private Itinerary mItinerary;

    private Trip(Builder builder) {
        mTripName = builder.mName;
        mId = UUID.randomUUID().toString();
        mItinerary = new TripItinerary();
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
