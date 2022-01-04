package de.team33.liqalc.cmd;

import de.team33.liqalc.lib.e1.json.RepositoryDTO;
import de.team33.liqalc.lib.e1.RepositoryUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class Main {

    private static final String MAIN_INFO = textResource("MainInfo.txt");

    private static String textResource(final String resourceName) {
        try (final InputStream in = Main.class.getResourceAsStream(resourceName);
             final InputStreamReader reader = new InputStreamReader(in, UTF_8);
             final StringWriter writer = new StringWriter()) {
            reader.transferTo(writer);
            return writer.toString();
        } catch (final NullPointerException | IOException e) {
            throw new IllegalArgumentException("could not load resource <%s>".formatted(resourceName), e);
        }
    }

    public static int main(final String... args) throws IOException {
        if (1 > args.length) {
            return printMainInfo();
        } else if (args[0].equals(Command.repo.name())) {
            return doRepoCommand(args);
        } else if (args[0].equals(Command.calc.name())) {
            return doCalcCommand(args);
        } else {
            throw new UnsupportedOperationException("not yet implemented");
        }
    }

    private static int doCalcCommand(final String[] args) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    private static int doRepoCommand(final String[] args) throws IOException {
        if (2 > args.length) {
            return doRepoCommandGet(System.out);
        } else {
            final Path path = Paths.get(args[1]).toAbsolutePath().normalize();
            return doRepoCommand(path);
        }
    }

    private static int doRepoCommand(final Path path) throws IOException {
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            return doRepoCommandUpdate(path);
        } else {
            return doRepoCommandGet(path);
        }
    }

    private static int doRepoCommandGet(final Path path) throws IOException {
        try (final BufferedWriter out = Files.newBufferedWriter(path, UTF_8, CREATE_NEW)) {
            doRepoCommandGet(out);
        }
        return 2;
    }

    private static void doRepoCommandGet(final Writer out) throws IOException {
        final RepositoryDTO repository = RepositoryUtil.read();
        RepositoryUtil.write(repository, out);
        out.flush();
    }

    private static int doRepoCommandUpdate(final Path path) throws IOException {
        final RepositoryDTO repo = RepositoryUtil.read(path);
        RepositoryUtil.write(repo);
        return 3;
    }

    private static int doRepoCommandGet(final OutputStream out) throws IOException {
        doRepoCommandGet(new OutputStreamWriter(out, UTF_8));
        return 1;
    }

    private static int printMainInfo() {
        System.out.println(MAIN_INFO);
        return 0;
    }
}
