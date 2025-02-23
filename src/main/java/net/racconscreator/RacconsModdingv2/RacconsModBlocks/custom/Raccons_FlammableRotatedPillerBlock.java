package net.racconscreator.RacconsModdingv2.RacconsModBlocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import org.jetbrains.annotations.Nullable;

public class Raccons_FlammableRotatedPillerBlock extends RotatedPillarBlock {
    public Raccons_FlammableRotatedPillerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 7;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 7;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {

            if(state.is(RacconsBlocks.Blushing_Ash_Log.get())) {
                return RacconsBlocks.Stripped_Blushing_Ash_log.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(RacconsBlocks.Blushing_Ash_Wood.get())) {
                return RacconsBlocks.Stripped_Blushing_Ash_wood.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            //Black Ink Elm =3
            if(state.is(RacconsBlocks.Black_Ink_Elm_Log.get())) {
                return RacconsBlocks.Stripped_Black_Ink_Elm_log.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(RacconsBlocks.Black_Ink_Elm_Wood.get())) {
                return RacconsBlocks.Stripped_Black_Ink_Elm_wood.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
