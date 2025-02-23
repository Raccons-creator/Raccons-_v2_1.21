package net.racconscreator.RacconsModdingv2.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.definitions.WardenAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.custom.INKBlight;

public class Ink_Blight_Model<T extends INKBlight> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, "ink_bbb"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public Ink_Blight_Model(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-5.0F, -7.0F, -6.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(18, 47).addBox(-2.0F, -3.0F, -9.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(52, 34).addBox(-8.0F, -3.0F, -4.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(52, 37).addBox(5.0F, -3.0F, -4.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(52, 30).addBox(-1.3809F, -2.0F, -0.7495F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -8.0F, -4.0F, 0.0F, 0.4363F, 0.0F));

        PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(50, 26).addBox(-1.6191F, -2.0F, -0.7495F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -8.0F, -4.0F, 0.0F, -0.4363F, 0.0F));

        PartDefinition leg0 = body.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(32, 47).addBox(-0.005F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 2.0F, 6.0F));

        PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(40, 47).addBox(0.005F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, 6.0F));

        PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(48, 47).addBox(-0.005F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 2.0F, -1.0F));

        PartDefinition leg3 = body.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(50, 16).addBox(0.005F, -2.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, -1.0F));

        PartDefinition tails = body.addOrReplaceChild("tails", CubeListBuilder.create().texOffs(30, 0).addBox(-3.0F, 6.8452F, -0.4374F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(32, 16).addBox(-2.0F, 15.8452F, 0.8126F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 3.0F, 2.0071F, 0.0F, 0.0F));

        PartDefinition tail3 = body.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(26, 31).addBox(-3.0F, 6.0F, -0.25F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 47).addBox(-2.0F, 15.0F, 1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 1.5708F, 0.5236F, 0.0F));

        PartDefinition tail2 = body.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 31).addBox(-3.0F, 6.0F, -0.25F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(32, 23).addBox(-2.0F, 15.0F, 1.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 1.5708F, -0.5236F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    //Anim
    @Override
    public void setupAnim(INKBlight entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(Ink_Blight_Animations.WALKING, limbSwing, limbSwingAmount, 1.5f, 2.5f);
        this.animate(entity.idleAnim, Ink_Blight_Animations.IDLE, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }


    //Head Anim
    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
