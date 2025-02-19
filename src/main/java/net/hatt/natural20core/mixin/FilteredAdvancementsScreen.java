package net.hatt.natural20core.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.advancement.PlacedAdvancement;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.hatt.natural20core.screen.custom.CharBuildScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.HashSet;
import java.util.Set;

@Mixin(AdvancementsScreen.class)
public abstract class FilteredAdvancementsScreen extends Screen {
    private static final Set<String> BLOCKED_ADVANCEMENTS = new HashSet<>();

    static {
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/barbarian_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/bard_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/cleric_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/druid_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/fighter_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/monk_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/paladin_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/ranger_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/rogue_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/sorcerer_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/warlock_root");
        BLOCKED_ADVANCEMENTS.add("natural20core:classes/wizard_root");
    }

    protected FilteredAdvancementsScreen() {
        super(null);
    }

    @Inject(method = "onRootAdded", at = @At("HEAD"), cancellable = true)
    private void filterClassAdvancements(PlacedAdvancement root, CallbackInfo ci) {
        String advancementName = root.getAdvancementEntry().toString();
        MinecraftClient client = MinecraftClient.getInstance();

        // If we are in the normal Advancements UI, block class advancements
        if (BLOCKED_ADVANCEMENTS.contains(advancementName) && !(client.currentScreen instanceof CharBuildScreen)) {
            System.out.println("Blocking class advancement from normal UI: " + advancementName);
            ci.cancel(); // Prevents it from being added to the normal UI
        }
    }
}