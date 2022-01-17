package de.team33.liqalc.lib.e1.basic;

public class Fraction {

    public enum Unit {

        MG_PER_KG("mg/kg"),
        MG_PER_G("mg/g"),
        MG_PER_L("mg/l"),
        MG_PER_ML("mg/ml"),
        G_PER_KG("g/kg"),
        G_PER_G("g/g"),
        G_PER_L("g/l"),
        G_PER_ML("g/ml");

        private final String label;

        Unit(final String label) {
            this.label = label;
        }
    }
}
