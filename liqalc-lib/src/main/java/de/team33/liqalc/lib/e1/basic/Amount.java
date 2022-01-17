package de.team33.liqalc.lib.e1.basic;

public class Amount {

    private final long value;

    public Amount(final long value, final Unit unit) {
        this.value = value;
    }

    public double getValue(final Unit unit) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public enum Unit {

        µg,
        mg,
        g,
        kg,
        µl,
        ml,
        l;

        public static final Unit NORMAL = µg;
    }
}
