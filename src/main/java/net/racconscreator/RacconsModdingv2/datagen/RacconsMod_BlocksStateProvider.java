package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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
