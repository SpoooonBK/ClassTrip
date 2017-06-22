package net.estebanrodriguez.apps.classtrip.contact_info;

public class PhoneNumber {

    private final String mPhoneNumber;
    private final PhoneNumberType mPhoneNumberType;

    public PhoneNumber(String phoneNumber, PhoneNumberType phoneNumberType) {
        mPhoneNumber = phoneNumber;
        mPhoneNumberType = phoneNumberType;
    }

    public PhoneNumberType getPhoneNumberType() {
        return mPhoneNumberType;
    }

    @Override
    public String toString() {
        return mPhoneNumber;
    }

}
