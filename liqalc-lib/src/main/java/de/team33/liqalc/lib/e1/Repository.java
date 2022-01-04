package de.team33.liqalc.lib.e1;

import de.team33.liqalc.lib.e1.json.CompoundDTO;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Repository {

    private final Map<String, CompoundDTO> compounds;

    public Repository(final Map<String, CompoundDTO> compounds) {
        this.compounds = Collections.unmodifiableMap(new TreeMap<>(compounds));
    }
}
