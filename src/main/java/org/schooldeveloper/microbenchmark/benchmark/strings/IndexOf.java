package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Created by @SchoolDeveloper on 21/01/2022.
 *
 * Benchmark                                  Mode  Cnt  Score    Error  Units
 * IndexOf.findStringWithNullByCharNull         ss   50  0,015 ±  0,002   s/op
 * IndexOf.findStringWithNullByStringNull       ss   50  0,009 ±  0,001   s/op
 * IndexOf.findStringWithoutNullByCharNull      ss   50  0,024 ±  0,001   s/op
 * IndexOf.findStringWithoutNullByStringNull    ss   50  0,013 ±  0,001   s/op
 */

public class IndexOf extends Million {
    private static final char charNull = '\0';
    private static final String stringNull = "\0";
    private static final String stringWithoutNull = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String stringWithNull = "ABCDEFGHIJKLMNOPQRSTUVWXY\0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Benchmark
    public int findStringWithNullByCharNull() {
        return stringWithNull.indexOf(charNull);
    }

    @Benchmark
    public int findStringWithoutNullByCharNull() {
        return stringWithoutNull.indexOf(charNull);
    }

    @Benchmark
    public int findStringWithNullByStringNull() {
        return stringWithNull.indexOf(stringNull);
    }

    @Benchmark
    public int findStringWithoutNullByStringNull() {
        return stringWithoutNull.indexOf(stringNull);
    }
}
