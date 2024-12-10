package net.racconscreator.RacconsModdingv2.RacconsModBlocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.NetherPortalBlock.AXIS;

public class InK_Block_FallDamage_Null extends Block {
    public InK_Block_FallDamage_Null(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        pEntity.causeFallDamage(pFallDistance, 0.5F,pLevel.damageSources().fall());
    }
}
