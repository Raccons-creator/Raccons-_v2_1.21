package net.racconscreator.RacconsModdingv2.RacconsModItems.Food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class RacconsModFoods {
    public static final FoodProperties COOKED_CLAM =
            new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(0.75f)
                    .alwaysEdible()
                    .effect(new MobEffectInstance(MobEffects.SATURATION, 1000),0.11f).build();
}
