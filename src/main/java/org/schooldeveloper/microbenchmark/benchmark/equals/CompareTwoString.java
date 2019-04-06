package org.schooldeveloper.microbenchmark.benchmark.equals;

import java.util.Arrays;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Billon;

/**
 * Created by @SchoolDeveloper on 16/08/2017.
 */
public class CompareTwoString extends Billon {

    private String string = "string";
    private String strings = "strings";
    private List<String> list = Arrays.asList(string, strings);

    private String newString = "newString";

    @Benchmark
    public boolean twoString() {
        return string != null && !string.equals(newString) && !strings.equals(newString);
    }

    @Benchmark
    public boolean twoString2() {
        return string != null && !string.equals(newString) && strings != null && !strings.equals(newString);
    }

    @Benchmark
    public boolean list() {
        return !list.contains(newString);
    }
}
