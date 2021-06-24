package org.schooldeveloper.microbenchmark.benchmark.calendars;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.TenThousand;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * For HundredThousand
 * <p>
 * Run complete. Total time: 00:01:37
 * <p>
 * Benchmark                                     Mode  Cnt  Score   Error  Units
 * CalendarNewInstanceVsOneInstance.newInstance    ss   50  0,772 ± 0,033   s/op
 * CalendarNewInstanceVsOneInstance.oneInstance    ss   50  0,434 ± 0,026   s/op
 * CalendarNewInstanceVsOneInstance.withForEach    ss   50  0,453 ± 0,031   s/op
 * <p>
 * For TenThousand
 * <p>
 * Run complete. Total time: 00:00:18
 * <p>
 * Benchmark                                     Mode  Cnt  Score   Error  Units
 * CalendarNewInstanceVsOneInstance.newInstance    ss   50  0,096 ± 0,014   s/op
 * CalendarNewInstanceVsOneInstance.oneInstance    ss   50  0,050 ± 0,007   s/op
 * CalendarNewInstanceVsOneInstance.withForEach    ss   50  0,051 ± 0,006   s/op
 */

public class CalendarNewInstanceVsOneInstance extends TenThousand {
    Date startDateContract;
    List<DateRange> lastSeasons;
    List<DateRange> supplements;

    @Setup
    public void setup() {
        startDateContract = date(LocalDate.of(2018, 01, 01));

        lastSeasons = Arrays.asList(
            new DateRange(date(LocalDate.of(2018, 12, 24)), date(LocalDate.of(2018, 12, 25))),
            new DateRange(date(LocalDate.of(2018, 12, 30)), date(LocalDate.of(2018, 12, 31))));

        supplements = Arrays.asList(new DateRange(date(LocalDate.of(2019, 01, 05)), date(LocalDate.of(2019, 01, 06))),
            new DateRange(date(LocalDate.of(2018, 12, 30)), date(LocalDate.of(2018, 12, 31))),
            new DateRange(date(LocalDate.of(2018, 11, 24)), date(LocalDate.of(2018, 12, 24))));

    }

    @Benchmark
    public boolean newInstance() {
        boolean hasSameSupplementsThatLastSeason = true;
        for (int j = 0; j < lastSeasons.size(); j++) {
            boolean foundSameDate = false;

            Calendar limitDateSupplement = Calendar.getInstance();
            limitDateSupplement.setTime(startDateContract);
            limitDateSupplement.add(Calendar.YEAR, 1);

            for (int k = 0; k < supplements.size(); k++) {

                Calendar startDateSupplement = Calendar.getInstance();
                startDateSupplement.setTime(supplements.get(k).getStartDate());

                //Get only the supplements of the first year.
                if (startDateSupplement.after(limitDateSupplement)) {
                    continue;
                }

                Calendar endDateSupplement = Calendar.getInstance();
                endDateSupplement.setTime(supplements.get(k).getEndDate());

                Calendar startDateLastSeason = Calendar.getInstance();
                startDateLastSeason.setTime(lastSeasons.get(j).getStartDate());

                Calendar endDateLastSeason = Calendar.getInstance();
                endDateLastSeason.setTime(lastSeasons.get(j).getEndDate());

                if (startDateSupplement.get(Calendar.DAY_OF_MONTH) == startDateLastSeason.get(Calendar.DAY_OF_MONTH)
                    && endDateSupplement.get(Calendar.DAY_OF_MONTH) == endDateLastSeason.get(Calendar.DAY_OF_MONTH)) {
                    foundSameDate = true;
                }
            }

            if (!foundSameDate) {
                hasSameSupplementsThatLastSeason = false;
            }
        }
        return hasSameSupplementsThatLastSeason;

    }

    @Benchmark
    public boolean oneInstance() {
        boolean hasSameSupplementsThatLastSeason = true;
        Calendar limitDateSupplement = Calendar.getInstance();
        limitDateSupplement.setTime(startDateContract);
        limitDateSupplement.add(Calendar.YEAR, 1);

        Calendar startDateSupplement = Calendar.getInstance();
        Calendar endDateSupplement = Calendar.getInstance();
        Calendar startDateLastSeason = Calendar.getInstance();
        Calendar endDateLastSeason = Calendar.getInstance();

        for (int j = 0; j < lastSeasons.size(); j++) {
            boolean foundSameDate = false;

            for (int k = 0; k < supplements.size(); k++) {

                startDateSupplement.setTime(supplements.get(k).getStartDate());

                //Get only the supplements of the first year.
                if (startDateSupplement.after(limitDateSupplement)) {
                    continue;
                }

                endDateSupplement.setTime(supplements.get(k).getEndDate());
                startDateLastSeason.setTime(lastSeasons.get(j).getStartDate());
                endDateLastSeason.setTime(lastSeasons.get(j).getEndDate());

                if (startDateSupplement.get(Calendar.DAY_OF_MONTH) == startDateLastSeason.get(Calendar.DAY_OF_MONTH)
                    && endDateSupplement.get(Calendar.DAY_OF_MONTH) == endDateLastSeason.get(Calendar.DAY_OF_MONTH)) {
                    foundSameDate = true;
                }
            }

            if (!foundSameDate) {
                hasSameSupplementsThatLastSeason = false;
            }
        }
        return hasSameSupplementsThatLastSeason;
    }

    @Benchmark
    public boolean oneInstance2() {
        boolean hasSameSupplementsThatLastSeason = true;
        Calendar limitDateSupplement = Calendar.getInstance();
        limitDateSupplement.setTime(startDateContract);
        limitDateSupplement.add(Calendar.YEAR, 1);

        Calendar startDateSupplement = Calendar.getInstance();
        Calendar endDateSupplement = Calendar.getInstance();
        Calendar startDateLastSeason = Calendar.getInstance();
        Calendar endDateLastSeason = Calendar.getInstance();

        for (int j = 0; j < lastSeasons.size(); j++) {
            boolean foundSameDate = false;
            startDateLastSeason.setTime(lastSeasons.get(j).getStartDate());
            endDateLastSeason.setTime(lastSeasons.get(j).getEndDate());

            for (int k = 0; k < supplements.size(); k++) {

                startDateSupplement.setTime(supplements.get(k).getStartDate());

                //Get only the supplements of the first year.
                if (startDateSupplement.after(limitDateSupplement)) {
                    continue;
                }

                endDateSupplement.setTime(supplements.get(k).getEndDate());

                if (startDateSupplement.get(Calendar.DAY_OF_MONTH) == startDateLastSeason.get(Calendar.DAY_OF_MONTH)
                    && endDateSupplement.get(Calendar.DAY_OF_MONTH) == endDateLastSeason.get(Calendar.DAY_OF_MONTH)) {
                    foundSameDate = true;
                }
            }

            if (!foundSameDate) {
                hasSameSupplementsThatLastSeason = false;
            }
        }
        return hasSameSupplementsThatLastSeason;
    }

    @Benchmark
    public boolean withForEach() {
        boolean hasSameSupplementsThatLastSeason = true;
        Calendar limitDateSupplement = Calendar.getInstance();
        limitDateSupplement.setTime(startDateContract);
        limitDateSupplement.add(Calendar.YEAR, 1);

        Calendar startDateSupplement = Calendar.getInstance();
        Calendar endDateSupplement = Calendar.getInstance();
        Calendar startDateLastSeason = Calendar.getInstance();
        Calendar endDateLastSeason = Calendar.getInstance();

        for (DateRange lastSeason : lastSeasons) {
            boolean foundSameDate = false;
            startDateLastSeason.setTime(lastSeason.getStartDate());
            endDateLastSeason.setTime(lastSeason.getEndDate());

            for (DateRange supplement : supplements) {

                startDateSupplement.setTime(supplement.getStartDate());

                //Get only the supplements of the first year.
                if (startDateSupplement.after(limitDateSupplement)) {
                    continue;
                }

                endDateSupplement.setTime(supplement.getEndDate());

                if (startDateSupplement.get(Calendar.DAY_OF_MONTH) == startDateLastSeason.get(Calendar.DAY_OF_MONTH)
                    && endDateSupplement.get(Calendar.DAY_OF_MONTH) == endDateLastSeason.get(Calendar.DAY_OF_MONTH)) {
                    foundSameDate = true;
                }
            }

            if (!foundSameDate) {
                hasSameSupplementsThatLastSeason = false;
            }
        }
        return hasSameSupplementsThatLastSeason;
    }

    @AllArgsConstructor
    @Getter
    static class DateRange {
        Date startDate;
        Date endDate;
    }

    static Date date(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }
}
