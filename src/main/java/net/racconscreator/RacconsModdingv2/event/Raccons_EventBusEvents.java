package net.racconscreator.RacconsModdingv2.event;


import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.ai.behavior.TryLaySpawnOnWaterNearLand;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;
import net.racconscreator.RacconsModdingv2.entity.client.Ink_Blight_Model;
import net.racconscreator.RacconsModdingv2.entity.client.RacconModel;
import net.racconscreator.RacconsModdingv2.entity.client.TTTProjectileEntityModel;
import net.racconscreator.RacconsModdingv2.entity.custom.INKBlight;
import net.racconscreator.RacconsModdingv2.entity.custom.RacconsEntity;

@Mod.EventBusSubscriber(modid = RacconsModdingv2.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Raccons_EventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RacconModel.LAYER_LOCATION, RacconModel::createBodyLayer);
        event.registerLayerDefinition(Ink_Blight_Model.LAYER_LOCATION, Ink_Blight_Model::createBodyLayer);
        event.registerLayerDefinition(TTTProjectileEntityModel.LAYER_LOCATION, TTTProjectileEntityModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Raccons_Entities.RACCON.get(), RacconsEntity.createAttribute().build());
        event.put(Raccons_Entities.Ink_Blight.get(), INKBlight.createAttribu().build());

    }
    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(Raccons_Entities.RACCON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
