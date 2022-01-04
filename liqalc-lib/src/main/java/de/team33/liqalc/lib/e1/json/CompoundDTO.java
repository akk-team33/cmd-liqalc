package de.team33.liqalc.lib.e1.json;

import de.team33.liqalc.lib.e1.Substance;

import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class CompoundDTO extends AbstractMap<Substance, Integer> {

    private final Map<Substance, Integer> backing;

    public CompoundDTO(final Map<Substance, Integer> backing) {
        this.backing = new EnumMap<>(backing);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public final Set<Entry<Substance, Integer>> entrySet() {
        return backing.entrySet();
    }

    public static class Builder {

        private final Map<Substance, Integer> backing = new EnumMap<>(Substance.class);

        public final CompoundDTO build() {
            return new CompoundDTO(backing);
        }

        public final Builder add(final Substance substance, final int ratio) {
            backing.put(substance, ratio);
            return this;
        }
    }
}
