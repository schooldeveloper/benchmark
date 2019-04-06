package org.schooldeveloper.microbenchmark.benchmark.singletons.impl;

import lombok.Getter;
import lombok.Setter;

/**
 * https://en.wikipedia.org/wiki/Double-checked_locking
 */
@Getter
@Setter
public final class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;
    private String data;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        DoubleCheckedLockingSingleton helper = instance;
        //first checked
        if (helper == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                //second checked
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
                helper = instance;
            }
        }
        return helper;
    }
}
