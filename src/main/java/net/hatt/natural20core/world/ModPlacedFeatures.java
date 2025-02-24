package net.hatt.natural20core.world;

import net.hatt.natural20core.Natural20Core;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ORE_SILVER_UPPER = registerKey("ore_silver_upper");
    public static final RegistryKey<PlacedFeature> ORE_SILVER_MIDDLE = registerKey("ore_silver_middle");
    public static final RegistryKey<PlacedFeature> ORE_SILVER_SMALL = registerKey("ore_silver_small");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ORE_SILVER_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY), ModOrePlacement.modifiersWithCount(90, HeightRangePlacementModifier.trapezoid(YOffset.fixed(80), YOffset.fixed(384))));
        register(context, ORE_SILVER_MIDDLE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY), ModOrePlacement.modifiersWithCount(10, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56))));
        register(context, ORE_SILVER_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY), ModOrePlacement.modifiersWithCount(10, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(72))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Natural20Core.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
