package org.schooldeveloper.microbenchmark.config;

import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Created by @SchoolDeveloper on 16/08/2017.
 */

@Measurement(batchSize = 1000000, iterations = 10)
@Warmup(batchSize = 100000, iterations = 5)
public class Million extends Benchmark {
}
