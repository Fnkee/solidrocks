package com.fnkee.solidrocks.blocks;

import java.util.Random;

import com.fnkee.solidrocks.SolidRocks;
import com.fnkee.solidrocks.setup.ModBlocks;
import com.google.common.base.CaseFormat;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FlimsyTorchBlock extends TorchBlock{

	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
	public static final IntegerProperty LEVEL = BlockStateProperties.LEVEL_0_3;
	
	public FlimsyTorchBlock(Properties properties, IParticleData particleData, int level) {
		super(properties, particleData);
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)).with(LEVEL, Integer.valueOf(level)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(AGE, LEVEL);
	}
	
	
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		
		int j = state.get(AGE);
		int l = state.get(LEVEL);
		
		if (j == 5) {
			switch(l) {
			case 1:
				worldIn.setBlockState(pos, ModBlocks.BURNT_OUT_TORCH.get().getDefaultState());
				worldIn.playSound((PlayerEntity)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
				break;
			case 2:
				worldIn.setBlockState(pos, ModBlocks.SMOLDERING_TORCH.get().getDefaultState());
				break;
			case 3:
				worldIn.setBlockState(pos, ModBlocks.USED_TORCH.get().getDefaultState());
				break;
			}
         } else {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)).with(LEVEL, l), 4);
         }
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		
		int l = stateIn.get(LEVEL);
		double offsetY = 0.0D;
		
		switch(l) {
		case 1:
			offsetY = 0.45D;
			break;
		case 2:
			offsetY = 0.575D;
			break;
		case 3:
			offsetY = 0.7D;
			break;
		}
		
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + offsetY;
		double d2 = (double)pos.getZ() + 0.5D;
		worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		worldIn.addParticle(this.particleData, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		
	}
}
