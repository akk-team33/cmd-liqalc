package de.team33.liqalc.lib.e1;

public enum DensityUnit {

    G_PRO_CM3("g/cm³"),
    KG_PRO_M3("kg/m³");

    public final String shortcut;

    DensityUnit(final String shortcut) {
        this.shortcut = shortcut;
    }
}
