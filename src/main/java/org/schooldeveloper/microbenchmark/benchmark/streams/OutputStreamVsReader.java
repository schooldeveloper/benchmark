package org.schooldeveloper.microbenchmark.benchmark.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.schooldeveloper.microbenchmark.config.Thousand;

/**
 * Created by @SchoolDeveloper on 30/05/2021.
 * Benchmark                             Mode  Cnt  Score    Error  Units
 * OutputStreamVsReader.outputStream1Gb    ss   50  0,001 ±  0,001   s/op
 * OutputStreamVsReader.outputStream1Mb    ss   50  0,001 ±  0,001   s/op
 * OutputStreamVsReader.outputStream8Mb    ss   50  0,001 ±  0,001   s/op
 * OutputStreamVsReader.reader1Gb          ss   50  0,016 ±  0,004   s/op
 * OutputStreamVsReader.reader1Mb          ss   50  0,018 ±  0,005   s/op
 * OutputStreamVsReader.reader8Mb          ss   50  0,014 ±  0,003   s/op
 */
public class OutputStreamVsReader extends Thousand {

    private InputStream inputStream1Mb;
    private Reader reader1Mb;
    private InputStream inputStream8Mb;
    private Reader reader8Mb;
    private InputStream inputStream1Gb;
    private Reader reader1Gb;

    @Setup
    public void setup() {
        inputStream1Mb = StreamsUtil.buildInputStream(StreamsUtil.ONEMB);
        reader1Mb = new InputStreamReader(inputStream1Mb, StandardCharsets.UTF_8);
        inputStream8Mb = StreamsUtil.buildInputStream(StreamsUtil.EIGHTMB);
        reader8Mb = new InputStreamReader(inputStream8Mb, StandardCharsets.UTF_8);
        inputStream1Gb = StreamsUtil.buildInputStream(StreamsUtil.ONEGB);
        reader1Gb = new InputStreamReader(inputStream1Gb, StandardCharsets.UTF_8);
    }

    @Benchmark
    public String outputStream1Mb() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        inputStream1Mb.transferTo(baos);
        return baos.toString();
    }


    @Benchmark
    public String outputStream8Mb() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        inputStream8Mb.transferTo(baos);
        return baos.toString();
    }

    @Benchmark
    public String outputStream1Gb() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        inputStream1Gb.transferTo(baos);
        return baos.toString();
    }

    @Benchmark
    public String reader1Mb() throws IOException {
        StringWriter sw = new StringWriter();
        reader1Mb.transferTo(sw);
        return sw.toString();
    }


    @Benchmark
    public String reader8Mb() throws IOException {
        StringWriter sw = new StringWriter();
        reader8Mb.transferTo(sw);
        return sw.toString();
    }

    @Benchmark
    public String reader1Gb() throws IOException {
        StringWriter sw = new StringWriter();
        reader1Gb.transferTo(sw);
        return sw.toString();
    }
}
