package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.HundredThousand;

import lombok.Builder;
import lombok.Getter;

/**
 * Benchmark                                            Mode  Cnt  Score   Error  Units
 * GroupingByStreamVsCustomImpl.customImplOldTime         ss   50  2,597 ± 0,051   s/op
 * GroupingByStreamVsCustomImpl.customImplWithIfAbsent    ss   50  2,312 ± 0,071   s/op
 * GroupingByStreamVsCustomImpl.groupingBy                ss   50  2,861 ± 0,034   s/op
 */

public class GroupingByStreamVsCustomImpl extends HundredThousand {

    private List<Data> data;

    @Setup
    public void setup() {
        data = Stream.iterate(1, i -> i + 1).map(i -> Data.builder().id(i).type(i % 2).build()).limit(1000).collect(Collectors.toList());
    }

    @Benchmark
    public Map<Integer, Map<Integer, Data>> groupingBy() {
        return data.stream().collect(Collectors.groupingBy(Data::getType, Collectors.toMap(Data::getId, Function.identity())));
    }

    @Benchmark
    public Map<Integer, Map<Integer, Data>> customImplWithIfAbsent() {
        Map<Integer, Map<Integer, Data>> map = new HashMap<>();
        data.forEach(d -> map.computeIfAbsent(d.getType(), HashMap::new).putIfAbsent(d.getId(), d));
        return map;
    }

    @Benchmark
    public Map<Integer, Map<Integer, Data>> customImplOldTime() {
        Map<Integer, Map<Integer, Data>> map = new HashMap<>();
        for (Data d : data) {
            Map<Integer, Data> subMap = map.get(d.getType());
            if (subMap == null) {
                subMap = new HashMap<>();
                map.put(d.getType(), subMap);
            }
            subMap.put(d.getId(), d);
        }
        return map;
    }

    @Getter
    @Builder
    private static class Data {
        Integer type;
        Integer id;
    }
}
