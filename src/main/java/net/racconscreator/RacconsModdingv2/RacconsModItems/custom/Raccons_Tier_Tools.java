package net.racconscreator.RacconsModdingv2.RacconsModItems.custom;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.racconscreator.RacconsModdingv2.RacconsModItems.RacconsItems;
import net.racconscreator.RacconsModdingv2.util.RacconsTags;

public class Raccons_Tier_Tools {
    public static final Tier SST = new ForgeTier(2987,5, 24f,20,
            RacconsTags.Blocks.NEEDS_NETH_TOOL, () -> Ingredient.of(Items.NETHERITE_SCRAP),
            RacconsTags.Blocks.INCORRECT_TOOL);
}
