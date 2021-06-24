package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Thousand;

/**
 * Created by @SchoolDeveloper on 30/08/2017.
 * Benchmark                       Mode  Cnt  Score   Error  Units
 * BufferedReaderUse.mapToInt        ss   50  0,183 ± 0,012   s/op
 * BufferedReaderUse.maxComparing    ss   50  0,176 ± 0,009   s/op
 * BufferedReaderUse.reduce          ss   50  0,181 ± 0,012   s/op
 * BufferedReaderUse.sorted          ss   50  0,175 ± 0,007   s/op
 */
public class GetMaxLengthOfStringLines extends Thousand {

    public static final Comparator<String> COMPARATOR = Comparator.comparingInt(String::length);
    private URL url;

    @Setup
    public void setup() {
        url = GetMaxLengthOfStringLines.class.getClassLoader().getResource("file-text.txt");
    }

    @Benchmark
    public int mapToInt() throws IOException {

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().mapToInt(String::length).max().orElseThrow();
        }
    }

    @Benchmark
    public int maxComparing() throws IOException {

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().max(COMPARATOR).map(String::length).orElseThrow();
        }
    }

    @Benchmark
    public int sorted() throws IOException {

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().map(String::length).sorted().findFirst().orElseThrow();
        }
    }

    @Benchmark
    public int reduce() throws IOException {

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().map(String::length).reduce(0, Integer::max);
        }
    }
}
