package net.racconscreator.RacconsModdingv2.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.racconscreator.RacconsModdingv2.RacconsModdingv2;

public class RacconsTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NETH_TOOL = createTag("needs_neth_tool");
        public static final TagKey<Block> INCORRECT_TOOL = createTag("incorrect_tool");


            public static TagKey<Block> createTag(String name) {
                return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, name));
            }
        }




    public static class Items {

        public static TagKey<Item> createTag (String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RacconsModdingv2.MODID, name));
        }
    }
}
