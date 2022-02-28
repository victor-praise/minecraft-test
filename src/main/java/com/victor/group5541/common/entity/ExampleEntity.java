package com.victor.group5541.common.entity;

import com.victor.group5541.init.EntityInit;
import com.victor.group5541.init.ItemInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class ExampleEntity extends Animal {

	public ExampleEntity(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}
	@Override
	protected void registerGoals() {
		 this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
	      this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
	      this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(ItemInit.EXAMPLE_ITEM.get()), false));
	
	      this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
	      this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	      this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
	      this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 50.0D).add(Attributes.MOVEMENT_SPEED, 0.23D);
	}
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return EntityInit.EXAMPLE_ENTITY.get().create(level);
	}
	
	
	
}
