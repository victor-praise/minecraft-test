package com.victor.group5541.common.item;

import com.victor.group5541.TutorialMod;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class ClickerItem extends Item {


	public static boolean canInteract(Player player, BlockPos pos) {
		float speed = player.getDigSpeed(player.level.getBlockState(pos), pos);
		return player.isCreative() || player.mayBuild() && speed > 0 && speed < Float.MAX_VALUE;
	}
	
	public ClickerItem(Properties properties) {
		super(properties);
	}
	
	
	@Override
	public InteractionResult useOn(UseOnContext context) {
		ItemStack stack = context.getItemInHand();
		var player = context.getPlayer();
		var level = player.level;
		BlockPos pos = context.getClickedPos();
		BlockState state = level.getBlockState(pos);
		if (!canInteract(player, pos))
			return InteractionResult.FAIL;

		if (!stack.getOrCreateTag().contains(TutorialMod.MOD_ID, CompoundTag.TAG_COMPOUND))
			stack.getOrCreateTag().put(TutorialMod.MOD_ID, new CompoundTag());

		CompoundTag nbt = stack.getOrCreateTag().getCompound(TutorialMod.MOD_ID);
		if (!nbt.contains("ContainedBlock",  CompoundTag.TAG_COMPOUND)) {
			if (!state.isAir()) {
				level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
				nbt.put("ContainedBlock", NbtUtils.writeBlockState(state));
				return InteractionResult.SUCCESS;
			}
		} else if (state.canBeReplaced(new BlockPlaceContext(context))) {
			level.setBlockAndUpdate(pos, NbtUtils.readBlockState(nbt.getCompound("ContainedBlock")));
			nbt.remove("ContainedBlock");
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.FAIL;
	}

}
