package net.racconscreator.RacconsModdingv2.RacconsModItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;



public class RacconsModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RacconsModdingv2.MODID);

    public static final RegistryObject<CreativeModeTab> RW_ITEMS =
            CREATIVE_MODE_TABS.register("raccons_world_items_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(RacconsItems.ICON_TAB_1.get()))
                    .title(Component.translatable("creativetab.racconsmodid.rw_items_"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(RacconsItems.RACCONS_FUR.get());
                        output.accept(RacconsItems.CLAM.get());
                        output.accept(RacconsItems.COOKED_CLAM.get());
                        output.accept(RacconsItems.INK.get());
                        output.accept(RacconsItems.Raccons_1.get());
                        output.accept(RacconsItems.Raccons_2.get());
                        output.accept(RacconsItems.Raccons_3.get());
                        output.accept(RacconsItems.Raccons_4.get());



                    }).build());

        public static final RegistryObject<CreativeModeTab> RW_BLOCKS =
                CREATIVE_MODE_TABS.register("raccons_world_blocks_tab",
                        ()-> CreativeModeTab.builder().icon(()-> new ItemStack(RacconsItems.ICON_TAB_1.get()))
                                .withTabsBefore(RW_ITEMS.getId())
                                .title(Component.translatable("creativetab.racconsmodid.rw_blocks_"))
                                .displayItems((itemDisplayParameters, output) -> {
                                    output.accept(RacconsBlocks.INK_PORTAL.get());
                                    output.accept(RacconsBlocks.INK_SLIDE.get());
                                    output.accept(RacconsBlocks.INK_MELT.get());

                                    //Blushing Tree Tree =w=
                                    output.accept(RacconsBlocks.Blushing_Ash_Leaves.get());
                                    output.accept(RacconsBlocks.Blushing_Ash_Log.get());
                                    output.accept(RacconsBlocks.Stripped_Blushing_Ash_log.get());
                                    output.accept(RacconsBlocks.Blushing_Ash_Wood.get());
                                    output.accept(RacconsBlocks.Stripped_Blushing_Ash_wood.get());

                                    //Furry Tree ... wait its Black Ink Elm tree =3 but idk im furry =3
                                    output.accept(RacconsBlocks.Black_Ink_Elm_Leaves.get());
                                    output.accept(RacconsBlocks.Black_Ink_Elm_Log.get());
                                    output.accept(RacconsBlocks.Stripped_Black_Ink_Elm_log.get());
                                    output.accept(RacconsBlocks.Black_Ink_Elm_Wood.get());
                                    output.accept(RacconsBlocks.Stripped_Black_Ink_Elm_wood.get());

                                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
