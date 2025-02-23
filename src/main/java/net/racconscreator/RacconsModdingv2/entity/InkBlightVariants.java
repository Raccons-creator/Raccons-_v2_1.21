package net.racconscreator.RacconsModdingv2.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum InkBlightVariants {
    Normal(0),
    SUPER_RARE(3);

    private static final InkBlightVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(InkBlightVariants::getId)).toArray(InkBlightVariants[]::new);

    private final int id;

    InkBlightVariants(int id) {
        this.id =id;
    }

    public int getId() {
        return this.id;
    }
    public static InkBlightVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
