package de.team33.test.liqalc.lib.e1.json;

import de.team33.liqalc.lib.e1.basic.Substance;
import de.team33.liqalc.lib.e1.json.CompoundDTO;
import de.team33.liqalc.lib.e1.json.RepositoryDTO;
import de.team33.liqalc.lib.e1.json.RepositoryUtil;
import de.team33.patterns.random.e1.RandomHub;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Map;

import static de.team33.test.liqalc.lib.util.Origin.anyRepositoryDTO;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryUtilTest {

    private static final Substance SUBSTANCE = Substance.PG;
    private static final Integer ANTEIL = 999;
    private static final String COMPOUND_KEY = "COMPOUND_KEY";
    private static final Map<Substance, Integer> SUBSTANCES = Collections.singletonMap(SUBSTANCE, ANTEIL);
    private static final CompoundDTO COMPOUND_VALUE = new CompoundDTO(SUBSTANCES);
    private static final Map<String, CompoundDTO> COMPOUNDS = Collections.singletonMap(COMPOUND_KEY, COMPOUND_VALUE);
    private static final RepositoryDTO REPOSITORY_DTO = new RepositoryDTO(COMPOUNDS);
    private static final RandomHub RANDOM = RandomHub.builder()
                                                     .build();

    @Test
    final void CONFIG_PATH() {
        assertTrue(Files.isDirectory(RepositoryUtil.CONFIG_PATH));
    }

    @Test
    final void reset() throws IOException {
        final RepositoryDTO initial = RepositoryUtil.read();
        RepositoryUtil.write(initial);
        assertTrue(Files.exists(RepositoryUtil.REPO_PATH));

        RepositoryUtil.reset();
        assertFalse(Files.exists(RepositoryUtil.REPO_PATH));
    }

    // TODO: @Test
    void read() throws IOException {
        RepositoryUtil.reset();
        final RepositoryDTO initial = RepositoryUtil.read();
        assertFalse(Files.exists(RepositoryUtil.REPO_PATH));

        final RepositoryDTO expected = anyRepositoryDTO();
        RepositoryUtil.write(initial);
        assertTrue(Files.exists(RepositoryUtil.REPO_PATH));
    }

    @Test
    void write() {
    }
}
