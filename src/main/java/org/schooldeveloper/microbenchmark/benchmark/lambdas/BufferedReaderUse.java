package org.schooldeveloper.microbenchmark.benchmark.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;

import org.openjdk.jmh.annotations.Benchmark;
import org.schooldeveloper.microbenchmark.config.Thousand;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by @SchoolDeveloper on 30/08/2017.
 */
@Slf4j
public class BufferedReaderUse extends Thousand {

    public static final String FILE_TEXT_TXT = "file-text.txt";

    @Benchmark
    public int mapToInt() throws IOException {
        URL url = BufferedReaderUse.class.getClassLoader().getResource(FILE_TEXT_TXT);

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().mapToInt(String::length).max().getAsInt();
        }
    }

    @Benchmark
    public String maxComparing() throws IOException {
        URL url = BufferedReaderUse.class.getClassLoader().getResource(FILE_TEXT_TXT);

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().max(Comparator.comparingInt(String::length)).orElse(null);
        }
    }

    @Benchmark
    public String sorted() throws IOException {
        URL url = BufferedReaderUse.class.getClassLoader().getResource(FILE_TEXT_TXT);

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().sorted((x, y) -> y.length() - x.length()).findFirst().orElse(null);
        }
    }

    @Benchmark
    public String reduce() throws IOException {
        URL url = BufferedReaderUse.class.getClassLoader().getResource(FILE_TEXT_TXT);

        try (FileReader fr = new FileReader(url.getPath()); BufferedReader br = new BufferedReader(fr)) {
            return br.lines().reduce((x, y) -> (x.length() > y.length()) ? x : y).orElse(null);
        }
    }
}
