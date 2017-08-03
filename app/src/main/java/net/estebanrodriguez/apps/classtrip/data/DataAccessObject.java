package net.estebanrodriguez.apps.classtrip.data;

import net.estebanrodriguez.apps.classtrip.model.participants.Participant;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

public interface DataAccessObject {

    public void add(Trip trip);
    public void add(Participant participant);

}
