package net.estebanrodriguez.apps.classtrip.model.groups;

import net.estebanrodriguez.apps.classtrip.model.participants.Participant;

public interface  Group {

    public String getName();

    public void setName(String name);

    public void add(Participant participant);

    public void remove(Participant participant);

    public int size();
}
