package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
public class SideEffect extends Million {

    private int x;

    @Setup
    public void setup() {
        x = 1709;
    }

    @Benchmark
    public String concatJust() {
        return "" + x;
    }

    @Benchmark
    public String concatSide() {
        x--;
        return "" + (x++);
    }

    @Benchmark
    public String integerToStringJust() {
        return Integer.toString(x);
    }

    @Benchmark
    public String integerToStringSide() {
        x--;
        return Integer.toString(x++);
    }
}
