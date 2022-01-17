package de.team33.test.liqalc.cmd;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.fail;

class MainTest {

    private static final Path TEST_PATH = Paths.get("target", "testing", MainTest.class.getSimpleName())
                                               .toAbsolutePath()
                                               .normalize();

    static {
        try {
            Files.createDirectories(TEST_PATH);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    @Test
    final void testMain() {
        fail("not yet implemented");
    }
}
