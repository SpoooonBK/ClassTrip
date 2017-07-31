package net.estebanrodriguez.apps.classtrip.model.itinerary;

import com.google.android.gms.location.places.Place;

public class ItineraryItem {
    private String mPlaceId;
    private String mStartDate;
    private String mEndDate;
    private String mStartTime;
    private String mEndTime;
    private String mNote;


    private ItineraryItem(Builder builder) {

        if(builder.mPlaceId != null){
            mPlaceId = builder.mPlaceId;
        }
        if(builder.mStartDate != null){
            mStartDate = builder.mStartDate;
        }
        if(builder.mEndDate != null){
            mEndDate = builder.mEndDate;
        }
        if(builder.mStartTime != null){
            mStartTime = builder.mStartTime;
        }
        if(builder.mEndTime != null){
            mEndTime = builder.mEndTime;
        }
        if(builder.mNote != null){
            mNote = builder.mNote;
        }
    }

    public String getPlaceId() {
        return mPlaceId;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public String getNote() {
        return mNote;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public String getEndTime() {
        return mEndTime;
    }


    public static class Builder{
        public Builder() {
        }

        private String mStartTime;
        private String mEndTime;
        private String mStartDate;
        private String mEndDate;
        private String mPlaceId;
        private String mNote;

        public ItineraryItem.Builder withStartTime(String startTime){

            return this;
        }

        public ItineraryItem.Builder withEndTime(String endTime){
            return this;
        }


        public ItineraryItem.Builder withStartDate(String startDate){
            return this;
        }

        public ItineraryItem.Builder withEndDate(String endDate){
            return this;
        }

        public ItineraryItem.Builder withPlaceId(String placeId){

            return this;
        }

        public ItineraryItem.Builder withNote(String note){

            return this;
        }

        public ItineraryItem build(){
            return new ItineraryItem(this);
        }


    }


}
