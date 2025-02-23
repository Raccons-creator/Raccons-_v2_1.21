package net.racconscreator.RacconsModdingv2.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

public class Raccons_Effects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RacconsModdingv2.MODID);

public static final RegistryObject<MobEffect> TKOMK =
        MOB_EFFECTS.register("tkomk",
                () -> new The_Killer_of_my_KingEffect(MobEffectCategory.HARMFUL, 0)
                        .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"tkomk"),
                                -0.6f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryObject<MobEffect> UNKNOWN_EFFECT =
            MOB_EFFECTS.register("unknown_effect",
                    () -> new Unknown_Effect(MobEffectCategory.NEUTRAL, 0)
                            .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"unknown_effect"),
                                    0f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryObject<MobEffect> TheShefer_EFFECT =
            MOB_EFFECTS.register("theshefer_effect",
                    () -> new The_Shefer_Effect(MobEffectCategory.NEUTRAL, 0)
                            .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"theshefer_effect"),
                                    0f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryObject<MobEffect> Raccoons_Curse =
            MOB_EFFECTS.register("raccons_curse",
                    () -> new Raccons_Curse(MobEffectCategory.BENEFICIAL, 0)
                            .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"theshefer_effect"),
                                    0f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
