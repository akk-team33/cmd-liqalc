package de.team33.test.liqalc.lib.e1.basic;

import de.team33.liqalc.lib.e1.basic.Density;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DensityTest {

    @Test
    final void getValue_CM3() {
        final Density density = new Density(1, Density.Unit.G_PER_CM3);
        assertEquals(1.0, density.getValue(Density.Unit.G_PER_CM3));
        assertEquals(1000.0, density.getValue(Density.Unit.KG_PER_M3));
    }

    @Test
    final void getValue_M3() {
        final Density density = new Density(1, Density.Unit.KG_PER_M3);
        assertEquals(0.001, density.getValue(Density.Unit.G_PER_CM3));
        assertEquals(1.0, density.getValue(Density.Unit.KG_PER_M3));
    }

    @Test
    final void testEquals() {
        assertEquals(new Density(0.05, Density.Unit.G_PER_CM3),
                     new Density(50, Density.Unit.KG_PER_M3));
    }

    @Test
    final void testHashCode() {
        assertEquals(new Density(0.05, Density.Unit.G_PER_CM3).hashCode(),
                     new Density(50, Density.Unit.KG_PER_M3).hashCode());
    }

    @Test
    final void testToString() {
        assertEquals(new Density(0.05, Density.Unit.G_PER_CM3).toString(),
                     new Density(50, Density.Unit.KG_PER_M3).toString());
    }
}
