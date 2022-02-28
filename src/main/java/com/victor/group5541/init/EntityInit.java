package com.victor.group5541.init;

import com.victor.group5541.TutorialMod;
import com.victor.group5541.common.entity.ExampleEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class EntityInit {
	
	private EntityInit() {}
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, TutorialMod.MOD_ID);
	
	public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register("example_entity", () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE).sized(0.8f, 0.6f).build(new ResourceLocation(TutorialMod.MOD_ID, "example_entity").toString()));
}
