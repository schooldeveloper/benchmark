package org.schooldeveloper.microbenchmark.config;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Created by @SchoolDeveloper on 16/08/2017.
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@Measurement(batchSize = 100, iterations = 10)
@Warmup(batchSize = 10, iterations = 5)
@Fork(5)
public class Hundred {
}
