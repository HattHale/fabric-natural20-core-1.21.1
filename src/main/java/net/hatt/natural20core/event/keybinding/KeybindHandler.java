package net.hatt.natural20core.event.keybinding;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindHandler {
    public static final KeyBinding OPEN_CHARACTER_BUILDER = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.natural20core.character_builder",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            "Natural20core"
    ));

    public static void registerKeybinds() {
        KeybindingCharacterBuilderScreen.register();
    }
}
