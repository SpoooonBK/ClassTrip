package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;
import net.estebanrodriguez.apps.classtrip.model.itinerary.TripItinerary;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ClassTrip implements Trip {

    private final String mId;
    private String mName;
    private Itinerary mItinerary;

    public ClassTrip(String name) {
        mName = name;
        mId = UUID.randomUUID().toString();
        mItinerary = new TripItinerary();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Itinerary getItinerary() {
        return mItinerary;
    }

    @Override
    public void updateItinerary() {
        
    }


}
