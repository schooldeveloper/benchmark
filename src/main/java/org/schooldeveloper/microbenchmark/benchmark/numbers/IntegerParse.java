package org.schooldeveloper.microbenchmark.benchmark.numbers;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.schooldeveloper.microbenchmark.config.Millon;

/**
 * Created by @SchoolDeveloper on 05/02/2018.
 */
public class IntegerParse extends Millon {

    @Param({"-1000", "-100", "0", "100", "1000"})
    private String number;

    @Benchmark
    public int parseInt() {
        return Integer.parseInt(number);
    }

    @Benchmark
    public int valueOf() {
        return Integer.valueOf(number);
    }
}
