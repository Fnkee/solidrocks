package com.fnkee.solidrocks.events;

import com.fnkee.solidrocks.setup.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChunkEvents {
    
	//Event that logs when item is picked up. First functioning test
	/*@SubscribeEvent
    public static void pickupItem(EntityItemPickupEvent event) {
    	
        World world = event.getItem().world;
        
    	if(!world.isRemote) {
    		System.out.println("Item picked up!");
        	//SolidRocks.LOGGER.info("yes hello. " + event.getItem().getName() + " was picked up by " + event.getPlayer().getName());
    	}
    }*/
    
	//Change blocks on chunk
	@SubscribeEvent
	public static void onEvent(ChunkEvent.Load event)
	{ 
	    IWorld world = event.getWorld();
	    IChunk currentChunk = event.getChunk();
	    int layer1 = 65, layer2 = 40, layer3 = 16;	//Original values: layer1 = 65, layer2 = 31, layer3 = 16;
	    int blendWidth = 5;
	    Block blockLayer1 = ModBlocks.LOOSE_STONE.get(), blockLayer2 = ModBlocks.HARD_STONE.get(), blockLayer3 = ModBlocks.STURDY_STONE.get(), blockLayer4 = ModBlocks.SOLID_STONE.get();
	    
	    if(!world.isRemote()) {
	    	
		    for (int x = 0; x < 16; ++x) 
		    {
		        for (int z = 0; z < 16; ++z) 
		        {
		        	//for (int y = currentChunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, x, z) - 20; y < currentChunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, x, z) + 1; ++y)
		            for (int y = 1; y < 256; ++y) 
		            {
		            	
		            	//2 dies to make edges less likely
		            	int rand = ((world.getRandom().nextInt(blendWidth)) - Math.floorDiv(blendWidth, 2)) + ((world.getRandom().nextInt(blendWidth)) - Math.floorDiv(blendWidth, 2)) / 2;
		            	// Needs proper PRNG based on seed - Not above and not this -> int rand = Math.floorMod(world.hashCode() / (((x +1) * (y+1) * (z+1))), blendWidth);
		            	
		            	//Replace Stone
		            	
			            if (checkBlock(currentChunk,x,y,z, Blocks.STONE)
			            		|| checkBlock(currentChunk,x,y,z, Blocks.DIORITE)
			            		|| checkBlock(currentChunk,x,y,z, Blocks.ANDESITE)
			            		|| checkBlock(currentChunk,x,y,z, Blocks.GRANITE)){

			            	
			            	//Check if block below is already this type and then compare block's yPos to layer
			            	if(checkBlock(currentChunk,x,y-1,z, blockLayer1) || y >= layer1 + rand) {
				            	SetBlockState(currentChunk, x, y, z, blockLayer1);
				            }
			            	else if(checkBlock(currentChunk,x,y-1,z, blockLayer2) || y < layer1 + rand && y >= layer2 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer2);
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, blockLayer3) || y < layer2 + rand && y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer3);
			            	}
			            	else {
			            		SetBlockState(currentChunk, x, y, z, blockLayer4);
			            	}
			            }
			            
			            //Replace Ores
			            
			            else if(checkBlock(currentChunk,x,y,z, Blocks.COAL_ORE))
			            {
			            	if(checkBlock(currentChunk,x,y-1,z, ModBlocks.LOOSE_COAL_ORE.get()) || y >= layer1 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.LOOSE_COAL_ORE.get());
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.HARD_COAL_ORE.get()) || y < layer1 + rand && y >= layer2 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.HARD_COAL_ORE.get());
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.STURDY_COAL_ORE.get()) || y < layer2 + rand && y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.STURDY_COAL_ORE.get());
			            	}
			            	else{
			            		SetBlockState(currentChunk, x, y, z, blockLayer4);
			            	}
			            }
			            else if(checkBlock(currentChunk,x,y,z, Blocks.IRON_ORE))
			            {
			            	if(checkBlock(currentChunk,x,y-1,z, blockLayer1) || y >= layer1 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer1);
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.HARD_IRON_ORE.get()) || y < layer1 + rand && y >= layer2 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.HARD_IRON_ORE.get());
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.STURDY_IRON_ORE.get()) || y < layer2 + rand && y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.STURDY_IRON_ORE.get());
			            	}
			            	else{
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.SOLID_IRON_ORE.get());
			            	}
			            }
			            
			            else if(checkBlock(currentChunk,x,y,z, Blocks.GOLD_ORE))
			            {
			            	if(checkBlock(currentChunk,x,y-1,z, blockLayer1) || y >= layer1 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer1);
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.HARD_GOLD_ORE.get()) || y < layer1 + rand && y >= layer2 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.HARD_GOLD_ORE.get());
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.STURDY_GOLD_ORE.get()) || y < layer2 + rand && y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.STURDY_GOLD_ORE.get());
			            	}
			            	else{
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.SOLID_GOLD_ORE.get());
			            	}
			            }
			            
			            else if(checkBlock(currentChunk,x,y,z, Blocks.DIAMOND_ORE))
			            {
			            	if(checkBlock(currentChunk,x,y-1,z, blockLayer3) || y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer3);
			            	}
			            	else{
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.SOLID_DIAMOND_ORE.get());
			            	}
			            }
			            
			            else if(checkBlock(currentChunk,x,y,z, Blocks.REDSTONE_ORE))
			            {
			            	if(checkBlock(currentChunk,x,y-1,z, blockLayer3) || y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer3);
			            	}
			            	else{
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.SOLID_REDSTONE_ORE.get());
			            	}
			            }
			            
			            else if(checkBlock(currentChunk,x,y,z, Blocks.LAPIS_ORE))
			            {			            	
			            	if(checkBlock(currentChunk,x,y-1,z, blockLayer2) || y >= layer2 + rand) {
			            		SetBlockState(currentChunk, x, y, z, blockLayer2);
			            	}
			            	else if(checkBlock(currentChunk,x,y-1,z, ModBlocks.STURDY_LAPIS_ORE.get()) || y < layer2 + rand && y >= layer3 + rand) {
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.STURDY_LAPIS_ORE.get());
			            	}
			            	else{
			            		SetBlockState(currentChunk, x, y, z, ModBlocks.SOLID_LAPIS_ORE.get());
			            	}
			            }
		            }
		        }
		    }
	    }
	}
	
	private static boolean checkBlock(IChunk chunk, int x, int y, int z, Block block)
	{
		if(y == 0) {
			return false;
		}
		else if(chunk.getBlockState(new BlockPos(x,y,z)).getBlock() == block) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void SetBlockState(IChunk chunk, int x, int y, int z, Block block)
	{
		chunk.setBlockState(new BlockPos(x,y,z), block.getDefaultState(), false);
	}
}