package net.estebanrodriguez.apps.classtrip.contact_info;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberInfo {

    private Map<PhoneNumberType, PhoneNumber> mPhoneNumbers = new HashMap<>();

    public PhoneNumberInfo() {
    }

    public String getPhoneNumber(PhoneNumberType phoneNumberType){
        if(mPhoneNumbers.containsKey(phoneNumberType)){
            return mPhoneNumbers.get(phoneNumberType).toString();
        }else return "";
    }
}
