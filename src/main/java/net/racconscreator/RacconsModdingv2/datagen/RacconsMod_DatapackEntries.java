package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.enchantment.Raccons_Enchantments;
import net.racconscreator.RacconsModdingv2.worldgen.Raccons_BiomeModifiers;
import net.racconscreator.RacconsModdingv2.worldgen.Raccons_ConfiguratedFeatures;
import net.racconscreator.RacconsModdingv2.worldgen.Raccons_PlacementFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RacconsMod_DatapackEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, Raccons_Enchantments::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, Raccons_ConfiguratedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, Raccons_BiomeModifiers::bootstrap)
            .add(Registries.PLACED_FEATURE, Raccons_PlacementFeatures::bootstrap);


    public RacconsMod_DatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(RacconsModdingv2.MODID));
    }
}
