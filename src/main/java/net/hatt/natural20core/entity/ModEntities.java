package net.hatt.natural20core.entity;

import net.hatt.natural20core.Natural20Core;
import net.hatt.natural20core.entity.custom.DodoEntity;
import net.hatt.natural20core.entity.custom.WarturtleEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DodoEntity> DODO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Natural20Core.MOD_ID, "dodo"),
            EntityType.Builder.create(DodoEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2.5f).build());

    public static final EntityType<WarturtleEntity> WARTURTLE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Natural20Core.MOD_ID, "warturtle"),
            EntityType.Builder.create(WarturtleEntity::new, SpawnGroup.CREATURE).dimensions(2.5f, 1.5f).build());

    public static void registerModEntities() {
        Natural20Core.LOGGER.info("Registering Mod Entities for " + Natural20Core.MOD_ID);
    }
}