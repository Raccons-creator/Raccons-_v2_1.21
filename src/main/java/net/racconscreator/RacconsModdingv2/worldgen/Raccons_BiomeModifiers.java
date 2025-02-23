package net.racconscreator.RacconsModdingv2.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;

import java.util.List;

public class Raccons_BiomeModifiers {

public static final ResourceKey<BiomeModifier> SPAWN_RACCON = registerKey("spawnraccons");



    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_RACCON, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS),
                        biomes.getOrThrow(Biomes.CHERRY_GROVE),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.SNOWY_TAIGA)),
                List.of(new MobSpawnSettings.SpawnerData(Raccons_Entities.RACCON.get(), 15, 2, 4))));


    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, name));
    }
}
