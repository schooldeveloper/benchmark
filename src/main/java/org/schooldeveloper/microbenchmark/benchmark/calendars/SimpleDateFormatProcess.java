package org.schooldeveloper.microbenchmark.benchmark.calendars;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.HundredThousand;

/**
 * For a {@link org.schooldeveloper.microbenchmark.config.HundredThousand}
 *
 * Run complete. Total time: 00:00:21
 * Benchmark                            Mode  Cnt  Score   Error  Units
 * SimpleDateFormatProcess.calendar       ss   50  0,035 ± 0,006   s/op
 * SimpleDateFormatProcess.instance       ss   50  0,113 ± 0,009   s/op
 * SimpleDateFormatProcess.statically     ss   50  0,027 ± 0,004   s/op
 * SimpleDateFormatProcess.threadLocal    ss   50  0,027 ± 0,004   s/op
 *
 * For {@link org.schooldeveloper.microbenchmark.config.Millon}
 *
 * Run complete. Total time: 00:01:43
 * Benchmark                            Mode  Cnt  Score   Error  Units
 * SimpleDateFormatProcess.calendar       ss   50  0,288 ± 0,019   s/op
 * SimpleDateFormatProcess.instance       ss   50  0,947 ± 0,034   s/op
 * SimpleDateFormatProcess.statically     ss   50  0,241 ± 0,016   s/op
 * SimpleDateFormatProcess.threadLocal    ss   50  0,240 ± 0,016   s/op
 *
 * Created by @SchoolDeveloper on 04/09/2017.
 */
public class SimpleDateFormatProcess extends HundredThousand {
    private static final String PATTERN = "MM";
    private static final Date DATE = new Date();
    @SuppressWarnings("squid:S2885")
    private static final SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);

    @Benchmark
    public String instance() {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        return sdf.format(DATE);
    }

    @Benchmark
    public String statically() {
        return SDF.format(DATE);
    }

    @Benchmark
    public String threadLocal() {
        SimpleDateFormat sdf = DateUtils.getDateFormat();
        return sdf.format(DATE);
    }

    @Benchmark
    public String calendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE);
        return String.valueOf(calendar.get(Calendar.MONTH));
    }
}
