package net.racconscreator.RacconsModdingv2.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.custom.RacconsEntity;

public class RacconRenderer extends MobRenderer<RacconsEntity, RacconModel<RacconsEntity>> {
    public RacconRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RacconModel<>(pContext.bakeLayer(RacconModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(RacconsEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/raccon/raccon.png");
    }

    @Override
    public void render(RacconsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.4f, 0.4f , 0.4f);
        } else {
            pPoseStack.scale(1f, 1f , 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
