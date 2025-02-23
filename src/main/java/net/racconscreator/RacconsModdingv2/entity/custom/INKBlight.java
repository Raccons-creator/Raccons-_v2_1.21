package net.racconscreator.RacconsModdingv2.entity.custom;


import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.entity.InkBlightVariants;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;

import javax.annotation.Nullable;

public class INKBlight extends Animal {
    private static final EntityDataAccessor<Integer> VARIANTS =
            SynchedEntityData.defineId(INKBlight.class, EntityDataSerializers.INT);

    public final AnimationState idleAnim = new AnimationState();
    private int idleAnimTimeOut = 0;

    public INKBlight(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    //GOALS
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.25, stack -> stack.is(RacconsItems.INK.get()), false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 21.0F));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
    }
    //ATTRIBUTES
    public static AttributeSupplier.Builder createAttribu() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 7D)
                .add(Attributes.MOVEMENT_SPEED, 0.31D)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.FOLLOW_RANGE, 35D);
    }
    //FOOD
    public boolean isFood(ItemStack pStack) {
        return pStack.is(RacconsItems.INK.get());
    }

    //ANIMATIONS
    private void setupAnimStates() {
        if( this.idleAnimTimeOut <=0 ) {
            this.idleAnimTimeOut = 40;
            this.idleAnim.start(this.tickCount);
        } else {
            --this.idleAnimTimeOut;
        }
    }
    //TICK
    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimStates();
        }
    }

    @Nullable
    @Override
    public INKBlight getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return Raccons_Entities.Ink_Blight.get().create(pLevel);
    }

    @Override
    public boolean canDisableShield() {
        return true;
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.is(Items.SHEARS) && this.shearsuse()) {
            itemstack.hurtAndBreak(1000000, pPlayer, getSlotForHand(pHand));
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        } else {
            return InteractionResult.FAIL;
        }
    }
            public boolean shearsuse() {
        if (this.isBaby()) {
            return false;
        } else {
            this.spawnAtLocation(new ItemStack(RacconsItems.INKBLIGHT_FUR.get()));
            this.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 1));
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.FOX_HURT);
            return true;
        }
    }

    @Override
    protected @org.jetbrains.annotations.Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.FOX_HURT;
    }



    /* VARIANT */
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANTS, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANTS);
    }

    public InkBlightVariants getVariant() {
        return InkBlightVariants.byId(this.getTypeVariant() & 255);
    }

    private void setVariant( InkBlightVariants variant) {
        this.entityData.set(VARIANTS, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variants", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(VARIANTS, pCompound.getInt("Variants"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
                                        MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        InkBlightVariants variant = Util.getRandom(InkBlightVariants.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    @Override
    public void finalizeSpawnChildFromBreeding(ServerLevel pLevel, Animal pAnimal, @Nullable AgeableMob pBaby) {
        InkBlightVariants variant = Util.getRandom(InkBlightVariants.values(), this.random);
        ((INKBlight) pBaby).setVariant(variant);
        super.finalizeSpawnChildFromBreeding(pLevel, pAnimal, pBaby);
    }
}


