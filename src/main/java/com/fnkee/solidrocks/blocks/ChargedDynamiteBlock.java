package com.fnkee.solidrocks.blocks;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModBlocks;
import com.fnkee.solidrocks.setup.ModTileEntityTypes;
import com.fnkee.solidrocks.tileentities.ChargedDynamiteTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ChargedDynamiteBlock extends DynamiteBlock{

	public ChargedDynamiteBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if (world.isRemote) {
			return ActionResultType.SUCCESS;
		}
		else {
	    	  
			TileEntity tileentity = world.getTileEntity(pos);
	    
	    	  if (tileentity instanceof ChargedDynamiteTileEntity) {
	    		  ChargedDynamiteTileEntity dynamiteTileEntity = (ChargedDynamiteTileEntity)tileentity;
    			  dynamiteTileEntity.toggle();
    			  //SolidRocks.LOGGER.info("ACTIVATED");
    			  world.notifyBlockUpdate(pos, state, state, 2);
	    		  return ActionResultType.CONSUME;
	    	  }
	    	  
	    	  return ActionResultType.CONSUME;
	     }
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		
		if (!world.isRemote) {
			TileEntity tileentity = world.getTileEntity(pos);
	    
	    	  if (tileentity instanceof ChargedDynamiteTileEntity) {
	    		  ChargedDynamiteTileEntity dynamiteTileEntity = (ChargedDynamiteTileEntity)tileentity;
	    		  dynamiteTileEntity.setState(state);
	    		  world.notifyBlockUpdate(pos, state, state, 2);
	    	  }
		}
	}
	
	@Override
	public void onExplosionDestroy(World world, BlockPos pos, Explosion explosionIn) {
		if (!world.isRemote) {
			//SolidRocks.LOGGER.info("EXPLODE: " + world.getBlockState(pos));
			Block dynamiteBlock = ModBlocks.CHARGED_DYNAMITE.get();
			world.getChunk(pos).setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), dynamiteBlock.getDefaultState() , false);
			
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof ChargedDynamiteTileEntity) {
				ChargedDynamiteTileEntity dynamiteTileEntity = (ChargedDynamiteTileEntity)tileentity;
				dynamiteTileEntity.chainExplode();
				world.notifyBlockUpdate(pos, getDefaultState(), getDefaultState(), 2);
	    	  }
	      }
      }
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
		return ModTileEntityTypes.CHARGED_DYNAMITE.get().create();
    }
	
}
