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
public class ImplicitStringBuilder {
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
