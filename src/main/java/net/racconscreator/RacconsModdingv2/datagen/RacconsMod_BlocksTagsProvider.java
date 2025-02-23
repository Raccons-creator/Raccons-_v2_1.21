package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RacconsMod_BlocksTagsProvider extends BlockTagsProvider {
    public RacconsMod_BlocksTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RacconsModdingv2.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(BlockTags.NEEDS_IRON_TOOL).add(RacconsBlocks.INK_SLIDE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(RacconsBlocks.INK_PORTAL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(RacconsBlocks.Blushing_Ash_Log.get())
                .add(RacconsBlocks.Blushing_Ash_Wood.get())
                .add(RacconsBlocks.Stripped_Blushing_Ash_log.get())
                .add(RacconsBlocks.Stripped_Blushing_Ash_wood.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(RacconsBlocks.Black_Ink_Elm_Log.get())
                .add(RacconsBlocks.Black_Ink_Elm_Wood.get())
                .add(RacconsBlocks.Stripped_Black_Ink_Elm_log.get())
                .add(RacconsBlocks.Stripped_Black_Ink_Elm_wood.get());

        tag(BlockTags.FENCES)
                .add(RacconsBlocks.Blushing_Ash_Fence.get())
                .add(RacconsBlocks.Black_Ink_Elm_Fence.get());

        tag(BlockTags.FENCE_GATES)
                .add(RacconsBlocks.Blushing_Ash_Fence_Gate.get())
                .add(RacconsBlocks.Black_Ink_Elm_Fence_Gate.get());


    }
}
