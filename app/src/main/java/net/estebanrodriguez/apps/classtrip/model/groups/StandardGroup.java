package net.estebanrodriguez.apps.classtrip.model.groups;

import net.estebanrodriguez.apps.classtrip.model.participants.Participant;

import java.util.ArrayList;
import java.util.List;

public class StandardGroup implements Group {

    private List<String> mParticipantIds;
    private List<String> mLeaderIds;
    private List<String> mChaperoneIds;
    private List<String> mOrganizerIds;
    private String mName;
    private static String ALL_PARTICIPANTS = "all_participants";


    public StandardGroup(){
        this(ALL_PARTICIPANTS);
    }

    public StandardGroup(String name) {
        mParticipantIds = new ArrayList<>();
        mChaperoneIds = new ArrayList<>();
        mOrganizerIds = new ArrayList<>();
        mLeaderIds = new ArrayList<>();
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
    public void add(Participant participant){

        String id = participant.getID();

        switch (participant.getAccessType()){

            case SCHOOL:
                break;
            case ORGANIZER:
                mOrganizerIds.add(id);
                break;
            case LEADER:
                mLeaderIds.add(id);
                break;
            case CHAPERONE:
                mChaperoneIds.add(id);
                break;
            case PARTICIPANT:
                mParticipantIds.add(id);
                break;
        }

        mParticipantIds.add(participant.getID());
    }

    @Override
    public void remove(Participant participant){
        if(mParticipantIds.contains(participant)){
            mParticipantIds.remove(participant);
        }
    }

    @Override
    public int size(){
        return mParticipantIds.size();
    }
}
