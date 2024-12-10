package net.racconscreator.RacconsModdingv2.RacconsModItems.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsSound.Raccons_Sounds;

import java.util.List;
import java.util.Map;

public class SchyteofInk_Item extends Item {
    private static final Map<Block, Block> SchyteofInk_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.GLASS, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.STONE, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.DIORITE, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.ANDESITE, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.DIRT, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.NETHERRACK, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.BLACKSTONE, RacconsBlocks.INK_PORTAL.get(),
                    Blocks.TALL_GRASS, RacconsBlocks.INK_PORTAL.get()


            );
    public SchyteofInk_Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(SchyteofInk_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), SchyteofInk_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), Raccons_Sounds.SCYTHEOFINK_USE.get(), SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.schytheofink.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.racconsmodid.schytheofink"));
        }
    }
}

