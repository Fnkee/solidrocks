package com.fnkee.solidrocks.data;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModItems;
import com.fnkee.solidrocks.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,	ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, SolidRocks.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
		copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
		
		//Stone
		copy(ModTags.Blocks.STONE_LOOSE_STONE, ModTags.Items.STONE_LOOSE_STONE);
		copy(ModTags.Blocks.STONE_HARD_STONE, ModTags.Items.STONE_HARD_STONE);
		copy(ModTags.Blocks.STONE_STURDY_STONE, ModTags.Items.STONE_STURDY_STONE);
		copy(ModTags.Blocks.STONE_SOLID_STONE, ModTags.Items.STONE_SOLID_STONE);

		//Ores
		copy(ModTags.Blocks.ORES_LOOSE_COAL, ModTags.Items.ORES_LOOSE_COAL);
		copy(ModTags.Blocks.ORES_HARD_COAL, ModTags.Items.ORES_HARD_COAL);
		copy(ModTags.Blocks.ORES_STURDY_COAL, ModTags.Items.ORES_STURDY_COAL);
		
		copy(ModTags.Blocks.ORES_HARD_IRON, ModTags.Items.ORES_HARD_IRON);
		copy(ModTags.Blocks.ORES_STURDY_IRON, ModTags.Items.ORES_STURDY_IRON);
		copy(ModTags.Blocks.ORES_SOLID_IRON, ModTags.Items.ORES_SOLID_IRON);
		
		copy(ModTags.Blocks.ORES_HARD_GOLD, ModTags.Items.ORES_HARD_GOLD);
		copy(ModTags.Blocks.ORES_STURDY_GOLD, ModTags.Items.ORES_STURDY_GOLD);
		copy(ModTags.Blocks.ORES_SOLID_GOLD, ModTags.Items.ORES_SOLID_GOLD);

		copy(ModTags.Blocks.ORES_SOLID_DIAMOND, ModTags.Items.ORES_SOLID_DIAMOND);

		copy(ModTags.Blocks.ORES_SOLID_REDSTONE, ModTags.Items.ORES_SOLID_REDSTONE);

		copy(ModTags.Blocks.ORES_STURDY_LAPIS, ModTags.Items.ORES_STURDY_LAPIS);
		copy(ModTags.Blocks.ORES_SOLID_LAPIS, ModTags.Items.ORES_SOLID_LAPIS);

		//Other
		copy(ModTags.Blocks.DYNAMITE, ModTags.Items.DYNAMITE);
		copy(ModTags.Blocks.CHARGED_DYNAMITE, ModTags.Items.CHARGED_DYNAMITE);
		
		copy(ModTags.Blocks.FLIMSY_TORCH, ModTags.Items.FLIMSY_TORCH);
		copy(ModTags.Blocks.USED_TORCH, ModTags.Items.USED_TORCH);
		copy(ModTags.Blocks.SMOLDERING_TORCH, ModTags.Items.SMOLDERING_TORCH);
		copy(ModTags.Blocks.BURNT_OUT_TORCH, ModTags.Items.BURNT_OUT_TORCH);
		//copy(ModTags.Blocks.FLIMSY_WALL_TORCH, ModTags.Items.FLIMSY_WALL_TORCH);
		//copy(ModTags.Blocks.USED_WALL_TORCH, ModTags.Items.USED_WALL_TORCH);
		//copy(ModTags.Blocks.SMOLDERING_WALL_TORCH, ModTags.Items.SMOLDERING_WALL_TORCH);
		//copy(ModTags.Blocks.BURNT_OUT_WALL_TORCH, ModTags.Items.BURNT_OUT_WALL_TORCH);
		
		//Categories
		copy(Tags.Blocks.ORES, Tags.Items.ORES);
		copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
		copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
		copy(Tags.Blocks.ORES_GOLD, Tags.Items.ORES_GOLD);
		copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);
		copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
		copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		copy(Tags.Blocks.STONE, Tags.Items.STONE);
		
		getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
		getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
		
		getOrCreateBuilder(ModTags.Items.PEBBLE).add(ModItems.PEBBLE.get());
		getOrCreateBuilder(ModTags.Items.DIRT_PILE).add(ModItems.DIRT_PILE.get());
		getOrCreateBuilder(ModTags.Items.ORES_RAW_IRON).add(ModItems.RAW_IRON.get());
		getOrCreateBuilder(Tags.Items.ORES).addTag(ModTags.Items.ORES_RAW_IRON);
		getOrCreateBuilder(ModTags.Items.ORES_RAW_GOLD).add(ModItems.RAW_GOLD.get());
		getOrCreateBuilder(Tags.Items.ORES).addTag(ModTags.Items.ORES_RAW_GOLD);
		
	}
}
