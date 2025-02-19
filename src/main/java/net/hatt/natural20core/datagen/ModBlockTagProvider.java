package net.hatt.natural20core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hatt.natural20core.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(
                        ModBlocks.SILVER_ORE,
                        ModBlocks.DEEPSLATE_SILVER_ORE,
                        ModBlocks.RAW_SILVER_BLOCK,
                        ModBlocks.SILVER_BLOCK
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        ModBlocks.SILVER_ORE,
                        ModBlocks.DEEPSLATE_SILVER_ORE,
                        ModBlocks.RAW_SILVER_BLOCK,
                        ModBlocks.SILVER_BLOCK
                );
    }
}
