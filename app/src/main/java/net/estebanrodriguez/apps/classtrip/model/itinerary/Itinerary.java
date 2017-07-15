package net.estebanrodriguez.apps.classtrip.model.itinerary;

import java.util.Iterator;

public interface Itinerary {

    Iterator<ItineraryItem> iterator();
    void addItem(ItineraryItem item);

}
