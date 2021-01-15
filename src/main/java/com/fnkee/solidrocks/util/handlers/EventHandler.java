package com.fnkee.solidrocks.util.handlers;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.events.ChunkEvents;
import com.fnkee.solidrocks.setup.ModBlocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public static void register()
	{
		//ChunkEvents ev = new ChunkEvents();
		//MinecraftForge.EVENT_BUS.register(ev);
		
		MinecraftForge.EVENT_BUS.register(SolidRocks.class);
        MinecraftForge.EVENT_BUS.register(ChunkEvents.class);
	}
	
	public static void clientRegister() {
		//SolidRocks.LOGGER.info("clientRegisterStuff");
		RenderTypeLookup.setRenderLayer(ModBlocks.DYNAMITE.get(), RenderType.getCutout());
		//RenderTypeLookup.setRenderLayer(ModBlocks.FLIMSY_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.USED_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.SMOLDERING_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BURNT_OUT_TORCH.get(), RenderType.getCutout());
	}
}
