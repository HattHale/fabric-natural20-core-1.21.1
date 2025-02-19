package net.hatt.natural20core.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hatt.natural20core.Natural20Core;
import net.hatt.natural20core.block.custom.MagicBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
            )
    );

    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 0),
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.5F, 3.0F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                            .requiresTool()
            )
    );

    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.RAW_IRON_PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
            )
    );

    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.IRON_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
            )
    );

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Natural20Core.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Natural20Core.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Natural20Core.LOGGER.info("Registering Mod Blocks for " + Natural20Core.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.SILVER_ORE);
            fabricItemGroupEntries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
            fabricItemGroupEntries.add(ModBlocks.RAW_SILVER_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.SILVER_BLOCK);

            fabricItemGroupEntries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
