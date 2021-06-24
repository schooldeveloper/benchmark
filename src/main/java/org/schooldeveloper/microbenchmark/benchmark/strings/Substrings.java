package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
public class Substrings extends Million {

    @Param({"0", "30", "60", "90", "120"})
    int limit;
    String str;

    @SuppressWarnings("squid:S1192")
    @Setup
    public void setup() {
        str = " JokerConf ␣ 2014: ␣ Why␣So␣ Serious ?␣" +
                " JokerConf ␣ 2014: ␣ Why ␣So␣ Serious ?␣" +
                " JokerConf ␣ 2014: ␣ Why ␣So␣ Serious ?␣" +
                " JokerConf ␣ 2014: ␣ Why ␣So␣ Serious ?␣";
    }

    @Benchmark
    public String head() {
        return str.substring(limit);
    }

    @Benchmark
    public String tail() {
        return str.substring(0, limit);
    }
}
