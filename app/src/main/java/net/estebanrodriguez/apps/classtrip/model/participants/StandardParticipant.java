package net.estebanrodriguez.apps.classtrip.model.participants;

import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;

public class StandardParticipant extends Participant {

    public StandardParticipant(String firstName, String lastName, ContactInfo contactInfo, AccessType accessType) {
        super(firstName, lastName, contactInfo, accessType);
    }
}
