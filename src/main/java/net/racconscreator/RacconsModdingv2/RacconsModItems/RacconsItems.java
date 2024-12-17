package net.racconscreator.RacconsModdingv2.RacconsModItems;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModItems.Food.RacconsModFoods;
import net.racconscreator.RacconsModdingv2.RacconsModItems.custom.Raccons_Armor_Materials;
import net.racconscreator.RacconsModdingv2.RacconsModItems.custom.Raccons_Tier_Tools;
import net.racconscreator.RacconsModdingv2.RacconsModItems.custom.SchyteofInk_Item;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.RacconsSound.Raccons_Sounds;

public class RacconsItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RacconsModdingv2.MODID);

    public static final RegistryObject<Item> RACCONS_FUR =
            ITEMS.register("raccons_fur",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CLAM =
            ITEMS.register("clam",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COOKED_CLAM =
            ITEMS.register("cooked_clam",
                    () -> new Item(new Item.Properties().food(RacconsModFoods.COOKED_CLAM).stacksTo(32)));

    public static final RegistryObject<Item> ICON_TAB_1 =
            ITEMS.register("icon_tab_1",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INK =
            ITEMS.register("ink",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SURROUNDED_BY_INK =
            ITEMS.register("surrounded_by_ink_disc",
                    () -> new Item(new Item.Properties()
                            .jukeboxPlayable(Raccons_Sounds.Surrounded_by_Ink_key)
                            .stacksTo(1)
                            .fireResistant()
                    ));

    //Raccon´s Cape

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

    //PvP
    public static final RegistryObject<Item> SCYTHEOFINK =
            ITEMS.register("scytheofink",
                    () -> new SchyteofInk_Item(new Item.Properties()
                            .attributes(SwordItem.createAttributes(Raccons_Tier_Tools.SST, 2, -3.1f)
                            )));



    public static final RegistryObject<Item> SWORDOFINK =
            ITEMS.register("swordofink",
                    () -> new Item(new Item.Properties()

                    ));

    public static final RegistryObject<Item> THESHEFER =
            ITEMS.register("theshefer",
                    () -> new Item(new Item.Properties()
                            .attributes(SwordItem.createAttributes(Raccons_Tier_Tools.SST, -9, -2.8f)
                    )));

    public static final RegistryObject<Item> THE_BIG_CANNON =
            ITEMS.register("the_big_cannon",
                    () -> new BowItem(new Item.Properties().durability(2890)));

    //END
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
