package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;

import java.util.Set;

public class RacconsMod_BlocksLootTableProvider extends BlockLootSubProvider {
    protected RacconsMod_BlocksLootTableProvider( HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        this.add(RacconsBlocks.INK_SLIDE.get(),
        block -> createMultipleOreDrops(RacconsBlocks.INK_SLIDE.get(), RacconsItems.INK.get(), 1,5));

        this.add(RacconsBlocks.INK_PORTAL.get(),
                block -> createMultipleOreDrops(RacconsBlocks.INK_PORTAL.get(), RacconsItems.INK.get(), 1, 2));


        //Blushing Ash
        this.dropSelf(RacconsBlocks.Blushing_Ash_Log.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_Wood.get());
        this.dropSelf(RacconsBlocks.Stripped_Blushing_Ash_log.get());
        this.dropSelf(RacconsBlocks.Stripped_Blushing_Ash_wood.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_Planks.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_Sapplings.get());

        this.add(RacconsBlocks.Blushing_Ash_Leaves.get(), block ->
                createLeavesDrops(block, RacconsBlocks.Blushing_Ash_Sapplings.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        //Black Ink Elm
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Log.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Wood.get());
        this.dropSelf(RacconsBlocks.Stripped_Black_Ink_Elm_log.get());
        this.dropSelf(RacconsBlocks.Stripped_Black_Ink_Elm_wood.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Planks.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Sappling.get());

        this.add(RacconsBlocks.Black_Ink_Elm_Leaves.get(), block ->
                createLeavesDrops(block, RacconsBlocks.Black_Ink_Elm_Sappling.get(), NORMAL_LEAVES_SAPLING_CHANCES));


        //Black Ink Elm Multiple things =3

        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Stairs.get());

        this.dropSelf(RacconsBlocks.Black_Ink_Elm_pressure_plate.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_button.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Fence.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_Fence_Gate.get());
        this.dropSelf(RacconsBlocks.Black_Ink_Elm_TrapDoor.get());

        this.add(RacconsBlocks.Black_Ink_Elm_Slab.get(),
                block -> createSlabItemTable(RacconsBlocks.Black_Ink_Elm_Slab.get()));

        this.add(RacconsBlocks.Black_Ink_Elm_Door.get(),
                block -> createDoorTable(RacconsBlocks.Black_Ink_Elm_Door.get()));


        //Blushing Ash Multiple things =3

        this.dropSelf(RacconsBlocks.Blushing_Ash_Stairs.get());

        this.dropSelf(RacconsBlocks.Blushing_Ash_pressure_plate.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_button.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_Fence.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_Fence_Gate.get());
        this.dropSelf(RacconsBlocks.Blushing_Ash_TrapDoor.get());

        this.add(RacconsBlocks.Blushing_Ash_Slab.get(),
                block -> createSlabItemTable(RacconsBlocks.Blushing_Ash_Slab.get()));

        this.add(RacconsBlocks.Blushing_Ash_Door.get(),
                block -> createDoorTable(RacconsBlocks.Blushing_Ash_Door.get()));


    }
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RacconsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
