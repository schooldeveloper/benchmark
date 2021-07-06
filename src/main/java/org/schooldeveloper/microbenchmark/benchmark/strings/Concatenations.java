package org.schooldeveloper.microbenchmark.benchmark.strings;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Thousand;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 * Benchmark                                      Mode  Cnt   Score    Error  Units
 * Concatenations.apacheStringRepeat                ss   50   0,003 ±  0,002   s/op
 * Concatenations.concat                            ss   50   0,134 ±  0,034   s/op
 * Concatenations.iterateStream                     ss   50   0,031 ±  0,003   s/op
 * Concatenations.joiner                            ss   50   0,025 ±  0,004   s/op
 * Concatenations.operatorPlus                      ss   50   0,128 ±  0,039   s/op
 * Concatenations.stringBuilderAndFor               ss   50   0,007 ±  0,002   s/op
 * Concatenations.stringBuilderAndGenerateStream    ss   50   0,011 ±  0,003   s/op
 * Concatenations.stringBuilderAndIterateStream     ss   50   0,035 ±  0,012   s/op
 * Concatenations.stringRepeat                      ss   50   0,002 ±  0,001   s/op
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
    public String apacheStringRepeat() {
        return StringUtils.repeat(CHAR, MAX);
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
