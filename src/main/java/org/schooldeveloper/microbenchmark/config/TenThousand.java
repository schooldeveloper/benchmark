package org.schooldeveloper.microbenchmark.config;

import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(batchSize = 10000, iterations = 10)
@Warmup(batchSize = 1000, iterations = 5)
public class TenThousand extends Benchmark {
}
