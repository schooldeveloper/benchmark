package org.schooldeveloper.microbenchmark.benchmark.serializable.clazz;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by @SchoolDeveloper on 05/02/2018.
 */
@Data
public class Zerializable implements Serializable {
    private int sequence;
    private String string;
    private Integer integer;
}
