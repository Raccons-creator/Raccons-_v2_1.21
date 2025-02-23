package net.racconscreator.RacconsModdingv2.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.worldgen.Raccons_ConfiguratedFeatures;

import java.util.Optional;

public class Raccons_TreeGrowers {
    public static final TreeGrower Blushing_Ash = new TreeGrower(RacconsModdingv2.MODID + ":blushing_ash",
            Optional.empty(), Optional.of(Raccons_ConfiguratedFeatures.Blushing_Ash_KEY), Optional.empty());

    public static final TreeGrower Black_Ink_Elm = new TreeGrower(RacconsModdingv2.MODID + ":black_ink_elm",
            Optional.empty(), Optional.of(Raccons_ConfiguratedFeatures.Black_Ink_Elm_KEY), Optional.empty());


}
