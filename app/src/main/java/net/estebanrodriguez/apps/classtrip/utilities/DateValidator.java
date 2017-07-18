package net.estebanrodriguez.apps.classtrip.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateValidator {

    public static boolean isStartDateIsSameOrBeforeEndDate(String startDate, String endDate){

        if(!isStartDateSameAsEndDate(startDate, endDate)){
            try {
                return isStartDateBeforeEndDate(startDate, endDate);
            } catch (ParseException e) {
                return false;
            }
        }else return true;
    }

    private static boolean isStartDateSameAsEndDate(String startDate, String endDate){
        return startDate.equals(endDate);
    }

    private static boolean isStartDateBeforeEndDate(String startDate, String endDate) throws ParseException {
        Date start = parseDate(startDate);
        Date end = parseDate(endDate);
        return start.before(end);
    }


    private static Date parseDate(String date) throws ParseException {
            String myFormat = "MM/dd/yy";
            SimpleDateFormat format = new SimpleDateFormat(myFormat, Locale.getDefault());
            return format.parse(date);
    }
}
