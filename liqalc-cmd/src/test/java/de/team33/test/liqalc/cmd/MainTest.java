package de.team33.test.liqalc.cmd;

import de.team33.liqalc.cmd.Main;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    final void main_noArgs() throws IOException {
        final int result = Main.main();
        assertEquals(0, result);
    }

    @Test
    final void main_repo() throws IOException {
        final int result = Main.main("repo");
        assertEquals(1, result);
    }

    @Test
    final void main_repo_getFile() throws IOException {
        final Path path = TEST_PATH.resolve(UUID.randomUUID() + ".liqalc.repo");
        // get to file ...
        {
            final int result = Main.main("repo", path.toString());
            assertEquals(2, result);
            assertTrue(Files.exists(path));
        }
        // set from file
        {
            final int result = Main.main("repo", path.toString());
            assertEquals(3, result);
            // TODO: verify internal repo file to be overridden
        }
    }
}
