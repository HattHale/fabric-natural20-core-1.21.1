package net.hatt.natural20core.event.keybinding;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.hatt.natural20core.screen.custom.CharBuildScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientAdvancementManager;

public class KeybindingCharacterBuilderScreen {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (KeybindHandler.OPEN_CHARACTER_BUILDER.wasPressed() && client.player != null) {
                // Get the ClientAdvancementManager
                ClientAdvancementManager advancementManager = client.player.networkHandler.getAdvancementHandler();

                // Open the custom CharBuildScreen with the parent screen
                client.setScreen(new CharBuildScreen(advancementManager, client.currentScreen));
            }
        });
    }
}