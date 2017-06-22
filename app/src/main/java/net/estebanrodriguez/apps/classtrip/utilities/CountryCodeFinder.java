package net.estebanrodriguez.apps.classtrip.utilities;

import android.content.Context;
import android.telephony.TelephonyManager;

import net.estebanrodriguez.apps.classtrip.model.exceptions.CountryISONotFoundException;

import java.util.Locale;


public class CountryCodeFinder {



    public CountryCodeFinder(){
    }


    public String getCountryISO(Context context){
        try {
            return getCountryISOFromTelephony(context);
        } catch (CountryISONotFoundException e) {
            return getCountryISOifTelephonyFails();
        }
    }

    private String getCountryISOifTelephonyFails(){
        try {
            return getCountryISOFromLocale();
        } catch (CountryISONotFoundException e) {
            return getCountyDefaultCountryISO();
        }
    }

    private String getCountryISOFromTelephony(Context context) throws CountryISONotFoundException {
        TelephonyManager telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String iso = telephonyManager.getSimCountryIso();
        if(iso != null){
            return iso;
        }else throw new CountryISONotFoundException("Code not found");
    }

    private String getCountryISOFromLocale() throws CountryISONotFoundException {
        String iso = Locale.getDefault().getCountry();
        if(iso != null){
            return iso;
        }else throw new CountryISONotFoundException("Code not found");
    }

    private String getCountyDefaultCountryISO(){
        return "US";
    }
}
