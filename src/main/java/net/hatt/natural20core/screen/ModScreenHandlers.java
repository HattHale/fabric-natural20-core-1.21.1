package net.hatt.natural20core.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.hatt.natural20core.Natural20Core;
import net.hatt.natural20core.screen.custom.WarturtleScreenHandler;
import net.hatt.natural20core.screen.custom.CharBuildScreen;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Uuids;

public class ModScreenHandlers {
    public static final ScreenHandlerType<WarturtleScreenHandler> WARTURTLE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,
                    Identifier.of(Natural20Core.MOD_ID, "warturtle_screen_handler"),
                    new ExtendedScreenHandlerType<>(WarturtleScreenHandler::create, Uuids.PACKET_CODEC));

    public static void registerScreenHandler() {
        Natural20Core.LOGGER.info("Registering Screen Handlers for " + Natural20Core.MOD_ID);
    }
}
