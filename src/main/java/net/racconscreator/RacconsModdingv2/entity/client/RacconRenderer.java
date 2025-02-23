package net.racconscreator.RacconsModdingv2.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.RacconVariants;
import net.racconscreator.RacconsModdingv2.entity.custom.RacconsEntity;

import java.util.Map;

public class RacconRenderer extends MobRenderer<RacconsEntity, RacconModel<RacconsEntity>> {
    private static final Map<RacconVariants, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RacconVariants.class), map -> {
                map.put(RacconVariants.NORMAL,
                        ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/raccon/raccon.png"));
                map.put(RacconVariants.RARE,
                        ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/raccon/variant/raccon_white.png"));
                map.put(RacconVariants.BROWN,
                        ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/raccon/variant/raccon_brown.png"));
            });

    public RacconRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RacconModel<>(pContext.bakeLayer(RacconModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(RacconsEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(RacconsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f , 0.5f);
        } else {
            pPoseStack.scale(1f, 1f , 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
