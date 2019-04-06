package org.schooldeveloper.microbenchmark.benchmark.bucles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.TenThousand;

public class Loops extends TenThousand {

    private List<String> strings;

    @Setup
    public void setup() {
        strings = Stream.iterate(1, i -> i + 1).map(i -> "string" + i).limit(10).collect(Collectors.toList());
    }

    @Benchmark
    public String loopFor() {
        String newString = null;
        for (int i = 0; i < strings.size(); i++) {
            newString = strings.get(i) + "loop";
        }
        return newString;
    }

    @Benchmark
    public String loopForWithInitSize() {
        String newString = null;
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            newString = strings.get(i) + "loop";
        }
        return newString;
    }

    @Benchmark
    public String loopForEach() {
        String newString = null;
        for (String string : strings) {
            newString = string + "loop";
        }
        return newString;
    }

}
