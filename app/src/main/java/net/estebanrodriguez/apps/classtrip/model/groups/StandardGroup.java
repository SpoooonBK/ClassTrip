package net.estebanrodriguez.apps.classtrip.model.groups;

import net.estebanrodriguez.apps.classtrip.model.participants.Participant;

import java.util.ArrayList;
import java.util.List;

public class StandardGroup implements Group {

    private List<Participant> mParticipants;
    private String mName;

    public StandardGroup(String name) {
        mParticipants = new ArrayList<>();
        mName = name;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        mName = name;
    }

    @Override
    public void addParticipant(Participant participant){
        mParticipants.add(participant);
    }

    @Override
    public void removeParticipant(Participant participant){
        if(mParticipants.contains(participant)){
            mParticipants.remove(participant);
        }
    }

    @Override
    public int size(){
        return mParticipants.size();
    }
}
