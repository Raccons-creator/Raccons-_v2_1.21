package net.racconscreator.RacconsModdingv2.datagen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = RacconsModdingv2.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(RacconsMod_BlocksLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(event.includeClient(), new RacconsMod_RecipeProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new RacconsMod_BlocksTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new RacconsMod_ItemsTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeClient(), new RacconsMod_Item_ModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new RacconsMod_BlocksStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new RacconsMod_DatapackEntries(packOutput, lookupProvider));

    }
}
