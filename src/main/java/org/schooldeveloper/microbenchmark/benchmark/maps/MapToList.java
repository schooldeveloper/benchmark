package org.schooldeveloper.microbenchmark.benchmark.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.TenMillion;

public class MapToList extends TenMillion {

    private Map<Integer, String> map;

    @Setup
    public void setup() {
        map = Stream.iterate(1, i -> i + 1).limit(100).collect(Collectors.toMap(i -> i, i -> "string" + i));
    }

    @Benchmark
    public List<String> withArrayList() {
        return new ArrayList<>(map.values());
    }

    @Benchmark
    public List<String> withStream() {
        return map.values().stream().collect(Collectors.toList());
    }
}
