package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
public class HashCodes extends Million {

    private String str1;
    private String str2;

    @Setup
    public void setup() {
        str1 = "лжеотождествление␣электровиолончели"; // same length
        str2 = "электровиолончели␣лжеотождествление"; // same length
    }

    @Benchmark
    public int test1() {
        return str1.hashCode();
    } // 22.6 ± 0.1 ns/op

    @Benchmark
    public int test2() {
        return str2.hashCode();
    } // 0.7 ± 0.1 ns/op
}
