package net.racconscreator.RacconsModdingv2.entity.custom;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;

public class TTTProjectileEntity extends AbstractArrow {
    private float rotation;
    public Vec2 groundedOffset;
    private int life;
    private boolean usedPortal;

    public TTTProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public TTTProjectileEntity(LivingEntity shooter, Level level) {
        super(Raccons_Entities.TTT.get(), shooter, level, new ItemStack(RacconsItems.TTT.get()), null);
    }


    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(RacconsItems.TTT.get());
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if(result.getDirection() == Direction.SOUTH) {
            groundedOffset = new Vec2(215f,180f);
        }
        if(result.getDirection() == Direction.NORTH) {
            groundedOffset = new Vec2(215f, 0f);
        }
        if(result.getDirection() == Direction.EAST) {
            groundedOffset = new Vec2(215f,-90f);
        }
        if(result.getDirection() == Direction.WEST) {
            groundedOffset = new Vec2(215f,90f);
        }

        if(result.getDirection() == Direction.DOWN) {
            groundedOffset = new Vec2(115f,180f);
        }
        if(result.getDirection() == Direction.UP) {
            groundedOffset = new Vec2(285f,180f);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide && this.life % 2 < 2) {
            this.level()
                    .addParticle(
                            ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                            this.getX(),
                            this.getY(),
                            this.getZ(),
                            this.random.nextGaussian() * 0.05,
                            -this.getDeltaMovement().y * 0.5,
                            this.random.nextGaussian() * 0.05
                    );
            if (this.level().isClientSide && this.life % 2 < 2) {
                this.level()
                        .addParticle(
                                ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                                this.getX(),
                                this.getY(5),
                                this.getZ(),
                                this.random.nextGaussian() * 0.05,
                                -this.getDeltaMovement().y * 0.5,
                                this.random.nextGaussian() * 0.05);
            }
        }
    }
}
