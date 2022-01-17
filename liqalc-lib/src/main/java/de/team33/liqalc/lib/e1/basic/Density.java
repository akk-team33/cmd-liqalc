package de.team33.liqalc.lib.e1.basic;

public class Density {

    private final long value;

    public Density(final double value, final Unit unit) {
        this.value = (long) ((value * unit.vFactor) / unit.mFactor);
    }

    public final double getValue() {
        return value;
    }

    public final double getValue(final Unit unit) {
        return 1.0 * value * unit.mFactor / unit.vFactor;
    }

    @Override
    public final int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public final boolean equals(final Object obj) {
        return (this == obj) || ((obj instanceof Density other) && (value == other.value));
    }

    @Override
    public final String toString() {
        return value + Unit.G_PER_CM3.label;
    }

    public enum Unit {

        G_PER_CM3("g/cm³", 1_000, 1_000_000),
        KG_PER_L("kg/l", 1, 1_000),
        MG_PER_M3("mg/m³", 1_000_000, 1),
        KG_PER_M3("kg/m³", 1, 1);

        final String label;
        final long mFactor;
        final long vFactor;

        Unit(final String label, final int mFactor, final int vFactor) {
            this.label = label;
            this.mFactor = mFactor;
            this.vFactor = vFactor;
        }
    }
}
