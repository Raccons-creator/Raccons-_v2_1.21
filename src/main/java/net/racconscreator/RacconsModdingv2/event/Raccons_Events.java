package net.racconscreator.RacconsModdingv2.event;


import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

@Mod.EventBusSubscriber(modid = RacconsModdingv2.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Raccons_Events {


    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if(event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if(player.getMainHandItem().getItem() == RacconsItems.INK.get()) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + ") TEST OF THE DEATH OF ANCIENT RACCON KING"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 5));
                player.getMainHandItem().shrink(1);
            }
            if(player.getMainHandItem().getItem() == RacconsItems.THESHEFER.get()) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + ") TEST OF THE DEATH OF ANCIENT RACCON KING"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 5));
                player.getMainHandItem().shrink(0);
            }
            if(player.getMainHandItem().getItem() == RacconsItems.SCYTHEOFINK.get()) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + ") TEST OF THE DEATH OF ANCIENT RACCON KING"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 5));
                player.getMainHandItem().shrink(0);
            }
            if(player.getMainHandItem().getItem() == RacconsItems.SWORDOFINK.get()) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + ") TEST OF THE DEATH OF ANCIENT RACCON KING"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 5));
                player.getMainHandItem().shrink(0);
            }
            if(player.getMainHandItem().getItem() == RacconsItems.INK.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 255));
            }
        }
    }
}