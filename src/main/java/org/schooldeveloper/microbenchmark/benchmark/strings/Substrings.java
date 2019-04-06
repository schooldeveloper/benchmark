package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@Measurement(batchSize = 1000000, iterations = 20)
@Warmup(batchSize = 1000000, iterations = 10)
@Fork(5)
public class Substrings {

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
