package org.schooldeveloper.microbenchmark.benchmark.conditionals;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.schooldeveloper.microbenchmark.benchmark.conditionals.clazz.Type;
import org.schooldeveloper.microbenchmark.config.Billon;

/**
 * Created by @SchoolDeveloper on 06/04/2019.
 *
 * Benchmark                          (valueType)  Mode  Cnt  Score   Error  Units
 * Conditionals.ifOrElseReturn             STRING    ss   50  5,784 ± 0,029   s/op
 * Conditionals.ifOrElseReturn             NUMBER    ss   50  7,254 ± 0,033   s/op
 * Conditionals.ifReturnOrElseReturn       STRING    ss   50  5,776 ± 0,026   s/op
 * Conditionals.ifReturnOrElseReturn       NUMBER    ss   50  7,094 ± 0,024   s/op
 * Conditionals.valueByDefaultReturn       STRING    ss   50  5,887 ± 0,089   s/op
 * Conditionals.valueByDefaultReturn       NUMBER    ss   50  7,230 ± 0,039   s/op
 */

public class Conditionals extends Billon {

    public static final String STRING = "STRING";
    public static final String NUMBER = "NUMBER";

    @Param({STRING, NUMBER})
    private String valueType;

    @Benchmark
    public Type valueByDefaultReturn() {
        Type type = Type.STRING;

        if (NUMBER.equals(valueType)) {
            type = Type.INTEGER;
        }
        return type;

    }

    @Benchmark
    public Type ifReturnOrElseReturn() {

        if (NUMBER.equals(valueType)) {
            return Type.INTEGER;
        } else {
            return Type.STRING;
        }
    }

    @Benchmark
    public Type ifOrElseReturn() {

        Type type;

        if (NUMBER.equals(valueType)) {
            type = Type.INTEGER;
        } else {
            type = Type.STRING;
        }
        return type;
    }
}
