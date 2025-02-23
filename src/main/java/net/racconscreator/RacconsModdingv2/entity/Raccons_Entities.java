package net.racconscreator.RacconsModdingv2.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.custom.INKBlight;
import net.racconscreator.RacconsModdingv2.entity.custom.RacconsEntity;
import net.racconscreator.RacconsModdingv2.entity.custom.TTTProjectileEntity;

public class Raccons_Entities {

public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RacconsModdingv2.MODID);

public static final RegistryObject<EntityType<RacconsEntity>> RACCON =
        ENTITY_TYPES.register("raccoon", ()-> EntityType.Builder.of(RacconsEntity :: new, MobCategory.CREATURE)
                .sized(0.8f, 0.8f).build("raccoons"));

public static final RegistryObject<EntityType<TTTProjectileEntity>> TTT
        = ENTITY_TYPES.register("ttt", ()-> EntityType.Builder.<TTTProjectileEntity>of(TTTProjectileEntity::new, MobCategory.MISC)
        .sized(0.5f,1f).build("ttt"));

    public static final RegistryObject<EntityType<INKBlight>> Ink_Blight =
            ENTITY_TYPES.register("ink_blight", ()-> EntityType.Builder.of(INKBlight:: new, MobCategory.CREATURE)
                    .sized(1.1f, 1.1f).build("ink_blight"));

public static void register(IEventBus eventBus) {
    ENTITY_TYPES.register(eventBus);
    }
}
