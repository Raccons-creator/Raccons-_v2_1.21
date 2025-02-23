package net.racconscreator.RacconsModdingv2.RacconsModItems.Food;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.racconscreator.RacconsModdingv2.effect.Raccons_Effects;

public class RacconsModFoods {
    public static final FoodProperties COOKED_CLAM =
            new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(0.75f)
                    .alwaysEdible()
                    .effect(new MobEffectInstance(MobEffects.SATURATION, 1000),0.41f).build();

    public static final FoodProperties INK_BERRY_TART =
            new FoodProperties.Builder()
                    .nutrition(30)
                    .saturationModifier(0.45f)
                    .alwaysEdible()
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 300),0.25f)
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, 1200),0.25f)
                    .build();
}
