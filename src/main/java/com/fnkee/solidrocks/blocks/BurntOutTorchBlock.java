package com.fnkee.solidrocks.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BurntOutTorchBlock extends TorchBlock{
	public BurntOutTorchBlock(Properties properties, IParticleData particleData) {
		super(properties, particleData);
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		
	}
}