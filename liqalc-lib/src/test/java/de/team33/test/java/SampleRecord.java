package de.team33.test.java;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


record SampleRecord(int intValue,
                    String stringValue,
                    Instant instantValue,
                    List<Object> listValue) {

    SampleRecord(int intValue,
                 String stringValue,
                 Instant instantValue,
                 List<Object> listValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.instantValue = instantValue;
        this.listValue = new ArrayList<>(listValue);
    }
}
