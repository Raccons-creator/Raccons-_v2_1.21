package net.racconscreator.RacconsModdingv2.RacconsModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.custom.InK_Block_FallDamage_Null;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.RacconsSound.Raccons_Sounds;

import java.util.function.Supplier;

public class RacconsBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RacconsModdingv2.MODID);

    public static final RegistryObject<TrapDoorBlock> INK_PORTAL = registryBlock("ink_portal",
            ()-> new TrapDoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                    .sound(Raccons_Sounds.INK_PORTAL_SOUNDS)
                    .noCollission()
                    .instabreak()
                    .explosionResistance(2)
                    .noOcclusion()
            ));

    public static final RegistryObject<TrapDoorBlock> INK_SLIDE = registryBlock("ink_slide",
            ()-> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .sound(Raccons_Sounds.INK_SLIDE_SOUNDS)
                    .friction(2.29f)
                    .instabreak()
                    .jumpFactor(0.2f)
                    .explosionResistance(5)
                    ));

    public static final RegistryObject<TrapDoorBlock> INK_MELT = registryBlock("ink_melt",
            ()-> new TrapDoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                    .sound(Raccons_Sounds.INK_MELT_SOUNDS)
                    .destroyTime(5)
                    .jumpFactor(0.18f)
                    .explosionResistance(5)
                    .speedFactor(0.2F)
                    .noLootTable()
            ));



    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T>block) {
        RacconsItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
