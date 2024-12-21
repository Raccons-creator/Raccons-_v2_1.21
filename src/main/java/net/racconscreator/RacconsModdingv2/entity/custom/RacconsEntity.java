package net.racconscreator.RacconsModdingv2.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;
import org.jetbrains.annotations.Nullable;

import java.util.Stack;

public class RacconsEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int IdleAnimationTimeOut = 0;


    public RacconsEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0 , new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.5));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(RacconsItems.CLAM.get()), false));

        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 7.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RacconsEntity.RacconsAvoidEntityGoal<>(this, Wolf.class, 15.0F, 1.4, 1.6));
        this.goalSelector.addGoal(3, new RacconsEntity.RacconsAvoidEntityGoal<>(this, Fox.class, 12.0F, 1.2, 1.4));
    }
    public static AttributeSupplier.Builder createAttribute() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 9D)
                .add(Attributes.MOVEMENT_SPEED, 0.45D)
                .add(Attributes.FOLLOW_RANGE, 29D);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(RacconsItems.CLAM.get());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return Raccons_Entities.RACCON.get().create(pLevel);
    }



    class RacconsAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        private final RacconsEntity raccons;

        public RacconsAvoidEntityGoal(final RacconsEntity praccons, final Class<T> pEntityClassToAvoid, final float pMaxDist, final double pWalkSpeedModifier, final double pSprintSpeedModifier) {
            super(praccons, pEntityClassToAvoid, pMaxDist, pWalkSpeedModifier, pSprintSpeedModifier);
            this.raccons = praccons;
        }
    }
    private void setupanimationstates() {
        if (this.IdleAnimationTimeOut <= 0) {
            this.IdleAnimationTimeOut = 80;
            this.idleAnimationState.start(this.tickCount);
        }else {
            --this.IdleAnimationTimeOut;

        }
    }
    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupanimationstates();
        }
    }
}

