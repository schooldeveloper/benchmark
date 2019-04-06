package org.schooldeveloper.microbenchmark.benchmark.singletons.impl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;
    private String data;

    private SynchronizedSingleton() {
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
