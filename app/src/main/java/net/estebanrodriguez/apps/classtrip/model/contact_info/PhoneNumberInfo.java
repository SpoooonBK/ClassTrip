package net.estebanrodriguez.apps.classtrip.model.contact_info;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberInfo {

    private List<PhoneNumber> mPhoneNumbers;

    public PhoneNumberInfo() {
        mPhoneNumbers = new ArrayList<>();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber){
        mPhoneNumbers.add(phoneNumber);
    }

    public void removePhoneNumber(PhoneNumber phoneNumber){
        if(mPhoneNumbers.contains(phoneNumber)){
            mPhoneNumbers.remove(phoneNumber);
        }
    }

    public List<PhoneNumber> getPhoneNumbersByType(PhoneNumberType phoneNumberType){
        List<PhoneNumber> phoneNumbersByType = new ArrayList<>();
        for(PhoneNumber phoneNumber: mPhoneNumbers){
            if(phoneNumber.getType() == phoneNumberType){
                phoneNumbersByType.add(phoneNumber);
            }
        }
        return phoneNumbersByType;
    }

    public List<PhoneNumber> getAllPhoneNumbers(){
        return new ArrayList<>(mPhoneNumbers);
    }
}
