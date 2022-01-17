package de.team33.test.liqalc.lib.util;

import de.team33.liqalc.lib.e1.basic.Substance;
import de.team33.liqalc.lib.e1.json.CompoundDTO;
import de.team33.liqalc.lib.e1.json.RepositoryDTO;
import de.team33.patterns.production.e1.FactoryUtil;
import de.team33.patterns.random.e1.RandomHub;

import java.util.Collections;
import java.util.Map;

public class Origin {

    private static final Substance SUBSTANCE = Substance.PG;
    private static final Integer ANTEIL = 999;
    private static final Map<Substance, Integer> SUBSTANCES = Collections.singletonMap(SUBSTANCE, ANTEIL);
    private static final CompoundDTO COMPOUND_VALUE = new CompoundDTO(SUBSTANCES);
    private static final Map<String, CompoundDTO> COMPOUNDS = Collections.singletonMap(RandomHub.STRING, COMPOUND_VALUE);
    private static final RepositoryDTO REPOSITORY_DTO = new RepositoryDTO(COMPOUNDS);
    private static final RandomHub RANDOM = //
            RandomHub.builder()
                     .setUnknownTokenListener(FactoryUtil.DENY_UNKNOWN_TOKEN)
                     .on(REPOSITORY_DTO).apply(rnd -> new RepositoryDTO(rnd.any(COMPOUNDS)))
                     .on(COMPOUNDS).apply(rnd -> rnd.map(RandomHub.STRING, COMPOUND_VALUE, rnd.anyInt(3,6)))
                     .on(COMPOUND_VALUE).apply(rnd -> new CompoundDTO(rnd.any(SUBSTANCES)))
                     .on(SUBSTANCES).apply(rnd -> rnd.map(SUBSTANCE, rnd.anyInt(1,1000000), rnd.anyInt(3,6)))
                     .build();

    public static RepositoryDTO anyRepositoryDTO() {
        return RANDOM.any(REPOSITORY_DTO);
    }
}
