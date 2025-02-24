package net.hatt.natural20core.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.hatt.natural20core.Natural20Core;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public class LevelXpBar {

    // Reference to your 17x11 container texture.
    private static final Identifier RING_TEXTURE =
            Identifier.of(Natural20Core.MOD_ID, "textures/gui/level_container.png");

    public static void register() {
        HudRenderCallback.EVENT.register(LevelXpBar::onHudRender);
    }

    private static void onHudRender(DrawContext context, RenderTickCounter tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();

        // Use container dimensions: width = 17, height = 11.
        int containerWidth = 17;
        int containerHeight = 11;
        // Position the container relative to the inventory.
        int containerX = (screenWidth / 2) - (containerWidth / 2);
        int containerY = screenHeight - containerHeight - 37;

        // 1. Draw the base container (light purple background).
        RenderSystem.setShaderColor(0.81f, 0.69f, 1.0f, 1.0f); // Light purple tint (approx. #CEB1FF)
        context.drawTexture(RING_TEXTURE, containerX - 1, containerY, 0, 0, containerWidth, containerHeight, containerWidth, containerHeight);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

        // 2. Draw the progress fill (dark purple) from bottom to top.
        float progress = getTargetProgress(); // Value from 0.0 to 1.0 (e.g., 0.60f)
        int filledHeight = (int) (containerHeight * progress);
        if (filledHeight > 0) {
            int srcY = containerHeight - filledHeight;
            int destY = containerY + containerHeight - filledHeight;
            RenderSystem.setShaderColor(0.5f, 0.0f, 0.5f, 1.0f); // Dark purple tint (approx. #800080)
            context.drawTexture(RING_TEXTURE, containerX - 1, destY, 0, srcY, containerWidth, filledHeight, containerWidth, containerHeight);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        }

        // 3. Draw the player's level on top in white.
        String levelText = String.valueOf(getCurrentLevel());
        int textWidth = client.textRenderer.getWidth(levelText);
        int textX = containerX + (containerWidth - textWidth) / 2;
        int textY = containerY - (containerHeight / 2) + 6; // Assuming ~8px text height
        int whiteColor = 0xFFFFFFFF;
        context.drawText(client.textRenderer, levelText, textX, textY, whiteColor, false);
    }

    // Placeholder for XP progress (0.0 to 1.0).
    private static float getTargetProgress() {
        return 0.60f;
    }

    // Placeholder for retrieving the player's level.
    private static int getCurrentLevel() {
        return 10;
    }
}