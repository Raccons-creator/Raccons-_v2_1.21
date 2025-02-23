package net.racconscreator.RacconsModdingv2.RacconsModItems;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModItems.Food.RacconsModFoods;
import net.racconscreator.RacconsModdingv2.RacconsModItems.custom.*;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.RacconsSound.Raccons_Sounds;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;

import java.util.List;

public class RacconsItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RacconsModdingv2.MODID);

    public static final RegistryObject<Item> RACCONS_FUR =
            ITEMS.register("raccons_fur",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INKBLIGHT_FUR =
            ITEMS.register("inkblight_fur",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CLAM =
            ITEMS.register("clam",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COOKED_CLAM =
            ITEMS.register("cooked_clam",
                    () -> new Item(new Item.Properties().food(RacconsModFoods.COOKED_CLAM).stacksTo(32)));

    public static final RegistryObject<Item> INKBERRY_TART =
            ITEMS.register("inkberry_tart",
                    () -> new Item(new Item.Properties().food(RacconsModFoods.INK_BERRY_TART).stacksTo(15)));


    public static final RegistryObject<Item> LunarFlare =
            ITEMS.register("lunarflare",
                    () -> new ForgeSpawnEggItem(Raccons_Entities.Ink_Blight,0, 0, new Item.Properties().stacksTo(1)){

                @Override
                        public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                            if(Screen.hasShiftDown()) {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.lunarflare.shift_down"));
                            } else {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.lunarflare"));
                            }
                        }

                        @Override
                        public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
                            pPlayer.playSound(SoundEvents.FOX_SNIFF, 0.6f, 0.6f);
                            pPlayer.getCooldowns().addCooldown(this, 360);
                            pPlayer.awardStat(Stats.ITEM_USED.get(this));
                            return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
                        }
                    });



    public static final RegistryObject<Item> ICON_TAB_1 =
            ITEMS.register("icon_tab_1",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INK =
            ITEMS.register("ink",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Raccoon =
            ITEMS.register("raccoon",
                    () -> new Item(new Item.Properties()){

                        @Override
                        public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                            if(Screen.hasShiftDown()) {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.raccoon.shift_down"));
                            } else {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.raccoon"));
                            }
                        }
                    });


    //Raccon´s Cape
    public static final RegistryObject<Item> Raccons_MASK =
            ITEMS.register("raccons_mask",
                    () -> new Raccons_ArmorItem(Raccons_Armor_Materials.RACCONS_Mask, ArmorItem.Type.HELMET, new Item.Properties().durability(3000)){

                @Override
                        public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                            if(Screen.hasShiftDown()) {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.raccons_mask.shift_down"));
                            } else {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.raccons_mask"));
                            }
                        }
                    });



    public static final RegistryObject<Item> Raccons_MASK_GLOW =
            ITEMS.register("raccons_mask_glow",
                    () -> new Raccons_ArmorItem(Raccons_Armor_Materials.RACCONS_Mask_Glowing, ArmorItem.Type.HELMET, new Item.Properties().durability(3000)){

                @Override
                        public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                            if(Screen.hasShiftDown()) {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.raccons_mask_glowing.shift_down"));
                            } else {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.raccons_mask_glowing"));
                            }
                        }
                    });



    public static final RegistryObject<Item> Raccons_1 =
            ITEMS.register("raccons_1",
                    () -> new ArmorItem(Raccons_Armor_Materials.RACCONS_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                            new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(690))));

    public static final RegistryObject<Item> Raccons_2 =
            ITEMS.register("raccons_2",
                    () -> new ArmorItem(Raccons_Armor_Materials.RACCONS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(790))));

    public static final RegistryObject<Item> Raccons_3 =
            ITEMS.register("raccons_3",
                    () -> new ArmorItem(Raccons_Armor_Materials.RACCONS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(790))));

    public static final RegistryObject<Item> Raccons_4 =
            ITEMS.register("raccons_4",
                    () -> new ArmorItem(Raccons_Armor_Materials.RACCONS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(691))));


    //WTF is this curse I have more then 15 curses welp

    public static final RegistryObject<Item> Ink_corruption_1 =
            ITEMS.register("ink_corruption_1",
                    () -> new ArmorItem(Raccons_Armor_Materials.INK_CURSE, ArmorItem.Type.HELMET,
                            new Item.Properties()));

    public static final RegistryObject<Item> Ink_corruption_2 =
            ITEMS.register("ink_corruption_2",
                    () -> new ArmorItem(Raccons_Armor_Materials.INK_CURSE, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties()));

    public static final RegistryObject<Item> Ink_corruption_3 =
            ITEMS.register("ink_corruption_3",
                    () -> new ArmorItem(Raccons_Armor_Materials.INK_CURSE, ArmorItem.Type.LEGGINGS,
                            new Item.Properties()));

    public static final RegistryObject<Item> Ink_corruption_4 =
            ITEMS.register("ink_corruption_4",
                    () -> new ArmorItem(Raccons_Armor_Materials.INK_CURSE, ArmorItem.Type.BOOTS,
                            new Item.Properties()));


    //PvP
    public static final RegistryObject<Item> SCYTHEOFINK =
            ITEMS.register("scytheofink",
                    () -> new SchyteofInk_Item(new Item.Properties()
                            .attributes(SwordItem.createAttributes(Raccons_Tier_Tools.SST, 2, -3.1f)
                            )));



    public static final RegistryObject<Item> SWORDOFINK =
            ITEMS.register("swordofink",
                    () -> new SwordofInk_Item(new Item.Properties().attributes(SwordItem.createAttributes(Raccons_Tier_Tools.SST, -10, -1)
                            ).durability(2300)

                    ));

    public static final RegistryObject<Item> THESHEFER =
            ITEMS.register("theshefer",
                    () -> new TheShefer_Item(new Item.Properties().durability(2000)
                            .attributes(PickaxeItem.createAttributes(Raccons_Tier_Tools.SST, 1f, 0.5f))
                            .attributes(SwordItem.createAttributes(Raccons_Tier_Tools.SST, -9, -2.8f)

                    )));

    public static final RegistryObject<Item> THE_BIG_CANNON =
            ITEMS.register("the_big_cannon",
                    () -> new CrossbowItem(new Item.Properties().durability(2890)));


    public static final RegistryObject<Item> TTT =
            ITEMS.register("ttt",
                    () -> new TTT_item(new Item.Properties().stacksTo(6)));


    public static final RegistryObject<Item> Long_Sw =
            ITEMS.register("long_sw",
                    () -> new Item(new Item.Properties().attributes(SwordItem.createAttributes(Raccons_Tier_Tools.SST, -5, -1.1f))){

                @Override
                        public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                            if(Screen.hasShiftDown()) {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.long_sword.shift_down"));
                            } else {
                                pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.long_sword"));
                            }
                        }
                    });

    public static final RegistryObject<Item> Bow =
            ITEMS.register("bow",
                    () -> new Custom_Bow(new Item.Properties().durability(5000)));

    public static final RegistryObject<Item> The_Ink_Helling =
            ITEMS.register("the_ink_helling",
                    () -> new The_Ink_Helling_Item(new Item.Properties().durability(50).rarity(Rarity.EPIC)));



    //ENTITIES
    public static final RegistryObject<Item> RacconSpawnEgg =
            ITEMS.register("racconspawnegg",
                    () -> new ForgeSpawnEggItem(Raccons_Entities.RACCON, 0x53524b, 0xdac741, new Item.Properties())
            );

    //END
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
