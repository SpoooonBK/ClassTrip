package net.estebanrodriguez.apps.classtrip.model.trip;

import net.estebanrodriguez.apps.classtrip.model.itinerary.Itinerary;

import java.util.List;

public interface Trip {

    String getId();
    String getName();
    Itinerary getItinerary();
    void updateItinerary();
}
