package com.victor.group5541.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CobaltLampBlock extends Block {

	public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");
	public CobaltLampBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player p_60506_,
			InteractionHand pHand, BlockHitResult p_60508_) {
		
		if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
			boolean currentState = pState.getValue(CLICKED);
			pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);
		}
		// TODO Auto-generated method stub
		return InteractionResult.SUCCESS;
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> properties) {
		properties.add(CLICKED);
	}

}
