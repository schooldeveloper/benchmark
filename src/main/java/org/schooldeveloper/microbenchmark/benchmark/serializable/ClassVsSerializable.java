package org.schooldeveloper.microbenchmark.benchmark.serializable;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Billon;

/**
 * Created by @SchoolDeveloper on 05/02/2018.
 */
public class ClassVsSerializable extends Billon {

    @Benchmark
    public void normal() {
        new Clazz();
    }

    @Benchmark
    public void serializable() {
        new WithSerializable();
    }
}
