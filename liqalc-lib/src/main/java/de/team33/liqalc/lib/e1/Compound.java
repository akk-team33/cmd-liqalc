package de.team33.liqalc.lib.e1;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Compound {

    private final Map<Substance, Integer> quotas;
    private final ScaleType scale;

    public Compound(final Substance substance, final int quota) {
        quotas = Collections.singletonMap(substance, quota);
        scale = ScaleType.MASS;
    }

    private Compound(final Map<Substance, Integer> quotas,
                     final Substance substance,
                     final int quota) {
        this.quotas = new EnumMap<>(quotas);
        this.quotas.put(substance, quota);
        scale = ScaleType.MASS;
    }

    public final Compound add(final Substance substance, final int quota) {
        return new Compound(quotas, substance, quota);
    }
}
