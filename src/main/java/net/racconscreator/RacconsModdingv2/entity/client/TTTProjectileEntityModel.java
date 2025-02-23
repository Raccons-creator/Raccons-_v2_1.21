package net.racconscreator.RacconsModdingv2.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.custom.TTTProjectileEntity;

import javax.swing.text.html.parser.Entity;

public class TTTProjectileEntityModel extends EntityModel<TTTProjectileEntity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "ttt"), "main");
    private final ModelPart group;
    private final ModelPart TTT;
    private final ModelPart pino;
    private final ModelPart group2;

    public TTTProjectileEntityModel(ModelPart root) {
        this.group = root.getChild("group");
        this.TTT = this.group.getChild("TTT");
        this.pino = this.TTT.getChild("pino");
        this.group2 = this.TTT.getChild("group2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, -1.0F));

        PartDefinition TTT = group.addOrReplaceChild("TTT", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition pino = TTT.addOrReplaceChild("pino", CubeListBuilder.create(), PartPose.offset(3.0F, -1.0F, -2.0F));

        PartDefinition cube_r1 = pino.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 9).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 8).addBox(-2.0F, 0.0F, 2.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 11).addBox(-2.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = pino.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 10).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition group2 = TTT.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(12, 0).addBox(-3.0F, -8.0F, 1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -17.0F, 0.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(-4.0F, -1.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 8.0F, -2.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(TTTProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        group.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
