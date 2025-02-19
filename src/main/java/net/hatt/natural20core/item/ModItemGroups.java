package net.hatt.natural20core.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hatt.natural20core.Natural20Core;
import net.hatt.natural20core.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup NATRUAL20_CORE_ORES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Natural20Core.MOD_ID, "natural20_core_ores"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SILVER_INGOT))
                    .displayName(Text.translatable("itemgroup.natural20core.natural20_core_ores"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SILVER_NUGGET);
                        entries.add(ModItems.RAW_SILVER);
                        entries.add(ModItems.SILVER_INGOT);

                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
                        entries.add(ModBlocks.RAW_SILVER_BLOCK);
                        entries.add(ModBlocks.SILVER_BLOCK);
                    })
                    .build());

    public static void registerItemGroups(){
        Natural20Core.LOGGER.info("Registering Item Groups for " + Natural20Core.MOD_ID);
    }
}
