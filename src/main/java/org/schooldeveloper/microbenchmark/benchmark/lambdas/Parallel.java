package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Thousand;

/**
 * Created by @SchoolDeveloper on 30/08/2017.
 * Benchmark          Mode  Cnt  Score   Error  Units
 * Parallel.parallel    ss   50  0,199 ± 0,011   s/op
 * Parallel.serial      ss   50  0,175 ± 0,008   s/op
 */
public class Parallel extends Thousand {
    private URL url;

    @Setup
    public void setup() {
        url = GetMaxLengthOfStringLines.class.getClassLoader().getResource("file-text.txt");
    }


    @Benchmark
    public String serial() throws IOException {
        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().reduce((x, y) -> (x.length() > y.length()) ? x : y).orElse(null);
        }
    }

    @Benchmark
    public String parallel() throws IOException {
        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().parallel().reduce((x, y) -> (x.length() > y.length()) ? x : y).orElse(null);
        }

    }
}
