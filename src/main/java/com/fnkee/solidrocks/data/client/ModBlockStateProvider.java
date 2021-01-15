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
		simpleBlock(ModBlocks.FLIMSY_TORCH.get(), models().singleTexture("flimsy_torch", mcLoc("block/template_torch"), "torch", modLoc("block/flimsy_torch")));
		simpleBlock(ModBlocks.USED_TORCH.get(), models().singleTexture("used_torch", modLoc("block/template_used_torch"), "torch", modLoc("block/used_torch")));
		simpleBlock(ModBlocks.SMOLDERING_TORCH.get(), models().singleTexture("smoldering_torch", modLoc("block/template_smoldering_torch"), "torch", modLoc("block/smoldering_torch")));
		simpleBlock(ModBlocks.BURNT_OUT_TORCH.get(), models().singleTexture("burnt_out_torch", modLoc("block/template_burnt_out_torch"), "torch", modLoc("block/burnt_out_torch")));
		
		horizontalFaceBlock(ModBlocks.DYNAMITE.get(), models().singleTexture("dynamite", modLoc("block/template_dynamite"), "dynamite", modLoc("block/dynamite")));
		horizontalFaceBlock(ModBlocks.CHARGED_DYNAMITE.get(), models().singleTexture("charged_dynamite", modLoc("block/template_dynamite"), "dynamite", modLoc("block/charged_dynamite")));
	}

}
