package net.estebanrodriguez.apps.classtrip.model.contact_info;

public final class PhoneNumber {

    private final String mPhoneNumber;
    private final PhoneNumberType mPhoneNumberType;
    private final String mName;

    public PhoneNumber(String name, String phoneNumber, PhoneNumberType phoneNumberType) {
        mName = name;
        mPhoneNumber = phoneNumber;
        mPhoneNumberType = phoneNumberType;
    }

    public PhoneNumberType getType() {
        return mPhoneNumberType;
    }

    public String getContactName() {
        return mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    @Override
    public final String toString() {
        return mPhoneNumber;
    }

}
