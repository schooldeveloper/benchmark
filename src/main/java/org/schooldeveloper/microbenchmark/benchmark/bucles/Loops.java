package org.schooldeveloper.microbenchmark.benchmark.bucles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Million;

public class Loops extends Million {

    private List<String> strings;

    @Setup
    public void setup() {
        strings = Stream.iterate(1, i -> i + 1).map(i -> "string" + i).limit(10).collect(Collectors.toList());
    }

    @Benchmark
    public String loopForOldS() {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            newString.append(strings.get(i));
        }
        return newString.toString();
    }

    @Benchmark
    public void measureName() {
    }

    @Benchmark
    public String loopForOLdSWithInitSize() {
        StringBuilder newString = new StringBuilder();
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            newString.append(strings.get(i));
        }
        return newString.toString();
    }

    @Benchmark
    public String loopForEach() {
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
