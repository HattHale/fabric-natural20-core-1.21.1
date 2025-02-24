package net.hatt.natural20core;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.hatt.natural20core.block.ModBlocks;
import net.hatt.natural20core.entity.ModEntities;
import net.hatt.natural20core.entity.custom.DodoEntity;
import net.hatt.natural20core.entity.custom.WarturtleEntity;
import net.hatt.natural20core.event.keybinding.KeybindHandler;
import net.hatt.natural20core.gui.LevelXpBar;
import net.hatt.natural20core.item.ModItemGroups;
import net.hatt.natural20core.item.ModItems;

import net.hatt.natural20core.screen.ModScreenHandlers;
import net.hatt.natural20core.world.gen.ModWorldGeneration;
import net.hatt.natural20core.worldgen.ModEntitySpawns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Natural20Core implements ModInitializer {
	public static final String MOD_ID = "natural20core";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		KeybindHandler.registerKeybinds();

		LevelXpBar.register();

		ModWorldGeneration.generateModWorldGeneration();

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModEntities.registerModEntities();
		ModScreenHandlers.registerScreenHandler();

		FabricDefaultAttributeRegistry.register(ModEntities.DODO, DodoEntity.createDodoAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WARTURTLE, WarturtleEntity.createWarturtleAttributes());

		ModEntitySpawns.addSpawns();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);
	}
}