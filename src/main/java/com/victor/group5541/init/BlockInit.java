package com.victor.group5541.init;

import com.victor.group5541.TutorialMod;
import com.victor.group5541.common.block.CobaltBlasterBlock;
import com.victor.group5541.common.block.CobaltLampBlock;
import com.victor.group5541.common.block.LightningJumperBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {
	private BlockInit() {}
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);
	
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).strength(2.0f, 15f).requiresCorrectToolForDrops().friction(0.5f)));

	public static final RegistryObject<LightningJumperBlock> LIGHTNING_JUMPER = BLOCKS.register("lightning_jumper", () -> new LightningJumperBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_ORANGE).strength(8.0f, 30f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> COBALT_LAMP = BLOCKS.register("cobalt_lamp", () -> new CobaltLampBlock(BlockBehaviour.Properties.of(Material.METAL).strength(8.0f, 30f).requiresCorrectToolForDrops().lightLevel((state)-> state.getValue(CobaltLampBlock.CLICKED) ? 15 : 0)));
	
	public static final RegistryObject<CobaltBlasterBlock> COBALT_BLASTER = BLOCKS.register("cobalt_blaster", () -> new CobaltBlasterBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()));
}
