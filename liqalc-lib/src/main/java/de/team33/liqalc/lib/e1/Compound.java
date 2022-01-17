package de.team33.liqalc.lib.e1;

import de.team33.liqalc.lib.e1.basic.Fraction;
import de.team33.liqalc.lib.e1.basic.Substance;

import java.util.Map;

public class Compound {

    private final Map<Substance, Fraction> backing;

    public Compound(final Map<Substance, Fraction> backing) {
        this.backing = backing;
    }
}
