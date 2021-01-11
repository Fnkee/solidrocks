package com.fnkee.solidrocks.tileentities;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModTileEntityTypes;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;

public class DynamiteTileEntity extends TileEntity implements ITickableTileEntity{

	private final int FUSE = 80;
	private final int FUSEFAST = 5;
	private int fuse;
	private boolean isActive;
	protected double offsetX = 0.5D, offsetY = 0.5D, offsetZ = 0.5D;
	
	public DynamiteTileEntity() {
		super(ModTileEntityTypes.DYNAMITE.get());
	}

	@Override
	public void tick()
	{
		
		if(isActive) {
			if(this.fuse <= 0) {
				
				if (!this.world.isRemote) {
					world.getChunk(pos).setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), Blocks.AIR.getDefaultState(), false);
					explode();
				}	
			}
			else
			{				
				this.fuse--;
				
				if (this.world.isRemote) {
					this.world.addParticle(ParticleTypes.SMOKE, this.getPos().getX() + offsetX, this.getPos().getY() + offsetY, this.getPos().getZ() + offsetZ, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	public void explode() {
		
		double explosionX = 0.5D, explosionY = 0.5D, explosionZ = 0.5D;
		if(offsetX == 0.1D) {
			explosionX = offsetX;
		}
		else if(offsetX == 0.9D) {
			explosionX = offsetX;
		}
		else if(offsetY == 0.1D) {
			explosionY = offsetY;
		}
		else if(offsetY == 0.9D) {
			explosionY = offsetY;
		}
		else if(offsetZ == 0.1D) {
			explosionZ = offsetZ;
		}
		else if(offsetZ == 0.9D) {
			explosionZ = offsetZ;
		}
		
	    this.world.createExplosion(null, this.getPos().getX() + explosionX, this.getPos().getY() + explosionY, this.getPos().getZ() + explosionZ, 2.0F, Explosion.Mode.BREAK);
	    //Charged dynamite should be 3 - Original 2
	}
	
	public void chainExplode() {
		//Need to find a way to store old blockstate (to restore a model with the right alignment after block is destroyed)
		//world.playSound((PlayerEntity)null, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
		isActive = true;
		fuse = FUSEFAST;
	}
	
	public void toggle() {

		if(!isActive) {
			world.playSound((PlayerEntity)null, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			isActive = true;
			fuse = FUSE;
		}
		else {
			world.playSound((PlayerEntity)null, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, SoundEvents.BLOCK_SAND_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			isActive = false;
		}
		
		this.markDirty();
	}
	
	public void setState(BlockState state) {
		switch(state.get(HorizontalFaceBlock.FACE)) {
		case FLOOR:
			offsetY = 0.1D;
			switch(state.get(HorizontalFaceBlock.HORIZONTAL_FACING)){
			case NORTH:
				offsetX = 0.8125D;
				break;
			case WEST:
				offsetZ = 0.1875D;
				break;
			case EAST:
				offsetZ = 0.8125D;
				break;
			case SOUTH:
				offsetX = 0.1875D;
			default:
				break;
			}
			break;
			
		case CEILING:
			offsetY = 0.9D;
			switch(state.get(HorizontalFaceBlock.HORIZONTAL_FACING)){
			case NORTH:
				offsetX = 0.8125D;
				break;
			case WEST:
				offsetZ = 0.1875D;
				break;
			case EAST:
				offsetZ = 0.8125D;
				break;
			case SOUTH:
				offsetX = 0.1875D;
			default:
				break;
			}
			break;
			
		case WALL:
			switch(state.get(HorizontalFaceBlock.HORIZONTAL_FACING)){
			case NORTH:
				offsetX = 0.8125D;
				offsetZ = 0.9D;
				break;
			case WEST:
				offsetX = 0.9D;
				offsetZ = 0.1875D;
				break;
			case EAST:
				offsetX = 0.1D;
				offsetZ = 0.8125D;
				break;
			case SOUTH:
				offsetX = 0.1875D;
				offsetZ = 0.1D;
			default:
				break;
			}
			break;
		}
		
		//Is markDirty needed here?
		//this.markDirty();
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbtTag = new CompoundNBT();
		nbtTag.putBoolean("isActive", this.isActive);
		nbtTag.putDouble("offsetX", this.offsetX);
		nbtTag.putDouble("offsetY", this.offsetY);
		nbtTag.putDouble("offsetZ", this.offsetZ);
		write(nbtTag);
		return nbtTag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
	{
		this.read(blockState,  parentNBTTagCompound);
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket(){
	    //SolidRocks.LOGGER.info("wrote isActive to " + this.isActive);
	    
	    return new SUpdateTileEntityPacket(getPos(), -1, getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt){
	    CompoundNBT tag = pkt.getNbtCompound();
		this.isActive = tag.getBoolean("isActive");
		this.offsetX = tag.getDouble("offsetX");
		this.offsetY = tag.getDouble("offsetY");
		this.offsetZ = tag.getDouble("offsetZ");
		this.read(this.getBlockState(), pkt.getNbtCompound());
		//SolidRocks.LOGGER.info("loaded isActive is " + this.isActive);
	}
	
	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		this.fuse = nbt.getInt("fuse");
		this.isActive = nbt.getBoolean("isActive");
		this.offsetX = nbt.getDouble("offsetX");
		this.offsetY = nbt.getDouble("offsetY");
		this.offsetZ = nbt.getDouble("offsetZ");
		
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.putInt("fuse", this.fuse);
		compound.putBoolean("isActive", this.isActive);
		compound.putDouble("offsetX", this.offsetX);
		compound.putDouble("offsetY", this.offsetY);
		compound.putDouble("offsetZ", this.offsetZ);
		return super.write(compound);
	}
}
