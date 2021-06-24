package org.schooldeveloper.microbenchmark.benchmark.streams;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StreamsUtil {
    public static final String ONEMB = buildString(1024L);
    public static final String EIGHTMB = buildString(1024L * 8);
    public static final String ONEGB = buildString(1024L * 1024L);

    private StreamsUtil() {
    }

    public static InputStream buildInputStream(String buffer) {
        return new ByteArrayInputStream(buffer.getBytes(StandardCharsets.UTF_8));
    }


    private static String buildString(long limit) {
        return Stream.iterate("A", UnaryOperator.identity()).limit(limit).collect(Collectors.joining());
    }
}
