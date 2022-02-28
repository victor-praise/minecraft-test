package com.victor.group5541.event;

import com.victor.group5541.TutorialMod;
import com.victor.group5541.common.entity.ExampleEntity;
import com.victor.group5541.init.EntityInit;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {
	@SubscribeEvent
	public static void registerAttribute(EntityAttributeCreationEvent event) {
		event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
	}

}
