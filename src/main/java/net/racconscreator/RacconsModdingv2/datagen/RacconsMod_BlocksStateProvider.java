package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

public class RacconsMod_BlocksStateProvider extends BlockStateProvider {
    public RacconsMod_BlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RacconsModdingv2.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        trapdoorBlockWithRenderType(RacconsBlocks.INK_PORTAL.get(), modLoc("block/ink_portal"), true, "cutout");
        trapdoorBlockWithRenderType(RacconsBlocks.INK_SLIDE.get(), modLoc("block/ink_slide"), true, "cutout");
        trapdoorBlockWithRenderType(RacconsBlocks.INK_MELT.get(), modLoc("block/ink_melt"), true, "cutout");

        blockItem(RacconsBlocks.INK_PORTAL, "_bottom");
        blockItem(RacconsBlocks.INK_SLIDE, "_bottom");
        blockItem(RacconsBlocks.INK_MELT, "_bottom");


        //Blushing Ash Tree
        logBlock(RacconsBlocks.Blushing_Ash_Log.get());
        logBlock(RacconsBlocks.Stripped_Blushing_Ash_log.get());

        axisBlock(RacconsBlocks.Blushing_Ash_Wood.get(), blockTexture(RacconsBlocks.Blushing_Ash_Log.get()), blockTexture(RacconsBlocks.Blushing_Ash_Log.get()));
        axisBlock(RacconsBlocks.Stripped_Blushing_Ash_wood.get(), blockTexture(RacconsBlocks.Stripped_Blushing_Ash_log.get()), blockTexture(RacconsBlocks.Stripped_Blushing_Ash_log.get()));

        blockItem(RacconsBlocks.Blushing_Ash_Log);
        blockItem(RacconsBlocks.Blushing_Ash_Wood);
        blockItem(RacconsBlocks.Stripped_Blushing_Ash_log);
        blockItem(RacconsBlocks.Stripped_Blushing_Ash_wood);

        blockwithItem(RacconsBlocks.Blushing_Ash_Planks);

        leavesBlock(RacconsBlocks.Blushing_Ash_Leaves);
        saplingBlock(RacconsBlocks.Blushing_Ash_Sapplings);

        //Black Ink Elm
        logBlock(RacconsBlocks.Black_Ink_Elm_Log.get());
        logBlock(RacconsBlocks.Stripped_Black_Ink_Elm_log.get());

        axisBlock(RacconsBlocks.Black_Ink_Elm_Wood.get(), blockTexture(RacconsBlocks.Black_Ink_Elm_Log.get()), blockTexture(RacconsBlocks.Black_Ink_Elm_Log.get()));
        axisBlock(RacconsBlocks.Stripped_Black_Ink_Elm_wood.get(), blockTexture(RacconsBlocks.Stripped_Black_Ink_Elm_log.get()), blockTexture(RacconsBlocks.Stripped_Black_Ink_Elm_log.get()));

        blockItem(RacconsBlocks.Black_Ink_Elm_Log);
        blockItem(RacconsBlocks.Black_Ink_Elm_Wood);
        blockItem(RacconsBlocks.Stripped_Black_Ink_Elm_log);
        blockItem(RacconsBlocks.Stripped_Black_Ink_Elm_wood);

        blockwithItem(RacconsBlocks.Black_Ink_Elm_Planks);

        leavesBlock(RacconsBlocks.Black_Ink_Elm_Leaves);
        saplingBlock(RacconsBlocks.Black_Ink_Elm_Sappling);


        //Blushing Ash Multiple things =3
        stairsBlock(RacconsBlocks.Blushing_Ash_Stairs.get(),
                blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()));
        blockItem(RacconsBlocks.Blushing_Ash_Stairs);
        slabBlock(RacconsBlocks.Blushing_Ash_Slab.get(), blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()), blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()));

        buttonBlock(RacconsBlocks.Blushing_Ash_button.get(),
                blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()));
        pressurePlateBlock(RacconsBlocks.Blushing_Ash_pressure_plate.get(),
                blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()));

        fenceBlock(RacconsBlocks.Blushing_Ash_Fence.get(),
                blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()));
        fenceGateBlock(RacconsBlocks.Blushing_Ash_Fence_Gate.get(),
                blockTexture(RacconsBlocks.Blushing_Ash_Planks.get()));

        doorBlockWithRenderType(RacconsBlocks.Blushing_Ash_Door.get(),
                modLoc("block/blushing_ash_door_bottom"), modLoc("block/blushing_ash_door_top"),"cutout");
        trapdoorBlockWithRenderType(RacconsBlocks.Blushing_Ash_TrapDoor.get(),
               modLoc("block/blushing_ash_trapdoor"), true, "cutout");

        blockItem(RacconsBlocks.Blushing_Ash_Slab);
        blockItem(RacconsBlocks.Blushing_Ash_pressure_plate);
        blockItem(RacconsBlocks.Blushing_Ash_Fence_Gate);
        blockItem(RacconsBlocks.Blushing_Ash_TrapDoor, "_bottom");



        //Black Ink Elm Multiple things =3
        stairsBlock(RacconsBlocks.Black_Ink_Elm_Stairs.get(),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()));
        blockItem(RacconsBlocks.Black_Ink_Elm_Stairs);
        
        slabBlock(RacconsBlocks.Black_Ink_Elm_Slab.get(),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()));

        buttonBlock(RacconsBlocks.Black_Ink_Elm_button.get(),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()));
        pressurePlateBlock(RacconsBlocks.Black_Ink_Elm_pressure_plate.get(),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()));

        fenceBlock(RacconsBlocks.Black_Ink_Elm_Fence.get(),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()));
        fenceGateBlock(RacconsBlocks.Black_Ink_Elm_Fence_Gate.get(),
                blockTexture(RacconsBlocks.Black_Ink_Elm_Planks.get()));

        doorBlockWithRenderType(RacconsBlocks.Black_Ink_Elm_Door.get(),
                modLoc("block/black_ink_elm_door_bottom"), modLoc("block/black_ink_elm_door_top"),"cutout");
        trapdoorBlockWithRenderType(RacconsBlocks.Black_Ink_Elm_TrapDoor.get(),
                modLoc("block/black_ink_elm_trapdoor"), true, "cutout");

        blockItem(RacconsBlocks.Black_Ink_Elm_Slab);
        blockItem(RacconsBlocks.Black_Ink_Elm_pressure_plate);
        blockItem(RacconsBlocks.Black_Ink_Elm_Fence_Gate);
        blockItem(RacconsBlocks.Black_Ink_Elm_TrapDoor, "_bottom");
    }


    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockwithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("racconsmodid:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("racconsmodid:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
