package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Created by @SchoolDeveloper on 16/08/2017.
 * <p>
 * Benchmark                                                                                                                                 (text)  Mode  Cnt  Score    Error  Units
 * CharAtVsToCharArray.charAt                                                                                                                     1    ss  100  0,006 ±  0,001   s/op
 * CharAtVsToCharArray.charAt                                                                                                            0123456789    ss  100  0,009 ±  0,001   s/op
 * CharAtVsToCharArray.charAt                  0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789    ss  100  0,036 ±  0,001   s/op
 * CharAtVsToCharArray.toCharArray                                                                                                                1    ss  100  0,012 ±  0,001   s/op
 * CharAtVsToCharArray.toCharArray                                                                                                       0123456789    ss  100  0,019 ±  0,002   s/op
 * CharAtVsToCharArray.toCharArray             0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789    ss  100  0,058 ±  0,007   s/op
 * CharAtVsToCharArray.toCharArrayWithForeach                                                                                                     1    ss  100  0,012 ±  0,001   s/op
 * CharAtVsToCharArray.toCharArrayWithForeach                                                                                            0123456789    ss  100  0,019 ±  0,002   s/op
 * CharAtVsToCharArray.toCharArrayWithForeach  0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789    ss  100  0,053 ±  0,005   s/op
 */
public class CharAtVsToCharArray extends Million {
    @Param({"1", "0123456789", "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"})
    private String text;

    @Benchmark
    public int charAt() {
        int r = 0;
        for (int c = 0; c < text.length(); c++) {
            r += text.charAt(c);
        }
        return r;
    }

    @Benchmark
    public int toCharArray() {
        int r = 0;
        char[] chars = text.toCharArray();
        for (int c = 0; c < chars.length; c++) {
            r += chars[c];
        }
        return r;
    }

    @Benchmark
    public int toCharArrayWithForeach() {
        int r = 0;
        char[] chars = text.toCharArray();
        for (int c : chars) {
            r += c;
        }
        return r;
    }
}
