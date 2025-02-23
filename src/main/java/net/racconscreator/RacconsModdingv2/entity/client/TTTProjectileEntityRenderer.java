package net.racconscreator.RacconsModdingv2.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.custom.TTTProjectileEntity;

public class TTTProjectileEntityRenderer extends EntityRenderer<TTTProjectileEntity> {
    private TTTProjectileEntityModel model;

    public TTTProjectileEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new TTTProjectileEntityModel(pContext.bakeLayer(TTTProjectileEntityModel.LAYER_LOCATION));
    }

    @Override
    public void render(TTTProjectileEntity pEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        if(!pEntity.isGrounded()) {
            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.yRotO, pEntity.getYRot())));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.getRenderingRotation() * 5f));
            poseStack.translate(0, -1.0f, 0);
        } else {
            poseStack.mulPose(Axis.YP.rotationDegrees(pEntity.groundedOffset.y));
            poseStack.mulPose(Axis.XP.rotationDegrees(pEntity.groundedOffset.x));
            poseStack.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)),false, false);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(TTTProjectileEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "textures/entity/ttt/ttt.png");
    }
}
