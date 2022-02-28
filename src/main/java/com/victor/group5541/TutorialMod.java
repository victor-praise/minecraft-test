package com.victor.group5541;

import java.util.Map.Entry;
import java.util.Optional;

import javax.annotation.Nonnull;

import com.victor.group5541.common.entity.ModBlockEntities;
import com.victor.group5541.init.BlockInit;
import com.victor.group5541.init.EntityInit;
import com.victor.group5541.init.ItemInit;

import net.minecraft.core.Direction;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("group5541")
public class TutorialMod {
	public static final String MOD_ID = "group5541";
		
	
	public TutorialMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		//if crash, remove files relating to this  EntityInit.ENTITIES.register(bus);
		ModBlockEntities.register(bus);
	}
	
    public static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = { shape, Shapes.empty() };

        final int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1],
                    Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }

	
	  public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab(MOD_ID) { // tutorialmod.itemGroup
	        @Override
	        public ItemStack makeIcon() {
	        	return Items.CHORUS_PLANT.getDefaultInstance();
	           
	        }
	    };
}
