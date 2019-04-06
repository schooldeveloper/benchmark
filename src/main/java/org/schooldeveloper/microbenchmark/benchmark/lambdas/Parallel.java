package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Hundred;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by @SchoolDeveloper on 30/08/2017.
 */
@Slf4j
public class Parallel extends Hundred {

    @Benchmark
    public String serial() throws IOException {
        URL url = BufferedReaderUse.class.getClassLoader().getResource("file-text.txt");

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().reduce((x, y) ->
                (x.length() > y.length()) ? x : y
            ).orElse(null);
        }
    }

    @Benchmark
    public String parallel() throws IOException {
        URL url = BufferedReaderUse.class.getClassLoader().getResource("file-text.txt");
        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().parallel().reduce((x, y) ->
                (x.length() > y.length()) ? x : y).orElse(null);
        }

    }
}
