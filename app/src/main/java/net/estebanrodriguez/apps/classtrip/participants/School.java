package net.estebanrodriguez.apps.classtrip.participants;

import net.estebanrodriguez.apps.classtrip.contact_info.ContactInfo;

public class School extends Participant {
    public School(String name, ContactInfo contactInfo) {
        super(name, "", contactInfo, AccessType.SCHOOL);
    }
}
