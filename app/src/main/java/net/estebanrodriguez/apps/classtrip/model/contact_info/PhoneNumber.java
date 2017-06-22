package net.estebanrodriguez.apps.classtrip.model.contact_info;

public final class PhoneNumber {

    private final String mPhoneNumber;
    private final PhoneNumberType mPhoneNumberType;
    private String name;

    public PhoneNumber(String phoneNumber, PhoneNumberType phoneNumberType) {
        mPhoneNumber = phoneNumber;
        mPhoneNumberType = phoneNumberType;
    }

    public final PhoneNumberType getType() {
        return mPhoneNumberType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return mPhoneNumber;
    }

}
