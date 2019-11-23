package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.HundredThousand;

/**
 * Benchmark                              Mode  Cnt  Score   Error  Units
 * DistinctStreamVsCustomImpl.customImpl    ss   50  3,259 ± 0,148   s/op
 * DistinctStreamVsCustomImpl.distinct      ss   50  1,527 ± 0,046   s/op
 */

public class DistinctStreamVsCustomImpl extends HundredThousand {

    private static final Random RANDOM = ThreadLocalRandom.current();
    private List<String> strings;

    @Setup
    public void setup() {
        strings = Stream.iterate(1, i -> RANDOM.nextInt(100)).map(i -> "string" + i).limit(1000).collect(Collectors.toList());
    }

    @Benchmark
    public List<String> distinct() {
        return strings.stream().distinct().collect(Collectors.toList());
    }

    @Benchmark
    public List<String> customImpl() {
        return strings.stream().filter(distinctByKey(String::toString)).collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
