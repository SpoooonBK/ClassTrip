package net.estebanrodriguez.apps.classtrip.model.participants;

import net.estebanrodriguez.apps.classtrip.model.contact_info.ContactInfo;

public class School extends Participant {
    public School(String name, ContactInfo contactInfo) {
        super(name, "", contactInfo, AccessType.SCHOOL);
    }
}
