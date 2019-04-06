package org.schooldeveloper.microbenchmark.benchmark.calendars.clazz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    private static final ThreadLocal<GregorianCalendar> GREGORIAN_CALENDAR = ThreadLocal.withInitial(GregorianCalendar::new);

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT = ThreadLocal.withInitial(SimpleDateFormat::new);

    private DateUtils() {
    }

    public static GregorianCalendar getCalendar() {
        return GREGORIAN_CALENDAR.get();
    }

    public static SimpleDateFormat getDateFormat() {
        return SIMPLE_DATE_FORMAT.get();
    }

    public static Date toDate(int year, int month, int dayOfMonth) {
        Calendar c = GREGORIAN_CALENDAR.get();
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static String toString(Date date, String pattern) {
        SimpleDateFormat sdf = SIMPLE_DATE_FORMAT.get();
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static Date toDateWithFormat(Date date, String pattern) throws ParseException {
        SimpleDateFormat sdf = SIMPLE_DATE_FORMAT.get();
        sdf.applyPattern(pattern);
        String string = sdf.format(date);
        return sdf.parse(string);
    }

}
