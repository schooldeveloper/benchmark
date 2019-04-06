package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Thousand;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by @SchoolDeveloper on 30/08/2017.
 */
@Slf4j
public class CollectionsVsStreams extends Thousand {
    @Param({"1", "5", "10", "100"})
    private int limit;

    private List<Integer> integers;

    @Setup
    public void setup() {
        integers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < limit; i++) {
            integers.add(r.nextInt(limit));
        }
    }

    @Benchmark
    public Integer collection() {
        return Collections.max(integers);
    }

    @Benchmark
    public Integer stream() {
        return integers.stream().max(Integer::compareTo).orElse(null);
    }

    @Benchmark
    public Integer parallel() {
        return integers.stream().parallel().max(Integer::compareTo).orElse(null);
    }
}
