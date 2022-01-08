package de.team33.liqalc.lib.e1.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.team33.liqalc.lib.e1.Substance;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RepositoryUtil {

    private static final Class<RepositoryUtil> CLASS = RepositoryUtil.class;
    private static final Logger LOG = Logger.getLogger(CLASS.getCanonicalName());
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final RepositoryDTO DEFAULT = new RepositoryDTO(new HashMap<>() {{
        put("PG (99,5%)", CompoundDTO.builder()
                                     .add(Substance.PG, 995)
                                     .add(Substance.H2O, 5)
                                     .build());
        put("VG (99,5%)", CompoundDTO.builder()
                                     .add(Substance.VG, 995)
                                     .add(Substance.H2O, 5)
                                     .build());
        put("Aqua dest.", CompoundDTO.builder()
                                     .add(Substance.H2O, 1)
                                     .build());
    }});

    public static final Path CONFIG_PATH = Paths.get(System.getProperty("user.home"))
                                              .resolve("." + CLASS.getPackageName())
                                              .toAbsolutePath()
                                              .normalize();
    public static final Path REPO_PATH = CONFIG_PATH.resolve("default.liqalc.repo");

    static {
        final Path parent = REPO_PATH.getParent();
        try {
            Files.createDirectories(parent);
        } catch (final IOException e) {
            LOG.log(Level.SEVERE, e, () -> "Application configuration path <%s> doesn't exist!".formatted(parent));
        }
    }

    public static void reset() throws IOException {
        Files.deleteIfExists(REPO_PATH);
    }

    public static RepositoryDTO read() throws IOException {
        return Files.exists(REPO_PATH) ? read(REPO_PATH) : DEFAULT;
    }

    public static RepositoryDTO read(final Path path) throws IOException {
        try (final Reader reader = Files.newBufferedReader(path, UTF_8)) {
            return read(reader);
        }
    }

    public static RepositoryDTO read(final Reader reader) {
        return GSON.fromJson(reader, RepositoryDTO.class);
    }

    public static void write(final RepositoryDTO repository, final Writer out) {
        GSON.toJson(repository, out);
    }

    public static void write(final RepositoryDTO repository, final Path path) throws IOException {
        try (final BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
            write(repository, writer);
        }
    }

    public static void write(final RepositoryDTO repository) throws IOException {
        write(repository, REPO_PATH);
    }
}
