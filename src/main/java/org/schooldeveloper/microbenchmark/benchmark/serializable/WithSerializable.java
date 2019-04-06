package org.schooldeveloper.microbenchmark.benchmark.serializable;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by @SchoolDeveloper on 05/02/2018.
 */
@Data
public class WithSerializable implements Serializable {
    private int sequence;
    private String string;
    private Integer integer;
}
