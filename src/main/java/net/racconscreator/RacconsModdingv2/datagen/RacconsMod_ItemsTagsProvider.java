package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RacconsMod_ItemsTagsProvider extends ItemTagsProvider {
    public RacconsMod_ItemsTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                                        CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {


        super(packOutput, completableFuture, lookupCompletableFuture, RacconsModdingv2.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(RacconsItems.Raccons_1.get())
        .add(RacconsItems.Raccons_2.get())
                .add(RacconsItems.Raccons_3.get())
        .add(RacconsItems.Raccons_4.get());

    }
}
