package net.racconscreator.RacconsModdingv2.enchantment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.enchantment.custom.SinkyEnchantmentEffect;

public class Raccons_Enchantments_Effects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_E_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, RacconsModdingv2.MODID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> SINKY =
            ENTITY_E_EFFECTS.register("sinky", () -> SinkyEnchantmentEffect.CODEC);


    public static void register(IEventBus eventBus) {
        ENTITY_E_EFFECTS.register(eventBus);
    }
}
