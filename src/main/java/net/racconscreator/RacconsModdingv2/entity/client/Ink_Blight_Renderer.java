package net.racconscreator.RacconsModdingv2.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.InkBlightVariants;
import net.racconscreator.RacconsModdingv2.entity.custom.INKBlight;

import java.util.Map;

public class Ink_Blight_Renderer  extends MobRenderer<INKBlight, Ink_Blight_Model<INKBlight>> {
    private static final Map<InkBlightVariants, ResourceLocation> LBV =
            Util.make(Maps.newEnumMap(InkBlightVariants.class), map -> {
                map.put(InkBlightVariants.Normal,
                        ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/ink_blight/ink_blight.png"));
                map.put(InkBlightVariants.SUPER_RARE,
                        ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/ink_blight/variant/ink_blight_red.png"));
            });

    public Ink_Blight_Renderer(EntityRendererProvider.Context pContext) {
        super(pContext,new Ink_Blight_Model<>(pContext.bakeLayer(Ink_Blight_Model.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(INKBlight pEntity) {
        return LBV.get(pEntity.getVariant());
    }

    @Override
    public void render(INKBlight pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
