package org.schooldeveloper.microbenchmark.benchmark.classes;

public class ClassWithNonVirtualMethod {
    private long primitiveValueVar;

    public final void nonVirtualMethod() {
        primitiveValueVar++;
    }
}
