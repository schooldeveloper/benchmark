package org.schooldeveloper.microbenchmark.benchmark.bucles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Million;

/**
 * Benchmark                       Mode  Cnt  Score   Error  Units
 * Loops.forEach                     ss   50  0,234 ± 0,013   s/op
 * Loops.forOldSchool                ss   50  0,225 ± 0,013   s/op
 * Loops.forOldSchoolWithInitSize    ss   50  0,241 ± 0,015   s/op
 * Loops.streamForEach               ss   50  0,247 ± 0,017   s/op
 */
public class Loops extends Million {

    private List<String> strings;

    @Setup
    public void setup() {
        strings = Stream.iterate(1, i -> i + 1).map(i -> "string" + i).limit(10).collect(Collectors.toList());
    }

    @Benchmark
    public String forOldSchool() {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            newString.append(strings.get(i));
        }
        return newString.toString();
    }

    @Benchmark
    public String forOldSchoolWithInitSize() {
        StringBuilder newString = new StringBuilder();
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            newString.append(strings.get(i));
        }
        return newString.toString();
    }

    @Benchmark
    public String forEach() {
        StringBuilder newString = new StringBuilder();
        for (String string : strings) {
            newString.append(string);
        }
        return newString.toString();
    }

    @Benchmark
    public String streamForEach() {
        StringBuilder newString = new StringBuilder();
        strings.forEach(newString::append);
        return newString.toString();
    }

}
