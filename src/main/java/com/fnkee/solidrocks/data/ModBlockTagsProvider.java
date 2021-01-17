package com.fnkee.solidrocks.data;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModBlocks;
import com.fnkee.solidrocks.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, SolidRocks.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SILVER);
		getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModBlocks.SILVER_BLOCK.get());
		getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER);
		
		//Stone
		getOrCreateBuilder(ModTags.Blocks.STONE_LOOSE_STONE).add(ModBlocks.LOOSE_STONE.get());
		getOrCreateBuilder(Tags.Blocks.STONE).addTag(ModTags.Blocks.STONE_LOOSE_STONE);
		getOrCreateBuilder(ModTags.Blocks.STONE_HARD_STONE).add(ModBlocks.HARD_STONE.get());
		getOrCreateBuilder(Tags.Blocks.STONE).addTag(ModTags.Blocks.STONE_HARD_STONE);
		getOrCreateBuilder(ModTags.Blocks.STONE_STURDY_STONE).add(ModBlocks.STURDY_STONE.get());
		getOrCreateBuilder(Tags.Blocks.STONE).addTag(ModTags.Blocks.STONE_STURDY_STONE);
		getOrCreateBuilder(ModTags.Blocks.STONE_SOLID_STONE).add(ModBlocks.SOLID_STONE.get());
		getOrCreateBuilder(Tags.Blocks.STONE).addTag(ModTags.Blocks.STONE_SOLID_STONE);
		
		//Ore
		getOrCreateBuilder(ModTags.Blocks.ORES_LOOSE_COAL).add(ModBlocks.LOOSE_COAL_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_COAL).addTag(ModTags.Blocks.ORES_LOOSE_COAL);
		getOrCreateBuilder(ModTags.Blocks.ORES_HARD_COAL).add(ModBlocks.HARD_COAL_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_COAL).addTag(ModTags.Blocks.ORES_HARD_COAL);
		getOrCreateBuilder(ModTags.Blocks.ORES_STURDY_COAL).add(ModBlocks.STURDY_COAL_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_COAL).addTag(ModTags.Blocks.ORES_STURDY_COAL);
		
		getOrCreateBuilder(ModTags.Blocks.ORES_HARD_IRON).add(ModBlocks.HARD_IRON_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_IRON).addTag(ModTags.Blocks.ORES_HARD_IRON);
		getOrCreateBuilder(ModTags.Blocks.ORES_STURDY_IRON).add(ModBlocks.STURDY_IRON_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_IRON).addTag(ModTags.Blocks.ORES_STURDY_IRON);
		getOrCreateBuilder(ModTags.Blocks.ORES_SOLID_IRON).add(ModBlocks.SOLID_IRON_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_IRON).addTag(ModTags.Blocks.ORES_SOLID_IRON);
		
		getOrCreateBuilder(ModTags.Blocks.ORES_HARD_GOLD).add(ModBlocks.HARD_GOLD_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_GOLD).addTag(ModTags.Blocks.ORES_HARD_GOLD);
		getOrCreateBuilder(ModTags.Blocks.ORES_STURDY_GOLD).add(ModBlocks.STURDY_GOLD_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_GOLD).addTag(ModTags.Blocks.ORES_STURDY_GOLD);
		getOrCreateBuilder(ModTags.Blocks.ORES_SOLID_GOLD).add(ModBlocks.SOLID_GOLD_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_GOLD).addTag(ModTags.Blocks.ORES_SOLID_GOLD);
		
		getOrCreateBuilder(ModTags.Blocks.ORES_SOLID_DIAMOND).add(ModBlocks.SOLID_DIAMOND_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_DIAMOND).addTag(ModTags.Blocks.ORES_SOLID_DIAMOND);

		getOrCreateBuilder(ModTags.Blocks.ORES_SOLID_REDSTONE).add(ModBlocks.SOLID_REDSTONE_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_REDSTONE).addTag(ModTags.Blocks.ORES_SOLID_REDSTONE);

		getOrCreateBuilder(ModTags.Blocks.ORES_STURDY_LAPIS).add(ModBlocks.STURDY_LAPIS_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_LAPIS).addTag(ModTags.Blocks.ORES_STURDY_LAPIS);
		getOrCreateBuilder(ModTags.Blocks.ORES_SOLID_LAPIS).add(ModBlocks.SOLID_LAPIS_ORE.get());
		getOrCreateBuilder(Tags.Blocks.ORES_LAPIS).addTag(ModTags.Blocks.ORES_SOLID_LAPIS);

		getOrCreateBuilder(ModTags.Blocks.DYNAMITE).add(ModBlocks.DYNAMITE.get());
		getOrCreateBuilder(ModTags.Blocks.CHARGED_DYNAMITE).add(ModBlocks.CHARGED_DYNAMITE.get());
		getOrCreateBuilder(ModTags.Blocks.FLIMSY_TORCH).add(ModBlocks.FLIMSY_TORCH.get());
		getOrCreateBuilder(ModTags.Blocks.USED_TORCH).add(ModBlocks.USED_TORCH.get());
		getOrCreateBuilder(ModTags.Blocks.SMOLDERING_TORCH).add(ModBlocks.SMOLDERING_TORCH.get());
		getOrCreateBuilder(ModTags.Blocks.BURNT_OUT_TORCH).add(ModBlocks.BURNT_OUT_TORCH.get());
		//Below maybe not needed?
		getOrCreateBuilder(ModTags.Blocks.FLIMSY_WALL_TORCH).add(ModBlocks.FLIMSY_WALL_TORCH.get());
		getOrCreateBuilder(ModTags.Blocks.USED_WALL_TORCH).add(ModBlocks.USED_WALL_TORCH.get());
		getOrCreateBuilder(ModTags.Blocks.SMOLDERING_WALL_TORCH).add(ModBlocks.SMOLDERING_WALL_TORCH.get());
		getOrCreateBuilder(ModTags.Blocks.BURNT_OUT_WALL_TORCH).add(ModBlocks.BURNT_OUT_WALL_TORCH.get());
	}
}
