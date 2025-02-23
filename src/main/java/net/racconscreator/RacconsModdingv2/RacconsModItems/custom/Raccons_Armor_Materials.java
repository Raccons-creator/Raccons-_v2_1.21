package net.racconscreator.RacconsModdingv2.RacconsModItems.custom;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class Raccons_Armor_Materials {

    public static final Holder<ArmorMaterial> RACCONS_ARMOR_MATERIAL = register("raccons_cape", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute ->{
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 8);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 11);
            }), 15, 4f, 0.1f, () -> RacconsItems.RACCONS_FUR.get());


    public static final Holder<ArmorMaterial> RACCONS_Mask = register("raccons_mask", Util.make(new EnumMap<>(ArmorItem.Type.class),
            rw_m ->{
                rw_m.put(ArmorItem.Type.HELMET, 2);
                rw_m.put(ArmorItem.Type.BOOTS, 5);
                rw_m.put(ArmorItem.Type.LEGGINGS, 8);
                rw_m.put(ArmorItem.Type.CHESTPLATE, 10);
                rw_m.put(ArmorItem.Type.BODY, 11);
            }), 6, 1f, 0.3f, () -> Items.NETHERITE_SCRAP);


    public static final Holder<ArmorMaterial> RACCONS_Mask_Glowing = register("raccons_mask_glowing", Util.make(new EnumMap<>(ArmorItem.Type.class),
            rw_m_g ->{
                rw_m_g.put(ArmorItem.Type.HELMET, 3);
            }), 6, 1f, 0.3f, () -> Items.NETHERITE_SCRAP);


    //More curses ;--;
    public static final Holder<ArmorMaterial> INK_CURSE = register("ink_curse", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute ->{
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 9);
            }), 15, 4f, 0.1f, () -> RacconsItems.INK.get());


    //end
    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_LEATHER;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
