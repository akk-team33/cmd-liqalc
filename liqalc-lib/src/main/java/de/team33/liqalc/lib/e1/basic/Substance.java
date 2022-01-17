package de.team33.liqalc.lib.e1.basic;

import static de.team33.liqalc.lib.e1.basic.DensityUnit.G_PRO_CM3;

public enum Substance {

    NICOTINE(1.01, G_PRO_CM3),
    ETHANOL(0.79, G_PRO_CM3),
    H2O(0.998, G_PRO_CM3),
    PG(1.04, G_PRO_CM3),
    VG(1.26, G_PRO_CM3);

    private final double density;
    private final DensityUnit unit;

    Substance(final double density, final DensityUnit unit) {
        this.density = density;
        this.unit = unit;
    }
}
