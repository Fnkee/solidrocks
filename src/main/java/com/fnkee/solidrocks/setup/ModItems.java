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
		new WallOrFloorItem(ModBlocks.FLIMSY_TORCH.get(), Blocks.WALL_TORCH, (new Item.Properties()).group(ItemGroup.DECORATIONS)));
	
	static void register() {}
}