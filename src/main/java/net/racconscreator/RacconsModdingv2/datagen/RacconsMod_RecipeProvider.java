package net.racconscreator.RacconsModdingv2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.racconscreator.RacconsModdingv2.RacconsModBlocks.RacconsBlocks;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RacconsMod_RecipeProvider extends RecipeProvider implements IConditionBuilder {
    public RacconsMod_RecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> CLAM_SMELTABLE = List.of(RacconsItems.CLAM.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RacconsBlocks.INK_SLIDE.get())
                .define('A', RacconsItems.INK.get())
                .define('X', DyeItem.byColor(DyeColor.BLACK))
                .pattern("   ")
                .pattern("AXA")
                .pattern("   ")
                .unlockedBy(getHasName(RacconsItems.INK.get()), has(RacconsItems.INK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RacconsItems.Raccons_MASK_GLOW.get())
                .define('A', RacconsItems.Raccons_MASK.get())
                .define('X', Items.GLOW_INK_SAC)
                .pattern(" X ")
                .pattern("XAX")
                .pattern(" X ")
                .unlockedBy(getHasName(RacconsItems.Raccons_MASK.get()), has(RacconsItems.Raccons_MASK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RacconsItems.INKBERRY_TART.get())
                .define('A', Items.PUMPKIN_PIE)
                .define('X', Items.INK_SAC)
                .define('Z', Items.SWEET_BERRIES)
                .pattern("XZX")
                .pattern("ZAZ")
                .pattern("XZX")
                .unlockedBy(getHasName(Items.PUMPKIN_PIE), has(Items.PUMPKIN_PIE)).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RacconsItems.The_Ink_Helling.get())
                .define('A', Items.NETHERITE_INGOT)
                .define('X', Items.GOLD_INGOT)
                .define('Z', Items.NETHER_WART)
                .define('M', Items.SUGAR)
                .define('B', Items.BLAZE_POWDER)
                .define('H', Items.EXPERIENCE_BOTTLE)
                .define('L', RacconsItems.INK.get())
                .pattern("MXB")
                .pattern("ZAZ")
                .pattern("LHL")
                .unlockedBy(getHasName(RacconsItems.INK.get()), has(RacconsItems.INK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, CLAM_SMELTABLE, RecipeCategory.MISC, RacconsItems.COOKED_CLAM.get(), 0.25f, 200, "cooked_clam");
        Campfirecooking(pRecipeOutput, CLAM_SMELTABLE, RecipeCategory.MISC, RacconsItems.COOKED_CLAM.get(), 1f, 105, "cooked_clam");


        stairBuilder(RacconsBlocks.Blushing_Ash_Stairs.get(), Ingredient.of(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).group("alexandrite")
                .unlockedBy(getHasName(RacconsBlocks.Blushing_Ash_Planks.get().asItem()), has(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, RacconsBlocks.Blushing_Ash_Slab.get(), RacconsBlocks.Blushing_Ash_Planks.get().asItem());

        buttonBuilder(RacconsBlocks.Blushing_Ash_button.get(), Ingredient.of(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).group("alexandrite")
                .unlockedBy(getHasName(RacconsBlocks.Blushing_Ash_Planks.get().asItem()), has(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, RacconsBlocks.Blushing_Ash_pressure_plate.get(),RacconsBlocks.Blushing_Ash_Planks.get().asItem());

        fenceBuilder(RacconsBlocks.Blushing_Ash_Fence.get(), Ingredient.of(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).group("alexandrite")
                .unlockedBy(getHasName(RacconsBlocks.Blushing_Ash_Planks.get().asItem()), has(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).save(pRecipeOutput);
        fenceGateBuilder(RacconsBlocks.Blushing_Ash_Fence_Gate.get(), Ingredient.of(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).group("alexandrite")
                .unlockedBy(getHasName(RacconsBlocks.Blushing_Ash_Planks.get().asItem()), has(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, RacconsBlocks.Blushing_Ash_Planks.get().asItem(), RacconsBlocks.Blushing_Ash_Planks.get().asItem());

        doorBuilder(RacconsBlocks.Blushing_Ash_Door.get(), Ingredient.of(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).group("alexandrite")
                .unlockedBy(getHasName(RacconsBlocks.Blushing_Ash_Planks.get().asItem()), has(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).save(pRecipeOutput);
        trapdoorBuilder(RacconsBlocks.Blushing_Ash_TrapDoor.get(), Ingredient.of(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).group("alexandrite")
                .unlockedBy(getHasName(RacconsBlocks.Blushing_Ash_Planks.get().asItem()), has(RacconsBlocks.Blushing_Ash_Planks.get().asItem())).save(pRecipeOutput);







    }
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void Campfirecooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire_cooking");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, RacconsModdingv2.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
