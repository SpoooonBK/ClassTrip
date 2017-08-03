package net.estebanrodriguez.apps.classtrip.data;

import net.estebanrodriguez.apps.classtrip.model.participants.Participant;
import net.estebanrodriguez.apps.classtrip.model.trip.Trip;

public interface DataAccessObject {

    String add(Trip trip);
    void add(Participant participant);
    void update(Participant participant);

}
