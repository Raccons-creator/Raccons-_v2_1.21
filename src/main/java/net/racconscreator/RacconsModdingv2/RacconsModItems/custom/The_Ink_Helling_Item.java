package net.racconscreator.RacconsModdingv2.RacconsModItems.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class The_Ink_Helling_Item extends Item {

    public The_Ink_Helling_Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.getCooldowns().addCooldown(this, 180);
        pPlayer.playSound(SoundEvents.TOTEM_USE, 0.5F, 0.5F);
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3700, 2, false, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3700, 2, false, false, false));
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.the_ink_helling.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.the_ink_helling"));
        }
    }
}
