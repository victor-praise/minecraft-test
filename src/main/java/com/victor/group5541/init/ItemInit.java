package com.victor.group5541.init;

import com.victor.group5541.TutorialMod;
import com.victor.group5541.common.item.ClickerItem;
import com.victor.group5541.common.item.DowsingRodItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	private ItemInit() {}
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
	
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> 
	new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	public static final RegistryObject<ClickerItem> CLICKER = ITEMS.register("clicker", ()-> new ClickerItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod", ()-> new DowsingRodItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(16)));
	
//	Block Item
//	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_item", 
//			() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	
	public static final RegistryObject<BlockItem> LIGHTNING_JUMPER_BLOCK_ITEM = ITEMS
			.register("lightning_jumper", () -> new BlockItem(BlockInit.LIGHTNING_JUMPER.get(),
			        new Item.Properties().tab(TutorialMod.TUTORIAL_TAB)));
	
	public static final RegistryObject<BlockItem> COBALT_LAMP_BLOCK_ITEM = ITEMS
			.register("cobalt_lamp", () -> new BlockItem(BlockInit.COBALT_LAMP.get(),
			        new Item.Properties().tab(TutorialMod.TUTORIAL_TAB)));
	
	public static final RegistryObject<BlockItem> COBALT_BLASTER_BLOCK_ITEM = ITEMS
			.register("cobalt_blaster", () -> new BlockItem(BlockInit.COBALT_BLASTER.get(),
			        new Item.Properties().tab(TutorialMod.TUTORIAL_TAB)));
}



