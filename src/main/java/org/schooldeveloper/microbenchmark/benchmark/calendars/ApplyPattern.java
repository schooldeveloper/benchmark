package org.schooldeveloper.microbenchmark.benchmark.calendars;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.TenThousand;

/**
 * For a {@link TenThousand}
 *
 * Run complete. Total time: 00:00:08
 *
 * Benchmark                           Mode  Cnt  Score   Error  Units
 * ApplyPattern.applyLocalizedPattern    ss   50  0,014 ± 0,005   s/op
 * ApplyPattern.applyPattern             ss   50  0,012 ± 0,002   s/op
 * ApplyPattern.staticToString           ss   50  0,011 ± 0,002   s/op
 */
public class ApplyPattern extends TenThousand {
    private static final String PATTERN = "dd/MM/yyyy";
    private static final Date date = new Date();

    @Benchmark
    public void applyPattern() {
        SimpleDateFormat sdf = DateUtils.getDateFormat();
        sdf.applyPattern(PATTERN);
        sdf.format(date);
    }

    @Benchmark
    public void applyLocalizedPattern() {
        SimpleDateFormat sdf = DateUtils.getDateFormat();
        sdf.applyLocalizedPattern(PATTERN);
        sdf.format(date);
    }

    @Benchmark
    public void staticToString() {

        DateUtils.toString(date, PATTERN);
    }

}
