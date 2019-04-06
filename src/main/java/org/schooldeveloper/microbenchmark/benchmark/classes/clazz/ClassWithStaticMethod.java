package org.schooldeveloper.microbenchmark.benchmark.classes.clazz;

public class ClassWithStaticMethod {
    private static long staticVar;

    private ClassWithStaticMethod() {
    }

    public static void staticMethod() {
        staticVar++;
    }
}
