package com.fnkee.solidrocks.setup;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
	public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> PEBBLE = Registration.ITEMS.register("pebble", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> RAW_IRON = Registration.ITEMS.register("raw_iron", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> RAW_GOLD = Registration.ITEMS.register("raw_gold", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> DIRT_PILE = Registration.ITEMS.register("dirt_pile", () ->
		new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<Item> FLIMSY_TORCH = Registration.ITEMS.register("flimsy_torch", () ->
		new WallOrFloorItem(ModBlocks.FLIMSY_TORCH.get(), ModBlocks.FLIMSY_WALL_TORCH.get(), (new Item.Properties()).group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> USED_TORCH = Registration.ITEMS.register("used_torch", () ->
		new WallOrFloorItem(ModBlocks.USED_TORCH.get(), ModBlocks.USED_WALL_TORCH.get(), (new Item.Properties()).group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> SMOLDERING_TORCH = Registration.ITEMS.register("smoldering_torch", () ->
		new WallOrFloorItem(ModBlocks.SMOLDERING_TORCH.get(), ModBlocks.SMOLDERING_WALL_TORCH.get(), (new Item.Properties()).group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> BURNT_OUT_TORCH = Registration.ITEMS.register("burnt_out_torch", () ->
		new WallOrFloorItem(ModBlocks.BURNT_OUT_TORCH.get(), ModBlocks.BURNT_OUT_WALL_TORCH.get(), (new Item.Properties()).group(ItemGroup.DECORATIONS)));
	
	static void register() {}
}