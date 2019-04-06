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
public class SideEffect {

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
