package org.schooldeveloper.microbenchmark.benchmark.classes;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Billon;

/**
 * For a {@link org.schooldeveloper.microbenchmark.config.HundredMillon}
 * Run complete. Total time: 00:00:36
 * Benchmark                                   Mode  Cnt  Score   Error  Units
 * StaticVsInstance.classWithNonVirtualMethod    ss   50  0,188 ± 0,002   s/op
 * StaticVsInstance.classWithStaticMethod        ss   50  0,198 ± 0,003   s/op
 * StaticVsInstance.classWithVirtualMethod       ss   50  0,188 ± 0,002   s/op
 *
 * For a {@link org.schooldeveloper.microbenchmark.config.Billon}:
 *
 * Run complete. Total time: 00:05:08
 * Benchmark                                   Mode  Cnt  Score   Error  Units
 * StaticVsInstance.classWithNonVirtualMethod    ss   50  1,874 ± 0,013   s/op
 * StaticVsInstance.classWithStaticMethod        ss   50  1,973 ± 0,023   s/op
 * StaticVsInstance.classWithVirtualMethod       ss   50  1,897 ± 0,023   s/op
 */

public class StaticVsInstance extends Billon {

    private ClassWithVirtualMethod classWithVirtualMethod;
    private ClassWithNonVirtualMethod classWithNonVirtualMethod;

    @Setup
    public void setup() {
        classWithVirtualMethod = new ClassWithVirtualMethod();
        classWithNonVirtualMethod = new ClassWithNonVirtualMethod();
    }

    @Benchmark
    public void classWithVirtualMethod() {
        classWithVirtualMethod.virtualMethod();
    }

    @Benchmark
    public void classWithNonVirtualMethod() {
        classWithNonVirtualMethod.nonVirtualMethod();
    }

    @Benchmark
    public void classWithStaticMethod() {
        ClassWithStaticMethod.staticMethod();
    }

}
