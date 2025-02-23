package net.racconscreator.RacconsModdingv2.RacconsModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.custom.Ink_Slide_BLOCK;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.custom.Raccons_FlammableRotatedPillerBlock;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;
import net.racconscreator.RacconsModdingv2.RacconsSound.Raccons_Sounds;
import net.racconscreator.RacconsModdingv2.worldgen.tree.Raccons_TreeGrowers;

import java.util.function.Supplier;

public class RacconsBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RacconsModdingv2.MODID);

    public static final RegistryObject<TrapDoorBlock> INK_PORTAL = registryBlock("ink_portal",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .sound(Raccons_Sounds.INK_PORTAL_SOUNDS)
                    .noCollission()
                    .instabreak()
                    .explosionResistance(2)
                    .noOcclusion()
            ));

    public static final RegistryObject<TrapDoorBlock> INK_SLIDE = registryBlock("ink_slide",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .sound(Raccons_Sounds.INK_SLIDE_SOUNDS)
                    .friction(2.29f)
                    .instabreak()
                    .jumpFactor(0.2f)
                    .explosionResistance(5)
            ));

    public static final RegistryObject<TrapDoorBlock> INK_MELT = registryBlock("ink_melt",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .sound(Raccons_Sounds.INK_MELT_SOUNDS)
                    .destroyTime(5)
                    .jumpFactor(0.18f)
                    .explosionResistance(5)
                    .speedFactor(0.2F)
                    .noLootTable()
            ));


    public static final RegistryObject<Block> TEST_BLOCK = registryBlock("test_block",
            () -> new Ink_Slide_BLOCK(BlockBehaviour.Properties.of()
                    .sound(SoundType.FROGLIGHT)
                    .destroyTime(0)
                    .jumpFactor(0.18f)
                    .explosionResistance(5)
                    .speedFactor(0.2F)
                    .noOcclusion()
                    .noLootTable()
            ));



    // Blushing Ash Tree blocks =3

    public static final RegistryObject<RotatedPillarBlock> Blushing_Ash_Log = registryBlock("blushing_ash_log",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)));

    public static final RegistryObject<RotatedPillarBlock> Blushing_Ash_Wood = registryBlock("blushing_ash_wood",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> Stripped_Blushing_Ash_log = registryBlock("stripped_blushing_ash_log",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));

    public static final RegistryObject<RotatedPillarBlock> Stripped_Blushing_Ash_wood = registryBlock("stripped_blushing_ash_wood",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));


    public static final RegistryObject<Block> Blushing_Ash_Planks = registryBlock("blushing_ash_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<Block> Blushing_Ash_Leaves = registryBlock("blushing_ash_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES).noCollission()) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 70;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 35;
                }

                @Override
                public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
                    super.animateTick(blockState, level, blockPos, randomSource);
                    if (randomSource.nextInt(10) == 0) {
                        BlockPos blockpos = blockPos.below();
                        BlockState blockstate = level.getBlockState(blockpos);
                        if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                            ParticleUtils.spawnParticleBelow(level, blockpos, randomSource, ParticleTypes.CHERRY_LEAVES);
                        }
                    }
                }

                @Override
                protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
                    Vec3 vec3 = new Vec3(0.35, 0.08F, 0.35);
                    pEntity.makeStuckInBlock(pState, vec3);
                }
            });

    public static final RegistryObject<Block> Blushing_Ash_Sapplings = registryBlock("blushing_ash_sapplings",
            () -> new SaplingBlock(Raccons_TreeGrowers.Blushing_Ash, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SAPLING)));

    //Blushing Ash Planks welping =3

    public static final RegistryObject<StairBlock> Blushing_Ash_Stairs = registryBlock("blushing_ash_stairs",
            () -> new StairBlock(RacconsBlocks.Blushing_Ash_Planks.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<SlabBlock> Blushing_Ash_Slab = registryBlock("blushing_ash_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<PressurePlateBlock> Blushing_Ash_pressure_plate = registryBlock("blushing_ash_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PRESSURE_PLATE)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<ButtonBlock> Blushing_Ash_button = registryBlock("blushing_ash_button",
            () -> new ButtonBlock(BlockSetType.BIRCH, 2,BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_BUTTON).noCollission()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<FenceBlock> Blushing_Ash_Fence = registryBlock("blushing_ash_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<FenceGateBlock> Blushing_Ash_Fence_Gate = registryBlock("blushing_ash_fence_gate",
            () -> new FenceGateBlock(WoodType.BIRCH,BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<DoorBlock> Blushing_Ash_Door = registryBlock("blushing_ash_door",
            () -> new DoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_DOOR).noOcclusion()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    public static final RegistryObject<TrapDoorBlock> Blushing_Ash_TrapDoor = registryBlock("blushing_ash_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_TRAPDOOR).noOcclusion()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 28;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 7;
                }
            });

    //Black Ink Elm

    public static final RegistryObject<RotatedPillarBlock> Black_Ink_Elm_Log = registryBlock("black_ink_elm_log",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> Black_Ink_Elm_Wood = registryBlock("black_ink_elm_wood",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> Stripped_Black_Ink_Elm_log = registryBlock("stripped_black_ink_elm_log",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_LOG)));

    public static final RegistryObject<RotatedPillarBlock> Stripped_Black_Ink_Elm_wood = registryBlock("stripped_black_ink_elm_wood",
            () -> new Raccons_FlammableRotatedPillerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_WOOD)));


    public static final RegistryObject<Block> Black_Ink_Elm_Planks = registryBlock("black_ink_elm_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<Block> Black_Ink_Elm_Leaves = registryBlock("black_ink_elm_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES).noCollission()) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 100;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
                    super.animateTick(blockState, level, blockPos, randomSource);
                    if (randomSource.nextInt(10) == 0) {
                        BlockPos blockpos = blockPos.below();
                        BlockState blockstate = level.getBlockState(blockpos);
                        if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                            ParticleUtils.spawnParticleBelow(level, blockpos, randomSource, ParticleTypes.CHERRY_LEAVES);
                        }
                    }
                }

                @Override
                protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
                    Vec3 vec3 = new Vec3(0.4, 0.2F, 0.4);
                    pEntity.makeStuckInBlock(pState, vec3);
                }
            });



    public static final RegistryObject<Block> Black_Ink_Elm_Sappling = registryBlock("black_ink_elm_sappling",
            () -> new SaplingBlock(Raccons_TreeGrowers.Black_Ink_Elm, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));


    //Black Ink Elm Planks welping =3

    public static final RegistryObject<StairBlock> Black_Ink_Elm_Stairs = registryBlock("black_ink_elm_stairs",
            () -> new StairBlock(RacconsBlocks.Black_Ink_Elm_Planks.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<SlabBlock> Black_Ink_Elm_Slab = registryBlock("black_ink_elm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<PressurePlateBlock> Black_Ink_Elm_pressure_plate = registryBlock("black_ink_elm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PRESSURE_PLATE)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<ButtonBlock> Black_Ink_Elm_button = registryBlock("black_ink_elm_button",
            () -> new ButtonBlock(BlockSetType.DARK_OAK, 2,BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_BUTTON).noCollission()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<FenceBlock> Black_Ink_Elm_Fence = registryBlock("black_ink_elm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<FenceGateBlock> Black_Ink_Elm_Fence_Gate = registryBlock("black_ink_elm_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE_GATE)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<DoorBlock> Black_Ink_Elm_Door = registryBlock("black_ink_elm_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_DOOR).noOcclusion()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });

    public static final RegistryObject<TrapDoorBlock> Black_Ink_Elm_TrapDoor = registryBlock("black_ink_elm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_TRAPDOOR).noOcclusion()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 45;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 10;
                }
            });


    //end
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T>block) {
        RacconsItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
