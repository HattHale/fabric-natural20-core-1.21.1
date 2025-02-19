package net.hatt.natural20core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hatt.natural20core.block.ModBlocks;
import net.hatt.natural20core.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> SILVER_SMELTABLE = List.of(
                ModItems.RAW_SILVER,
                ModBlocks.SILVER_ORE,
                ModBlocks.DEEPSLATE_SILVER_ORE
        );

        offerSmelting(recipeExporter, SILVER_SMELTABLE, RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.7f, 200, "silver_ingot");
        offerBlasting(recipeExporter, SILVER_SMELTABLE, RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.7f, 100, "silver_ingot");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_INGOT, RecipeCategory.MISC, ModBlocks.SILVER_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SILVER, RecipeCategory.MISC, ModBlocks.RAW_SILVER_BLOCK);

        //offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.SILVER_NUGGET, RecipeCategory.MISC, ModBlocks.SILVER_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGIC_BLOCK)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .input('1', ModItems.SILVER_INGOT)
                .input('2', ModItems.STARLIGHT_ASHES)
                .criterion(hasItem(ModItems.STARLIGHT_ASHES), conditionsFromItem(ModItems.STARLIGHT_ASHES))
                .offerTo(recipeExporter);
    }
}
