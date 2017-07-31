package net.estebanrodriguez.apps.classtrip.model.itinerary;

import net.estebanrodriguez.apps.classtrip.model.trip.Place;

public class ItineraryItem {
    private Place mPlace;
    private String mStartDate;
    private String mEndDate;
    private String mStartTime;
    private String mEndTime;
    private String mNote;


    private ItineraryItem() {
    }

    public Place getPlace() {
        return mPlace;
    }

    public void setPlace(Place place) {
        mPlace = place;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String startDate) {
        mStartDate = startDate;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public void setEndDate(String endDate) {
        mEndDate = endDate;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }


}
