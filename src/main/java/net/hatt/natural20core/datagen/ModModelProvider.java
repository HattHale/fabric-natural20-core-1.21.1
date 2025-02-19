package net.hatt.natural20core.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hatt.natural20core.block.ModBlocks;
import net.hatt.natural20core.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BARBARIAN_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.BARD_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLERIC_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRUID_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIGHTER_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.MONK_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALADIN_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.RANGER_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROGUE_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SORCERER_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARLOCK_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.WIZARD_ICON, Models.GENERATED);

        itemModelGenerator.register(ModItems.SILVER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHARACTER_SHEET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);

        itemModelGenerator.register(ModItems.DODO_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.WARTURTLE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
