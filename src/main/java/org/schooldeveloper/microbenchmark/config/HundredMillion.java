package org.schooldeveloper.microbenchmark.config;

import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(batchSize = 100000000, iterations = 10)
@Warmup(batchSize = 10000000, iterations = 5)
public class HundredMillion extends Benchmark {
}
