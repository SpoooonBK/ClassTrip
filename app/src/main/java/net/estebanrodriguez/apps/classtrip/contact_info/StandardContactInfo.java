package net.estebanrodriguez.apps.classtrip.contact_info;


public class StandardContactInfo implements ContactInfo {

    private final Address mAddress;
    private final PhoneNumberInfo mPhoneNumberInfo;

    public StandardContactInfo(Address address, PhoneNumberInfo phoneNumberInfo) {
        mAddress = address;
        mPhoneNumberInfo = phoneNumberInfo;
    }

    @Override
    public PhoneNumberInfo getPhoneNumbers() {
        return null;
    }

    @Override
    public String getAddress() {
    return mAddress.getAddress();
    }

    @Override
    public String getEmails() {
        return mAddress.getEmail();
    }


}
