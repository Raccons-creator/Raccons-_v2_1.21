package net.racconscreator.RacconsModdingv2.RacconsModItems.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.racconscreator.RacconsModdingv2.effect.Raccons_Effects;
import java.util.List;


public class TheShefer_Item extends Item {
    public TheShefer_Item(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.theshefer.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.theshefer"));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.playSound(SoundEvents.ANVIL_BREAK, 1.0F, 1.0F);
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        pPlayer.addEffect(new MobEffectInstance(Raccons_Effects.TheShefer_EFFECT.getHolder().get(), 50, 1, false, false, false));
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }
}
