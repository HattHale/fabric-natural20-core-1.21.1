package net.hatt.natural20core.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hatt.natural20core.Natural20Core;
import net.hatt.natural20core.entity.ModEntities;
import net.hatt.natural20core.item.custom.CharacterSheetItem;
import net.hatt.natural20core.item.custom.ChiselItem;
import net.hatt.natural20core.item.custom.ModFoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BARBARIAN_ICON = registerItem("barbarian_icon", new Item(new Item.Settings()));
    public static final Item BARD_ICON = registerItem("bard_icon", new Item(new Item.Settings()));
    public static final Item CLERIC_ICON = registerItem("cleric_icon", new Item(new Item.Settings()));
    public static final Item DRUID_ICON = registerItem("druid_icon", new Item(new Item.Settings()));
    public static final Item FIGHTER_ICON = registerItem("fighter_icon", new Item(new Item.Settings()));
    public static final Item MONK_ICON = registerItem("monk_icon", new Item(new Item.Settings()));
    public static final Item PALADIN_ICON = registerItem("paladin_icon", new Item(new Item.Settings()));
    public static final Item RANGER_ICON = registerItem("ranger_icon", new Item(new Item.Settings()));
    public static final Item ROGUE_ICON = registerItem("rogue_icon", new Item(new Item.Settings()));
    public static final Item SORCERER_ICON = registerItem("sorcerer_icon", new Item(new Item.Settings()));
    public static final Item WARLOCK_ICON = registerItem("warlock_icon", new Item(new Item.Settings()));
    public static final Item WIZARD_ICON = registerItem("wizard_icon", new Item(new Item.Settings()));

    public static final Item SILVER_NUGGET =registerItem("silver_nugget",new Item(new Item.Settings()));
    public static final Item RAW_SILVER=registerItem("raw_silver",new Item(new Item.Settings()));
    public static final Item SILVER_INGOT=registerItem("silver_ingot",new Item(new Item.Settings()));

    public static final Item CHARACTER_SHEET=registerItem("character_sheet", new CharacterSheetItem(new Item.Settings().maxCount(1)));

    public static final Item CHISEL=registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item STRAWBERRY = registerItem("strawberry", new Item (new Item.Settings().food(ModFoodComponents.STRAWBERRY)));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item (new Item.Settings()));

    public static final Item DODO_SPAWN_EGG = registerItem("dodo_spawn_egg",
            new SpawnEggItem(ModEntities.DODO, 0x465ae0, 0x545978, new Item.Settings()));
    public static final Item WARTURTLE_SPAWN_EGG = registerItem("warturtle_spawn_egg",
            new SpawnEggItem(ModEntities.WARTURTLE, 0xa86518, 0x3b260f, new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Natural20Core.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Natural20Core.LOGGER.info("Registering Mod Items for " + Natural20Core.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SILVER_NUGGET);
            fabricItemGroupEntries.add(RAW_SILVER);
            fabricItemGroupEntries.add(SILVER_INGOT);

            fabricItemGroupEntries.add(STARLIGHT_ASHES);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CHARACTER_SHEET);
            fabricItemGroupEntries.add(CHISEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(STRAWBERRY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DODO_SPAWN_EGG);
            fabricItemGroupEntries.add(WARTURTLE_SPAWN_EGG);
        });
    }
}