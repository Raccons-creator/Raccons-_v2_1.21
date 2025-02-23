package net.racconscreator.RacconsModdingv2.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum RacconVariants {
    NORMAL(0),
    BROWN(1),
    RARE(2);

    private static final RacconVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(RacconVariants::getId)).toArray(RacconVariants[]::new);
    private final int id;


    RacconVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static RacconVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
