package com.fnkee.solidrocks.setup;

import com.fnkee.solidrocks.SolidRocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
	public static final class Blocks {
		public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
		public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
		
		//Stone
		public static final ITag.INamedTag<Block> STONE_LOOSE_STONE = forge("stone/loose_stone");
		public static final ITag.INamedTag<Block> STONE_HARD_STONE = forge("stone/hard_stone");
		public static final ITag.INamedTag<Block> STONE_STURDY_STONE = forge("stone/sturdy_stone");
		public static final ITag.INamedTag<Block> STONE_SOLID_STONE = forge("stone/solid_stone");
		
		//Ore
		public static final ITag.INamedTag<Block> ORES_LOOSE_COAL = forge("ores/coal/loose_coal");
		public static final ITag.INamedTag<Block> ORES_HARD_COAL = forge("ores/coal/hard_coal");
		public static final ITag.INamedTag<Block> ORES_STURDY_COAL = forge("ores/coal/sturdy_coal");
		
		public static final ITag.INamedTag<Block> ORES_HARD_IRON = forge("ores/iron/hard_iron");
		public static final ITag.INamedTag<Block> ORES_STURDY_IRON = forge("ores/iron/sturdy_iron");
		public static final ITag.INamedTag<Block> ORES_SOLID_IRON = forge("ores/iron/solid_iron");
		
		public static final ITag.INamedTag<Block> ORES_HARD_GOLD = forge("ores/gold/hard_gold");
		public static final ITag.INamedTag<Block> ORES_STURDY_GOLD = forge("ores/gold/sturdy_gold");
		public static final ITag.INamedTag<Block> ORES_SOLID_GOLD = forge("ores/gold/solid_gold");

		public static final ITag.INamedTag<Block> ORES_SOLID_DIAMOND = forge("ores/diamond/solid_diamond");

		public static final ITag.INamedTag<Block> ORES_SOLID_REDSTONE = forge("ores/redstone/solid_redstone");

		public static final ITag.INamedTag<Block> ORES_STURDY_LAPIS = forge("ores/lapis/sturdy_lapis");
		public static final ITag.INamedTag<Block> ORES_SOLID_LAPIS = forge("ores/lapis/solid_lapis");
		
		//Other
		public static final ITag.INamedTag<Block> DYNAMITE = forge("dynamite");
		public static final ITag.INamedTag<Block> CHARGED_DYNAMITE = forge("charged_dynamite");
		public static final ITag.INamedTag<Block> FLIMSY_TORCH = forge("flimsy_torch");
		public static final ITag.INamedTag<Block> USED_TORCH = forge("used_torch");
		public static final ITag.INamedTag<Block> SMOLDERING_TORCH = forge("smoldering_torch");
		public static final ITag.INamedTag<Block> BURNT_OUT_TORCH = forge("burnt_out_torch");
		
		private static ITag.INamedTag<Block> forge(String path) {
	        return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
	    }
	
	    /*private static ITag.INamedTag<Block> mod(String path) {
	        return BlockTags.makeWrapperTag(new ResourceLocation(SolidRocks.MOD_ID, path).toString());
	    }*/
	}
	
	public static final class Items {
		public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
		public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
		
		//Stone
		public static final ITag.INamedTag<Item> STONE_LOOSE_STONE = forge("stone/loose_stone");
		public static final ITag.INamedTag<Item> STONE_HARD_STONE = forge("stone/hard_stone");
		public static final ITag.INamedTag<Item> STONE_STURDY_STONE = forge("stone/sturdy_stone");
		public static final ITag.INamedTag<Item> STONE_SOLID_STONE = forge("stone/solid_stone");
		
		//Ore
		public static final ITag.INamedTag<Item> ORES_LOOSE_COAL = forge("ores/coal/loose_coal");
		public static final ITag.INamedTag<Item> ORES_HARD_COAL = forge("ores/coal/hard_coal");
		public static final ITag.INamedTag<Item> ORES_STURDY_COAL = forge("ores/coal/sturdy_coal");
		
		public static final ITag.INamedTag<Item> ORES_HARD_IRON = forge("ores/iron/hard_iron");
		public static final ITag.INamedTag<Item> ORES_STURDY_IRON = forge("ores/iron/sturdy_iron");
		public static final ITag.INamedTag<Item> ORES_SOLID_IRON = forge("ores/iron/solid_iron");
		
		public static final ITag.INamedTag<Item> ORES_HARD_GOLD = forge("ores/gold/hard_gold");
		public static final ITag.INamedTag<Item> ORES_STURDY_GOLD = forge("ores/gold/sturdy_gold");
		public static final ITag.INamedTag<Item> ORES_SOLID_GOLD = forge("ores/gold/solid_gold");

		public static final ITag.INamedTag<Item> ORES_SOLID_DIAMOND = forge("ores/diamond/solid_diamond");

		public static final ITag.INamedTag<Item> ORES_SOLID_REDSTONE = forge("ores/redstone/solid_redstone");

		public static final ITag.INamedTag<Item> ORES_STURDY_LAPIS = forge("ores/lapis/sturdy_lapis");
		public static final ITag.INamedTag<Item> ORES_SOLID_LAPIS = forge("ores/lapis/solid_lapis");

		public static final ITag.INamedTag<Item> ORES_RAW_IRON = forge("ores/raw_iron");
		public static final ITag.INamedTag<Item> ORES_RAW_GOLD = forge("ores/raw_gold");
		
		//Other
		public static final ITag.INamedTag<Item> DYNAMITE = forge("dynamite");
		public static final ITag.INamedTag<Item> CHARGED_DYNAMITE = forge("charged_dynamite");
		public static final ITag.INamedTag<Item> FLIMSY_TORCH = forge("flimsy_torch");
		public static final ITag.INamedTag<Item> USED_TORCH = forge("used_torch");
		public static final ITag.INamedTag<Item> SMOLDERING_TORCH = forge("smoldering_torch");
		public static final ITag.INamedTag<Item> BURNT_OUT_TORCH = forge("burnt_out_torch");
		public static final ITag.INamedTag<Item> PEBBLE = forge("pebble");
		public static final ITag.INamedTag<Item> DIRT_PILE = forge("dirt_pile");
		public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");
		
		private static ITag.INamedTag<Item> forge(String path) {
	        return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
	    }
	
	    /*private static ITag.INamedTag<Item> mod(String path) {
	        return ItemTags.makeWrapperTag(new ResourceLocation(SolidRocks.MOD_ID, path).toString());
	    }*/
	}
}
