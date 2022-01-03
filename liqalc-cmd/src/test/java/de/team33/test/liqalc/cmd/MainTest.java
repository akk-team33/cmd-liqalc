package de.team33.test.liqalc.cmd;

import de.team33.liqalc.cmd.Command;
import de.team33.liqalc.cmd.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    final void main_noArgs() throws IOException {
        final int result = Main.main();
        assertEquals(0, result);
    }

    @Test
    final void main_repo() throws IOException {
        final int result = Main.main("repo");
        assertEquals(0, result);
    }
}
