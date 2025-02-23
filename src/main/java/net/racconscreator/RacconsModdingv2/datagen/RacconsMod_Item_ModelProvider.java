package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

import java.util.LinkedHashMap;

public class RacconsMod_Item_ModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public RacconsMod_Item_ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RacconsModdingv2.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //combat
        handheldItem(RacconsItems.SWORDOFINK);
        handheldItem(RacconsItems.THESHEFER);
        basicItem(RacconsItems.The_Ink_Helling.get());

        //Item
        basicItem(RacconsItems.INK.get());
        basicItem(RacconsItems.RACCONS_FUR.get());
        basicItem(RacconsItems.ICON_TAB_1.get());

        //food
        basicItem(RacconsItems.COOKED_CLAM.get());
        basicItem(RacconsItems.CLAM.get());
        basicItem(RacconsItems.INKBERRY_TART.get());

        // Cape
        trimmedArmorItem(RacconsItems.Raccons_1);
        trimmedArmorItem(RacconsItems.Raccons_2);
        trimmedArmorItem(RacconsItems.Raccons_3);
        trimmedArmorItem(RacconsItems.Raccons_4);

        withExistingParent(RacconsItems.RacconSpawnEgg.getId().getPath(), mcLoc("item/template_spawn_egg"));

        saplingItem(RacconsBlocks.Blushing_Ash_Sapplings);
        saplingItem(RacconsBlocks.Black_Ink_Elm_Sappling);

        buttonItem(RacconsBlocks.Black_Ink_Elm_button, RacconsBlocks.Black_Ink_Elm_Planks);
        buttonItem(RacconsBlocks.Blushing_Ash_button, RacconsBlocks.Blushing_Ash_Planks);

        fenceItem(RacconsBlocks.Blushing_Ash_Fence, RacconsBlocks.Blushing_Ash_Planks);
        fenceItem(RacconsBlocks.Black_Ink_Elm_Fence, RacconsBlocks.Black_Ink_Elm_Planks);

        simpleBlockItem(RacconsBlocks.Blushing_Ash_Door);
        simpleBlockItem(RacconsBlocks.Black_Ink_Elm_Door);






        //end
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"block/" + item.getId().getPath()));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = RacconsModdingv2.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID,"item/" + item.getId().getPath()));
    }
}
