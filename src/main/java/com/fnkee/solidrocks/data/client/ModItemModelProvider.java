package com.fnkee.solidrocks.data.client;

import com.fnkee.solidrocks.SolidRocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, SolidRocks.MOD_ID, existingFileHelper);		
		
		//SolidRocks.LOGGER.info("ITEMMODELPROVIDER WAS CALLED");
	}
	
	@Override
	protected void registerModels() {
		withExistingParent("silver_block", modLoc("block/silver_block"));
		withExistingParent("silver_ore", modLoc("block/silver_ore"));
		
		//Stone
		withExistingParent("loose_stone", modLoc("block/loose_stone"));
		withExistingParent("hard_stone", modLoc("block/hard_stone"));
		withExistingParent("sturdy_stone", modLoc("block/sturdy_stone"));
		withExistingParent("solid_stone", modLoc("block/solid_stone"));
		
		//Ores
		withExistingParent("loose_coal_ore", modLoc("block/loose_coal_ore"));
		withExistingParent("hard_coal_ore", modLoc("block/hard_coal_ore"));
		withExistingParent("sturdy_coal_ore", modLoc("block/sturdy_coal_ore"));
		
		withExistingParent("hard_iron_ore", modLoc("block/hard_iron_ore"));
		withExistingParent("sturdy_iron_ore", modLoc("block/sturdy_iron_ore"));
		withExistingParent("solid_iron_ore", modLoc("block/solid_iron_ore"));
		
		withExistingParent("hard_gold_ore", modLoc("block/hard_gold_ore"));
		withExistingParent("sturdy_gold_ore", modLoc("block/sturdy_gold_ore"));
		withExistingParent("solid_gold_ore", modLoc("block/solid_gold_ore"));
		
		withExistingParent("solid_diamond_ore", modLoc("block/solid_diamond_ore"));

		withExistingParent("solid_redstone_ore", modLoc("block/solid_redstone_ore"));

		withExistingParent("sturdy_lapis_ore", modLoc("block/sturdy_lapis_ore"));
		withExistingParent("solid_lapis_ore", modLoc("block/solid_lapis_ore"));

		withExistingParent("dynamite", modLoc("block/dynamite"));
		withExistingParent("charged_dynamite", modLoc("block/charged_dynamite"));
		
		withExistingParent("flimsy_torch", modLoc("block/flimsy_torch"));
		withExistingParent("used_torch", modLoc("block/used_torch"));
		withExistingParent("smoldering_torch", modLoc("block/smoldering_torch"));
		withExistingParent("burnt_out_torch", modLoc("block/burnt_out_torch"));
		//withExistingParent("flimsy_wall_torch", modLoc("block/flimsy_torch"));
		//withExistingParent("used_wall_torch", modLoc("block/used_torch"));
		//withExistingParent("smoldering_wall_torch", modLoc("block/smoldering_torch"));
		//withExistingParent("burnt_out_wall_torch", modLoc("block/burnt_out_torch"));
		
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));	
		
		builder(itemGenerated, "silver_ingot");
		builder(itemGenerated, "pebble");
		builder(itemGenerated, "dirt_pile");
		builder(itemGenerated, "dynamite");
		builder(itemGenerated, "charged_dynamite");
		builder(itemGenerated, "raw_iron");
		builder(itemGenerated, "raw_gold");
		
		getBuilder("flimsy_wall_torch").parent(itemGenerated).texture("layer0", "block/flimsy_torch");
		getBuilder("used_wall_torch").parent(itemGenerated).texture("layer0", "block/used_torch");
		getBuilder("smoldering_wall_torch").parent(itemGenerated).texture("layer0", "block/smoldering_torch");
		getBuilder("burnt_out_wall_torch").parent(itemGenerated).texture("layer0", "block/burnt_out_torch");
	}
	
	private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
		return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
	}
}
