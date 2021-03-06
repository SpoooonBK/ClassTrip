package net.estebanrodriguez.apps.classtrip.model.contact_info;


import android.text.TextUtils;

public class Address {

    private String mEmail;
    private final String mAddressLine1;
    private final String mAddressLine2;

    public Address(String email){
        setEmail(email);
        mAddressLine1 = "";
        mAddressLine2 = "";
    }

    public Address(String email, String addressLine1, String addressLine2) {
        setEmail(email);
        mAddressLine1 = addressLine1;
        mAddressLine2 = addressLine2;
    }

    private void setEmail(String email){
        if(isValidEmail(email)){
            mEmail = email;
        } else mEmail = "";
    }

    public String getEmail() {
        return mEmail;
    }


    public String getAddress() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mAddressLine1);
        stringBuilder.append("/n");
        stringBuilder.append(mAddressLine2);
        return stringBuilder.toString();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
