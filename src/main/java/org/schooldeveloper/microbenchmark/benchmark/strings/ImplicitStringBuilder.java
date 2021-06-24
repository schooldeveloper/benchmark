package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
public class ImplicitStringBuilder extends Million {
    private int x;

    @Setup
    public void setup() {
        x = 1709;
    }

    @Benchmark
    public String concatPre() {
        return "" + x;
    }

    @Benchmark
    public String concatPost() {
        return x + "";
    }

    @Benchmark
    public String integerToString() {
        return Integer.toString(x);
    }

    @Benchmark
    public String stringValueOf() {
        return String.valueOf(x);
    }
}
