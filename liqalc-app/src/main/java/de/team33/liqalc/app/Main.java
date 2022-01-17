package de.team33.liqalc.app;

import javax.swing.*;

public class Main {

    private Main(final String[] args) {
        //throw new UnsupportedOperationException("not yet implemented");
    }

    public static void main(final String... args) {
        SwingUtilities.invokeLater(() -> new Main(args).show());
    }

    private void show() {
        /* Erzeugung eines neuen Frames mit dem
           Titel "Beispiel JFrame " */
        JFrame meinFrame = new JFrame("Beispiel JFrame");
        /* Wir setzen die Breite und die Höhe
           unseres Fensters auf 200 Pixel */
        meinFrame.setSize(200,200);
        // Wir lassen unseren Frame anzeigen
        meinFrame.setVisible(true);
    }
}
