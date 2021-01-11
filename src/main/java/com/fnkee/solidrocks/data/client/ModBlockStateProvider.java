package com.fnkee.solidrocks.data.client;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, SolidRocks.MOD_ID, exFileHelper);
		//SolidRocks.LOGGER.info("BLOCKSTATEPROVIDER WAS CALLED");
	}

	
	@Override
	protected void registerStatesAndModels() {
		simpleBlock(ModBlocks.SILVER_BLOCK.get());
		simpleBlock(ModBlocks.SILVER_ORE.get());
		
		//Stone
		simpleBlock(ModBlocks.LOOSE_STONE.get());
		simpleBlock(ModBlocks.HARD_STONE.get());
		simpleBlock(ModBlocks.STURDY_STONE.get());
		simpleBlock(ModBlocks.SOLID_STONE.get());
		
		//Ore
		simpleBlock(ModBlocks.LOOSE_COAL_ORE.get());
		simpleBlock(ModBlocks.HARD_COAL_ORE.get());
		simpleBlock(ModBlocks.STURDY_COAL_ORE.get());
		
		simpleBlock(ModBlocks.HARD_IRON_ORE.get());
		simpleBlock(ModBlocks.STURDY_IRON_ORE.get());
		simpleBlock(ModBlocks.SOLID_IRON_ORE.get());
		
		simpleBlock(ModBlocks.HARD_GOLD_ORE.get());
		simpleBlock(ModBlocks.STURDY_GOLD_ORE.get());
		simpleBlock(ModBlocks.SOLID_GOLD_ORE.get());
		
		simpleBlock(ModBlocks.SOLID_DIAMOND_ORE.get());

		simpleBlock(ModBlocks.SOLID_REDSTONE_ORE.get());

		simpleBlock(ModBlocks.STURDY_LAPIS_ORE.get());
		simpleBlock(ModBlocks.SOLID_LAPIS_ORE.get());

		//Other
		//simpleBlock(ModBlocks.DYNAMITE.get());
		//simpleBlock(ModBlocks.DYNAMITE.get(), models().torch("dynamite", mcLoc("block/torch")));
		
		horizontalFaceBlock(ModBlocks.DYNAMITE.get(), models().singleTexture("dynamite", modLoc("block/template_dynamite"), "dynamite", modLoc("block/dynamite")));
		horizontalFaceBlock(ModBlocks.CHARGED_DYNAMITE.get(), models().singleTexture("charged_dynamite", modLoc("block/template_dynamite"), "dynamite", modLoc("block/charged_dynamite")));
	}

}
