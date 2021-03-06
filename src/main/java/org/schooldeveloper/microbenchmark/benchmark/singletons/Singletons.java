package org.schooldeveloper.microbenchmark.benchmark.singletons;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.benchmark.singletons.clazz.DoubleCheckedLockingSingleton;
import org.schooldeveloper.microbenchmark.benchmark.singletons.clazz.InitializationOnDemandSingleton;
import org.schooldeveloper.microbenchmark.benchmark.singletons.clazz.SynchronizedSingleton;
import org.schooldeveloper.microbenchmark.config.TenMillion;

/**
 * Created by @SchoolDeveloper on 06/04/2019.
 * <p>
 * Benchmark                                Mode  Cnt  Score   Error  Units
 * Singletons.doubleCheckedLocking            ss   50  0,042 ± 0,005   s/op
 * Singletons.initializationOnDemandHolder    ss   50  0,038 ± 0,001   s/op
 * Singletons.synchronizedSingleton           ss   50  0,229 ± 0,003   s/op
 */

public class Singletons extends TenMillion {

    @Benchmark
    public String initializationOnDemandHolder() {
        return InitializationOnDemandSingleton.getInstance().getData();
    }

    @Benchmark
    public String doubleCheckedLocking() {
        return DoubleCheckedLockingSingleton.getInstance().getData();
    }

    @Benchmark
    public String synchronizedSingleton() {
        return SynchronizedSingleton.getInstance().getData();
    }
}
