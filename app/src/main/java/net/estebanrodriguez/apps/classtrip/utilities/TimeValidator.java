package net.estebanrodriguez.apps.classtrip.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeValidator {

    public static boolean isStartTimeBeforeEndTime(String startTime, String endTime){
        try {
            Date start = parseTime(startTime);
            Date end = parseTime(endTime);
            return start.before(end);
        } catch (ParseException e) {
            return false;
        }
    }


    private static Date parseTime(String time) throws ParseException {
        String myFormat ="hh:mm aa";
        SimpleDateFormat format = new SimpleDateFormat(myFormat, Locale.getDefault());
        return format.parse(time);
    }
}
