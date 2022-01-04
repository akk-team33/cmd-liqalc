package de.team33.liqalc.lib.e1.json;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RepositoryDTO {

    private final Map<String, CompoundDTO> compounds;

    public RepositoryDTO(final Map<String, CompoundDTO> compounds) {
        this.compounds = Collections.unmodifiableMap(new TreeMap<>(compounds));
    }
}
