package org.schooldeveloper.microbenchmark.benchmark.classes;

public class ClassWithStaticMethod {
    private static long staticVar;

    private ClassWithStaticMethod() {
    }

    public static void staticMethod() {
        staticVar++;
    }
}
