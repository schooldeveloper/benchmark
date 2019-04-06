package org.schooldeveloper.microbenchmark.benchmark.strings;

import java.util.StringJoiner;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Thousand;

/**
 * Created by @SchoolDeveloper on 14/08/2017.
 */
public class Concatenations extends Thousand {
    private static final int MAX = 1000;

    @SuppressWarnings("squid:S1643")
    @Benchmark
    public String operatorPlus() {
        String s = " Foo";
        for (int c = 0; c < MAX; c++) {
            s += " Bar";
        }
        return s;
    }

    @Benchmark
    public String concat() {
        String s = " Foo";
        for (int c = 0; c < MAX; c++) {
            s = s.concat(" Bar");
        }
        return s;
    }

    @Benchmark
    public String builder() {
        StringBuilder sb = new StringBuilder(" Foo");
        for (int c = 0; c < MAX; c++) {
            sb.append(" Bar");
        }
        return sb.toString();
    }

    @Benchmark
    public String joiner() {
        StringJoiner sj = new StringJoiner(" ");
        for (int c = 0; c < MAX; c++) {
            sj.add("Bar");
        }
        return sj.toString();
    }

}
