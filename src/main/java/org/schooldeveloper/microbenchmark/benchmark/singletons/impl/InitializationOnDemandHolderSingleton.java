package org.schooldeveloper.microbenchmark.benchmark.singletons.impl;

import lombok.Getter;
import lombok.Setter;

/**
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */
@Getter
@Setter
public final class InitializationOnDemandHolderSingleton {

    private String data;

    private InitializationOnDemandHolderSingleton() {
    }

    public static InitializationOnDemandHolderSingleton getInstance() {
        return InitializationOnDemandHolder.INSTANCE;
    }

    private static class InitializationOnDemandHolder {
        private static final InitializationOnDemandHolderSingleton INSTANCE = new InitializationOnDemandHolderSingleton();
    }
}
