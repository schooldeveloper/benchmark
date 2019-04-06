package org.schooldeveloper.microbenchmark.benchmark.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
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
public class HashCodes {

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
