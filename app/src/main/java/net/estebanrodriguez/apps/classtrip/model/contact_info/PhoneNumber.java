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

    public final PhoneNumberType getType() {
        return mPhoneNumberType;
    }

    public String getName() {
        return mName;
    }

    @Override
    public final String toString() {
        return mPhoneNumber;
    }

}
