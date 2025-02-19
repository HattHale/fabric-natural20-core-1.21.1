package net.hatt.natural20core.entity.client;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.hatt.natural20core.Natural20Core;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    public static final EntityModelLayer DODO =
            new EntityModelLayer(Identifier.of(Natural20Core.MOD_ID, "dodo"), "main");

    public static final EntityModelLayer WARTURTLE =
            new EntityModelLayer(Identifier.of(Natural20Core.MOD_ID, "warturtle"), "main");
}