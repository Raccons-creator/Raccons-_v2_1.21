package net.racconscreator.RacconsModdingv2.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class Ink_Blight_Animations {
        public static final AnimationDefinition WALKING = AnimationDefinition.Builder.withLength(0.625f).looping()
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.POSITION,
                                new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.125f, KeyframeAnimations.posVec(0f, 3f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 2f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, -1f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, -1f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.125f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.375f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(20f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.625f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg0",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 12.5f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(40f, 0f, 12.5f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-45f, 0f, 12.5f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 12.5f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-10f, 0f, 12.5f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.625f, KeyframeAnimations.degreeVec(17.5f, 0f, 12.5f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg1",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(17.5f, 0f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(40f, 0f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-45f, 0f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-15f, 0f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.625f, KeyframeAnimations.degreeVec(17.5f, 0f, -10f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg2",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-50f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.625f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg3",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-50f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("tails",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("tail3",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("tail2",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4583433f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR))).build();
        public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(0.20834334f)
                .addAnimation("tails",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.125f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("tail3",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.125f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("tail2",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.125f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR))).build();
        public static final AnimationDefinition ATTACKANIM = AnimationDefinition.Builder.withLength(1.0416767f)
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.POSITION,
                                new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.041676664f, KeyframeAnimations.posVec(0f, -2f, -3f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08343333f, KeyframeAnimations.posVec(0f, -7f, -3f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -8f, -4f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, -9f, -5f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, -10f, -6f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, -12f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -14f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.375f, KeyframeAnimations.posVec(0f, -16f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, -20f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.4583433f, KeyframeAnimations.posVec(0f, -24f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -29f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, -32f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5834334f, KeyframeAnimations.posVec(0f, -24f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.625f, KeyframeAnimations.posVec(0f, -19f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, -16f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, -13f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -10f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, -7f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, -1f, -7f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 0f, -7f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(62.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-80f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.7916766f, KeyframeAnimations.degreeVec(-62.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.9583434f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg0",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg1",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(45f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg2",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-60f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(-47.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(20f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("leg3",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-60.07f, 0.08f, 0.59f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.7083434f, KeyframeAnimations.degreeVec(-47.57f, 0.08f, 0.59f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(19.26f, -8.32f, 9.88f),
                                        AnimationChannel.Interpolations.LINEAR))).build();
}
