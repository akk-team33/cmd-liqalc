package de.team33.liqalc.lib.e1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.team33.liqalc.lib.e1.json.CompoundDTO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Repository {

    private static final Logger LOG = Logger.getLogger(Repository.class.getCanonicalName());
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get(System.getProperty("user.home"))
                                          .resolve("." + Repository.class.getPackageName())
                                          .resolve("default.liqalc.repo")
                                          .toAbsolutePath()
                                          .normalize();
    private static final Repository DEFAULT = new Repository(new HashMap<>() {{
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

    static {
        final Path parent = PATH.getParent();
        try {
            Files.createDirectories(parent);
        } catch (final IOException e) {
            LOG.log(Level.SEVERE, e, () -> "<%s> doesn't exist!".formatted(parent));
        }
    }

    private final Map<String, CompoundDTO> compounds;

    public Repository(final Map<String, CompoundDTO> compounds) {
        this.compounds = Collections.unmodifiableMap(new TreeMap<>(compounds));
    }

    public static Repository read() throws IOException {
        return Files.exists(PATH) ? read(PATH) : DEFAULT;
    }

    public static Repository read(final Path path) throws IOException {
        try (final Reader reader = Files.newBufferedReader(path, UTF_8)) {
            return read(reader);
        }
    }

    public static Repository read(final Reader reader) {
        return GSON.fromJson(reader, Repository.class);
    }

    public static void write(final Repository repository, final Writer out) {
        GSON.toJson(repository, out);
    }

    public static void write(final Repository repository, final Path path) throws IOException {
        try (final BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
            write(repository, writer);
        }
    }

    public static void write(final Repository repository) throws IOException {
        write(repository, PATH);
    }
}
