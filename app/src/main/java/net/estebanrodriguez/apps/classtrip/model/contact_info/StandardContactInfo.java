package net.estebanrodriguez.apps.classtrip.model.contact_info;


import java.util.List;

public class StandardContactInfo implements ContactInfo {

    private final Address mAddress;
    private final PhoneNumberInfo mPhoneNumberInfo;

    public StandardContactInfo(Address address, PhoneNumberInfo phoneNumberInfo) {
        mAddress = address;
        mPhoneNumberInfo = phoneNumberInfo;
    }

    @Override
    public List<PhoneNumber> getPhoneNumbers() {
        return mPhoneNumberInfo.getAllPhoneNumbers();
    }

    @Override
    public String getAddress() {
    return mAddress.getAddress();
    }

    @Override
    public String getEmail() {
        return mAddress.getEmail();
    }


}
