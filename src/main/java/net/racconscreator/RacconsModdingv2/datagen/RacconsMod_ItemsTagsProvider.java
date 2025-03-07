package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
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

        tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(RacconsItems.SCYTHEOFINK.get())
        .add(RacconsItems.SWORDOFINK.get());

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(RacconsItems.SCYTHEOFINK.get())
                .add(RacconsItems.SWORDOFINK.get())
                .add(RacconsItems.THESHEFER.get())
                .add(RacconsItems.Long_Sw.get());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(RacconsItems.Bow.get());

        tag(ItemTags.PICKAXES)
                .add(RacconsItems.THESHEFER.get());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(RacconsItems.SCYTHEOFINK.get())
                .add(RacconsItems.SWORDOFINK.get())
                .add(RacconsItems.THESHEFER.get());

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(RacconsItems.Raccons_1.get())
                .add(RacconsItems.Raccons_2.get())
                .add(RacconsItems.Raccons_3.get())
                .add(RacconsItems.Raccons_4.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(RacconsItems.Raccons_1.get())
                .add(RacconsItems.Raccons_2.get())
                .add(RacconsItems.Raccons_3.get())
                .add(RacconsItems.Raccons_4.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(RacconsItems.Raccons_4.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(RacconsItems.Raccons_1.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(RacconsItems.Raccons_2.get());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(RacconsItems.Raccons_3.get());


        tag(ItemTags.LOGS_THAT_BURN)
                .add(RacconsBlocks.Blushing_Ash_Log.get().asItem())
                .add(RacconsBlocks.Blushing_Ash_Wood.get().asItem())
                .add(RacconsBlocks.Stripped_Blushing_Ash_log.get().asItem())
                .add(RacconsBlocks.Stripped_Blushing_Ash_wood.get().asItem())


                .add(RacconsBlocks.Black_Ink_Elm_Log.get().asItem())
                .add(RacconsBlocks.Black_Ink_Elm_Wood.get().asItem())
                .add(RacconsBlocks.Stripped_Black_Ink_Elm_log.get().asItem())
                .add(RacconsBlocks.Stripped_Black_Ink_Elm_wood.get().asItem());

        tag(ItemTags.PLANKS)
                .add(RacconsBlocks.Blushing_Ash_Planks.get().asItem())
                .add(RacconsBlocks.Black_Ink_Elm_Planks.get().asItem());
    }
}
