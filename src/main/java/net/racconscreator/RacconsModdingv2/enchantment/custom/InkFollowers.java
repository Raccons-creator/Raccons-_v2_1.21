package net.racconscreator.RacconsModdingv2.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

import java.util.Vector;


public record InkFollowers() implements EnchantmentEntityEffect {
    public static MapCodec<InkFollowers> CODEC = MapCodec.unit(InkFollowers::new);

    @Override
    public void apply(ServerLevel pLevel, int pEnchantmentLevel, EnchantedItemInUse pItem, Entity pEntity, Vec3 pOrigin) {
        if (pEnchantmentLevel == 1) {
            EntityType.EVOKER_FANGS.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
            MobEffects.HARM.get();
        }

        if (pEnchantmentLevel == 2) {
            EntityType.EVOKER_FANGS.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
            MobEffects.HARM.get();
            EntityType.EVOKER_FANGS.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
            MobEffects.HARM.get();
            EntityType.EVOKER_FANGS.spawn(pLevel, pEntity.getOnPos(), MobSpawnType.TRIGGERED);
            MobEffects.POISON.get();
        }
    }

// END
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
