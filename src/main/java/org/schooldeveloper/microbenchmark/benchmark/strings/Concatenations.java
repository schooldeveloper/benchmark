package org.schooldeveloper.microbenchmark.benchmark.strings;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Thousand;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
public class Concatenations extends Thousand {
    private static final int MAX = 1024;
    public static final String CHAR = "A";

    @SuppressWarnings("squid:S1643")
    @Benchmark
    public String operatorPlus() {
        String s = "";
        for (int c = 0; c < MAX; c++) {
            s += CHAR;
        }
        return s;
    }

    @Benchmark
    public String concat() {
        String s = "";
        for (int c = 0; c < MAX; c++) {
            s = s.concat(CHAR);
        }
        return s;
    }

    @Benchmark
    public String stringRepeat() {
        return CHAR.repeat(MAX);
    }

    @Benchmark
    public String stringBuilderAndFor() {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < MAX; c++) {
            sb.append(CHAR);
        }
        return sb.toString();
    }

    @Benchmark
    public String joiner() {
        StringJoiner sj = new StringJoiner("");
        for (int c = 0; c < MAX; c++) {
            sj.add(CHAR);
        }
        return sj.toString();
    }

    @Benchmark
    public String iterateStream() {
        return Stream.iterate(CHAR, UnaryOperator.identity()).limit(MAX).collect(Collectors.joining());
    }

    @Benchmark
    public String stringBuilderAndIterateStream() {
        StringBuilder sb = new StringBuilder();
        Stream.iterate(CHAR, UnaryOperator.identity()).limit(MAX).forEach(sb::append);
        return sb.toString();
    }

    @Benchmark
    public String stringBuilderAndGenerateStream() {
        StringBuilder sb = new StringBuilder();
        Stream.generate(() -> CHAR).limit(MAX).forEach(sb::append);
        return sb.toString();
    }


}
