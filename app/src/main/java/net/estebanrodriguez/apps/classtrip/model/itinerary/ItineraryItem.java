package net.estebanrodriguez.apps.classtrip.model.itinerary;

import net.estebanrodriguez.apps.classtrip.model.trip.Place;

public class ItineraryItem {
    private Place mPlace;
    private String mDate;
    private String mTime;
    private String mNote;

    private ItineraryItem() {
    }

    public Place getPlace() {
        return mPlace;
    }

    public void setPlace(Place place) {
        mPlace = place;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }


}
