package net.racconscreator.RacconsModdingv2.event;


import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.entity.Raccons_Entities;
import net.racconscreator.RacconsModdingv2.entity.client.RacconAnimations;
import net.racconscreator.RacconsModdingv2.entity.client.RacconModel;
import net.racconscreator.RacconsModdingv2.entity.custom.RacconsEntity;

@Mod.EventBusSubscriber(modid = RacconsModdingv2.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Raccons_EventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RacconModel.LAYER_LOCATION, RacconModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Raccons_Entities.RACCON.get(), RacconsEntity.createAttribute().build());

    }
}
