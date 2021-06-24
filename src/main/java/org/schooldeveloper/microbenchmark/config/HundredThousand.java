package org.schooldeveloper.microbenchmark.config;

import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(batchSize = 100000, iterations = 10)
@Warmup(batchSize = 10000, iterations = 5)
public class HundredThousand extends Benchmark {
}
