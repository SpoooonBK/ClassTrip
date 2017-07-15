package net.estebanrodriguez.apps.classtrip.model.itinerary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TripItinerary implements Itinerary {

    private List<ItineraryItem> mItineraryItems;

    public TripItinerary() {
        mItineraryItems = new ArrayList<>();
    }

    @Override
    public Iterator<ItineraryItem> iterator() {
        return mItineraryItems.iterator();
    }

    @Override
    public void addItem(ItineraryItem item) {
        mItineraryItems.add(item);
    }
}
