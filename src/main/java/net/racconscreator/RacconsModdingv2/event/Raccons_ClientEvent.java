package net.racconscreator.RacconsModdingv2.event;


import net.minecraft.advancements.critereon.UsedTotemTrigger;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

@Mod.EventBusSubscriber(modid = RacconsModdingv2.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class Raccons_ClientEvent {
    @SubscribeEvent
    public static void onComputerFovModifierEvent(ComputeFovModifierEvent event) {
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == RacconsItems.THE_BIG_CANNON.get()) {
            float fovModifier = 1f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 20f;
            if(deltaTicks > 1f) {
                deltaTicks = 1f;
            } else {
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == RacconsItems.TTT.get()) {
            float fovModifier = 0.5f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 10f;
            if(deltaTicks > 0.5f) {
                deltaTicks = 0.5f;
            } else {
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 0.5f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == RacconsItems.LunarFlare.get()) {
            float fovModifier = 1.2f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 10f;
            if(deltaTicks > 1.2f) {
                deltaTicks = 1.2f;
            } else {
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 1.2f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}
