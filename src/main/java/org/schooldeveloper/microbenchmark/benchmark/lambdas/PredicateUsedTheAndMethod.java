package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.HundredMillion;

import lombok.Builder;
import lombok.Data;

public class PredicateUsedTheAndMethod extends HundredMillion {

    public static final String STRING = "string";
    private static final Predicate<Entity> BY_STRING = e -> STRING.equals(e.getString());
    private static final Predicate<Entity> BY_INTEGER = e -> Integer.MIN_VALUE == e.getInteger();
    private static final Predicate<Entity> BY_BOOLEAN = e -> Boolean.TRUE.equals(e.getString());

    private static final Predicate<Entity> ALL_FILTER_AND = BY_STRING.and(BY_INTEGER).and(BY_BOOLEAN);
    private static final Predicate<Entity> ALL_FILTER_AND_INNER = BY_STRING.and(BY_INTEGER.and(BY_BOOLEAN));
    private static final Predicate<Entity> ALL_FILTER_AND_INLINE =
            e -> STRING.equals(e.getString()) && Integer.MIN_VALUE == e.getInteger() && Boolean.TRUE.equals(e.getString());

    private List<Entity> entities;

    @Setup
    public void setup() {
        Entity e1 = Entity.builder().string("").integer(Integer.MAX_VALUE).check(Boolean.TRUE).build();
        Entity e2 = Entity.builder().string(STRING).integer(Integer.MIN_VALUE).check(Boolean.TRUE).build();
        Entity e3 = Entity.builder().string(STRING).integer(Integer.MAX_VALUE).check(Boolean.FALSE).build();
        entities = Arrays.asList(e1, e2, e3);
    }

    @Benchmark
    public List<Entity> filterUsedTheAndMethod() {
        return entities.stream().filter(ALL_FILTER_AND).collect(Collectors.toList());
    }

    @Benchmark
    public List<Entity> filterUsedTheAndMethodInner() {
        return entities.stream().filter(ALL_FILTER_AND_INNER).collect(Collectors.toList());
    }

    @Benchmark
    public List<Entity> filterUsedTheAndMethodInline() {
        return entities.stream().filter(ALL_FILTER_AND_INLINE).collect(Collectors.toList());
    }

    @Benchmark
    public List<Entity> filterUsedPredicateLocal() {

        return
            entities.stream().filter(e -> STRING.equals(e.getString()) && Integer.MIN_VALUE == e.getInteger() && Boolean.TRUE.equals(e.getString()))
                .collect(Collectors.toList());
    }

    @Data
    @Builder
    public static class Entity {
        private String string;
        private Integer integer;
        private boolean check;
    }
}
