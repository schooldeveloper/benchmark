package org.schooldeveloper.microbenchmark.benchmark.calendars;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.benchmark.calendars.clazz.DateUtils;
import org.schooldeveloper.microbenchmark.config.HundredThousand;

/**
 * For {@link HundredThousand}
 * Run complete. Total time: 00:00:19
 *
 * Benchmark                                    Mode  Cnt  Score   Error  Units
 * DateFormatVsCalendar.calendarDateAndTime       ss   50  0,015 ± 0,002   s/op
 * DateFormatVsCalendar.calendarOnlyTime          ss   50  0,018 ± 0,001   s/op
 * DateFormatVsCalendar.dateFormat                ss   50  0,128 ± 0,005   s/op
 * DateFormatVsCalendar.newCalendarDateAndTime    ss   50  0,035 ± 0,003   s/op
 */

public class DateFormatVsCalendar extends HundredThousand {

    private static final String PATTERN = "dd/MM/yyyy";
    private static final Date date = new Date();

    @Benchmark
    public Date newCalendarDateAndTime() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 29);
        c.set(Calendar.MONTH, Calendar.FEBRUARY);
        c.set(Calendar.YEAR, 2016);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    @Benchmark
    public Date calendarDateAndTime() {

        return DateUtils.toDate(2019, 2, 29);
    }

    @Benchmark
    public Date calendarOnlyTime() {
        Calendar c = DateUtils.getCalendar();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    @Benchmark
    public Date dateFormat() throws ParseException {

        return DateUtils.toDateWithFormat(date, PATTERN);

    }
}
