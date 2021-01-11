package com.fnkee.solidrocks.blocks;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModBlocks;
import com.fnkee.solidrocks.setup.ModTileEntityTypes;
import com.fnkee.solidrocks.tileentities.DynamiteTileEntity;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class DynamiteBlock extends HorizontalFaceBlock{
	
	protected static final VoxelShape FLOOR_Z_SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 5.0D, 11.0D);
	protected static final VoxelShape FLOOR_X_SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 2.0D, 11.0D, 5.0D, 14.0D);
	protected static final VoxelShape CEILING_Z_SHAPE = Block.makeCuboidShape(2.0D, 11.0D, 5.0D, 14.0D, 16.0D, 11.0D);
	protected static final VoxelShape CEILING_X_SHAPE = Block.makeCuboidShape(5.0D, 11.0D, 2.0D, 11.0D, 16.0D, 14.0D);
	protected static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0.0D, 5.0D, 2.0D, 5.0D, 11.0D, 14.0D);
	protected static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(11.0D, 5.0D, 2.0D, 16.0D, 11.0D, 14.0D);
	protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(2.0D, 5.0D, 0.0D, 14.0D, 11.0D, 5.0D);
	protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(2.0D, 5.0D, 11.0D, 14.0D, 11.0D, 16.0D);
	
	public DynamiteBlock(AbstractBlock.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(HORIZONTAL_FACING);
		switch((AttachFace)state.get(FACE)) {
		case FLOOR:
			if (direction.getAxis() == Direction.Axis.X) {
				return FLOOR_X_SHAPE;
			}
		
			return FLOOR_Z_SHAPE;
		case WALL:
			switch(direction) {
			case EAST:
				return EAST_SHAPE;
			case WEST:
				return WEST_SHAPE;
			case SOUTH:
				return SOUTH_SHAPE;
			case NORTH:
			default:
				return NORTH_SHAPE;
			}
		case CEILING:
		default:
			if (direction.getAxis() == Direction.Axis.X) {
				return CEILING_X_SHAPE;
			} else {
				return CEILING_Z_SHAPE;
			}
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if (world.isRemote) {
			return ActionResultType.SUCCESS;
		}
		else {
	    	  
			TileEntity tileentity = world.getTileEntity(pos);
	    
	    	  if (tileentity instanceof DynamiteTileEntity) {
	    		  DynamiteTileEntity dynamiteTileEntity = (DynamiteTileEntity)tileentity;
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
	    
	    	  if (tileentity instanceof DynamiteTileEntity) {
	    		  DynamiteTileEntity dynamiteTileEntity = (DynamiteTileEntity)tileentity;
	    		  dynamiteTileEntity.setState(state);
	    		  world.notifyBlockUpdate(pos, state, state, 2);
	    	  }
		}
	}
	
	@Override
	public void onExplosionDestroy(World world, BlockPos pos, Explosion explosionIn) {
		if (!world.isRemote) {
			//SolidRocks.LOGGER.info("EXPLODE: " + world.getBlockState(pos));
			Block dynamiteBlock = ModBlocks.DYNAMITE.get();
			world.getChunk(pos).setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), dynamiteBlock.getDefaultState() , false);
			
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof DynamiteTileEntity) {
				DynamiteTileEntity dynamiteTileEntity = (DynamiteTileEntity)tileentity;
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
		return ModTileEntityTypes.DYNAMITE.get().create();
    }
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING, FACE);
	}
	
}
