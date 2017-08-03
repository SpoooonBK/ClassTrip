package net.estebanrodriguez.apps.classtrip.model.participants;

import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;

public class StandardParticipant extends Participant {


    public StandardParticipant(String firstName, String lastName, ContactInfo contactInfo) {
        super(firstName, lastName, contactInfo);
    }

    public StandardParticipant(String id, String firstName, String lastName, ContactInfo contactInfo) {
        super(id, firstName, lastName, contactInfo);
    }
}
