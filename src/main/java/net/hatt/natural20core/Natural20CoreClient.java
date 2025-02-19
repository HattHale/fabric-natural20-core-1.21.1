package net.hatt.natural20core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hatt.natural20core.entity.ModEntities;
import net.hatt.natural20core.entity.client.*;
import net.hatt.natural20core.screen.ModScreenHandlers;
import net.hatt.natural20core.screen.custom.WarturtleScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class Natural20CoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.DODO, DodoModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DODO, DodoRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.WARTURTLE, WarturtleModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.WARTURTLE, WarturtleRenderer::new);

        HandledScreens.register(ModScreenHandlers.WARTURTLE_SCREEN_HANDLER, WarturtleScreen::new);
    }
}
