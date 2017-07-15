package net.estebanrodriguez.apps.classtrip.model.itinerary;

import java.util.List;

public interface Itinerary {

    List<ItineraryItem> getItineraryItems();
    void addItem();

}
