package net.racconscreator.RacconsModdingv2.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.custom.RacconsEntity;

public class Raccons_Entities {

public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RacconsModdingv2.MODID);

public static final RegistryObject<EntityType<RacconsEntity>> RACCON =
        ENTITY_TYPES.register("raccoon", ()-> EntityType.Builder.of(RacconsEntity :: new, MobCategory.CREATURE)
                .sized(0.7f, 0.7f).build("raccoons"));




public static void register(IEventBus eventBus) {
    ENTITY_TYPES.register(eventBus);
    }
}
