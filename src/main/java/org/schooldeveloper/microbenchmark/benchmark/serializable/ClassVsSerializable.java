package org.schooldeveloper.microbenchmark.benchmark.serializable;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.benchmark.serializable.clazz.Clazz;
import org.schooldeveloper.microbenchmark.benchmark.serializable.clazz.Zerializable;
import org.schooldeveloper.microbenchmark.config.Billon;

/**
 * Created by @SchoolDeveloper on 05/02/2018.
 *
 * Benchmark                         Mode  Cnt  Score   Error  Units
 * ClassVsSerializable.clazz           ss   50  0,212 ± 0,003   s/op
 * ClassVsSerializable.serializable    ss   50  0,217 ± 0,007   s/op
 */
public class ClassVsSerializable extends Billon {

    @Benchmark
    public void clazz() {
        new Clazz();
    }

    @Benchmark
    public void serializable() {
        new Zerializable();
    }
}
