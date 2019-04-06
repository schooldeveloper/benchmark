package org.schooldeveloper.microbenchmark.benchmark.singletons.clazz;

import lombok.Getter;
import lombok.Setter;

/**
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */
@Getter
@Setter
public final class InitializationOnDemandSingleton {

    private String data;

    private InitializationOnDemandSingleton() {
    }

    public static InitializationOnDemandSingleton getInstance() {
        return InitializationOnDemandHolder.INSTANCE;
    }

    private static class InitializationOnDemandHolder {
        private static final InitializationOnDemandSingleton INSTANCE = new InitializationOnDemandSingleton();
    }
}
