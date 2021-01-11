package com.fnkee.solidrocks.setup;

import java.util.function.Supplier;

import com.fnkee.solidrocks.blocks.ChargedDynamiteBlock;
import com.fnkee.solidrocks.blocks.DynamiteBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {

	private static final float HRD_LOOSE = 25F, HRD_HARD = 50F, HRD_STURDY = 75F, HRD_SOLID = 75F;
	//Original values -		   RES_LOOSE = 5.5F, RES_HARD = 6.5F, RES_STURDY = 7.5F, RES_SOLID = 1200F;
	//2nd iteration -		   RES_LOOSE = 5.5F, RES_HARD = 8.0F, RES_STURDY = 10.5F, RES_SOLID = 1200F;
	private static final float RES_LOOSE = 6.0F, RES_HARD = 6.75F, RES_STURDY = 9.5F, RES_SOLID = 1200F;
	//Maybe try with 6 for RESLOOSE. 5.5 is a bit weak against the upgraded dynamite
	
	public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () ->
		new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).harvestLevel(2).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () ->
		new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).sound(SoundType.METAL)));
	
	//Stone blocks
	//Original Stone: new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F)
	public static final RegistryObject<Block> LOOSE_STONE = register("loose_stone", () ->
		new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(HRD_LOOSE, RES_LOOSE)));
	public static final RegistryObject<Block> HARD_STONE = register("hard_stone", () ->
		new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_HARD, RES_HARD)));
	public static final RegistryObject<Block> STURDY_STONE = register("sturdy_stone", () ->
		new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_STURDY, RES_STURDY)));
	public static final RegistryObject<Block> SOLID_STONE = register("solid_stone", () ->
		new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(3).hardnessAndResistance(HRD_SOLID, RES_SOLID)));
	
	//Ore blocks
	public static final RegistryObject<Block> LOOSE_COAL_ORE = register("loose_coal_ore", () ->
	new OreBlock(AbstractBlock.Properties.from(Blocks.COAL_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(0).hardnessAndResistance(HRD_LOOSE, RES_LOOSE)));
	public static final RegistryObject<Block> HARD_COAL_ORE = register("hard_coal_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.COAL_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(HRD_HARD, RES_LOOSE)));
	public static final RegistryObject<Block> STURDY_COAL_ORE = register("sturdy_coal_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.COAL_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_STURDY, RES_HARD)));
	
	public static final RegistryObject<Block> HARD_IRON_ORE = register("hard_iron_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.IRON_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(HRD_HARD, RES_LOOSE)));
	public static final RegistryObject<Block> STURDY_IRON_ORE = register("sturdy_iron_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.IRON_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_STURDY, RES_HARD)));
	public static final RegistryObject<Block> SOLID_IRON_ORE = register("solid_iron_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.IRON_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_SOLID, RES_STURDY)));
	
	public static final RegistryObject<Block> HARD_GOLD_ORE = register("hard_gold_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.GOLD_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_HARD, RES_LOOSE)));
	public static final RegistryObject<Block> STURDY_GOLD_ORE = register("sturdy_gold_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.GOLD_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_STURDY, RES_HARD)));
	public static final RegistryObject<Block> SOLID_GOLD_ORE = register("solid_gold_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.GOLD_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_SOLID, RES_STURDY)));
	
	public static final RegistryObject<Block> SOLID_DIAMOND_ORE = register("solid_diamond_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.DIAMOND_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_SOLID, RES_STURDY)));

	public static final RegistryObject<Block> SOLID_REDSTONE_ORE = register("solid_redstone_ore", () ->
		new RedstoneOreBlock(AbstractBlock.Properties.from(Blocks.REDSTONE_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_SOLID, RES_STURDY)));

	public static final RegistryObject<Block> STURDY_LAPIS_ORE = register("sturdy_lapis_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.LAPIS_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_STURDY, RES_HARD)));
	public static final RegistryObject<Block> SOLID_LAPIS_ORE = register("solid_lapis_ore", () ->
		new OreBlock(AbstractBlock.Properties.from(Blocks.LAPIS_ORE).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(HRD_SOLID, RES_STURDY)));
	
	//Other
	public static final RegistryObject<Block> DYNAMITE = register("dynamite", () ->
		new DynamiteBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.TNT).sound(SoundType.BAMBOO).doesNotBlockMovement().zeroHardnessAndResistance())); //Used to have 1 in RES
	public static final RegistryObject<Block> CHARGED_DYNAMITE = register("charged_dynamite", () ->
		new ChargedDynamiteBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.TNT).sound(SoundType.BAMBOO).doesNotBlockMovement().zeroHardnessAndResistance()));
	
	static void register() {}
	
	private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
		return Registration.BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
		RegistryObject<T> ret = registerNoItem(name, block);
		Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
		return ret;
	}
}
