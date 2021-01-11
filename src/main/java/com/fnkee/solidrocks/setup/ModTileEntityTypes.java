package com.fnkee.solidrocks.setup;

import com.fnkee.solidrocks.tileentities.ChargedDynamiteTileEntity;
import com.fnkee.solidrocks.tileentities.DynamiteTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntityTypes {
	
	public static final RegistryObject<TileEntityType<DynamiteTileEntity>> DYNAMITE = Registration.TILE_ENTITY_TYPES.register("dynamite", () ->
		TileEntityType.Builder.create(DynamiteTileEntity::new, ModBlocks.DYNAMITE.get()).build(null));
	public static final RegistryObject<TileEntityType<ChargedDynamiteTileEntity>> CHARGED_DYNAMITE = Registration.TILE_ENTITY_TYPES.register("charged_dynamite", () ->
		TileEntityType.Builder.create(ChargedDynamiteTileEntity::new, ModBlocks.CHARGED_DYNAMITE.get()).build(null));
	
	static void register() {}
}
