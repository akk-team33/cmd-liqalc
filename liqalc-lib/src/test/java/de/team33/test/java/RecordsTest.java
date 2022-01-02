package de.team33.test.java;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class RecordsTest {

    @Test
    final void getDeclaredFields() {
        final Set<String> expected = Set.of(
                "private final java.lang.String de.team33.test.java.SampleRecord.stringValue",
                "private final int de.team33.test.java.SampleRecord.intValue",
                "private final java.time.Instant de.team33.test.java.SampleRecord.instantValue",
                "private final java.util.List de.team33.test.java.SampleRecord.listValue");
        final Set<String> fields = Stream.of(SampleRecord.class.getDeclaredFields())
                                          .map(Field::toString)
                                          .collect(Collectors.toCollection(HashSet::new));
        // fields.removeAll(expected);
        // assertEquals(Set.of(), fields);
        assertEquals(expected, fields);
    }

    @Test
    final void getDeclaredMethods() {
        final Set<String> expected = Set.of(
                "public int de.team33.test.java.SampleRecord.intValue()",
                "public java.lang.String de.team33.test.java.SampleRecord.stringValue()",
                "public java.time.Instant de.team33.test.java.SampleRecord.instantValue()",
                "public java.util.List de.team33.test.java.SampleRecord.listValue()",
                "public final java.lang.String de.team33.test.java.SampleRecord.toString()",
                "public final int de.team33.test.java.SampleRecord.hashCode()",
                "public final boolean de.team33.test.java.SampleRecord.equals(java.lang.Object)");
        final Set<String> methods = Stream.of(SampleRecord.class.getDeclaredMethods())
                                          .map(Method::toString)
                                          .collect(Collectors.toSet());
        assertEquals(expected, methods);
    }

    @Test
    final void getMethods() {
        final Set<String> expected = Set.of(
                "public int de.team33.test.java.SampleRecord.intValue()",
                "public java.lang.String de.team33.test.java.SampleRecord.stringValue()",
                "public java.time.Instant de.team33.test.java.SampleRecord.instantValue()",
                "public java.util.List de.team33.test.java.SampleRecord.listValue()",
                "public final java.lang.String de.team33.test.java.SampleRecord.toString()",
                "public final int de.team33.test.java.SampleRecord.hashCode()",
                "public final boolean de.team33.test.java.SampleRecord.equals(java.lang.Object)",
                "public final native void java.lang.Object.notify()",
                "public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException",
                "public final void java.lang.Object.wait() throws java.lang.InterruptedException",
                "public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException",
                "public final native java.lang.Class java.lang.Object.getClass()",
                "public final native void java.lang.Object.notifyAll()");
        final Set<String> methods = Stream.of(SampleRecord.class.getMethods())
                                          .map(Method::toString)
                                          .collect(Collectors.toCollection(HashSet::new));
        assertEquals(expected, methods);
    }

    @Test
    final void listValue() {
        final List<Object> listValue = List.of(1, 2, 3);
        assertFalse(listValue instanceof ArrayList);
        final SampleRecord sample = new SampleRecord(0, null, null, listValue);
        assertInstanceOf(ArrayList.class, sample.listValue());
    }
}
