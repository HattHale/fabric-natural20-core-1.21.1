package net.hatt.natural20core.screen.custom;

import net.minecraft.advancement.PlacedAdvancement;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.advancement.AdvancementTab;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.network.ClientAdvancementManager;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class CharBuildScreen extends AdvancementsScreen {
    private static final String MOD_NAMESPACE = "natural20core:classes/";
    private static final Set<String> ALLOWED_CLASSES = new HashSet<>();

    static {
        ALLOWED_CLASSES.add("barbarian_root");
        ALLOWED_CLASSES.add("bard_root");
        ALLOWED_CLASSES.add("cleric_root");
        ALLOWED_CLASSES.add("druid_root");
        ALLOWED_CLASSES.add("fighter_root");
        ALLOWED_CLASSES.add("monk_root");
        ALLOWED_CLASSES.add("paladin_root");
        ALLOWED_CLASSES.add("ranger_root");
        ALLOWED_CLASSES.add("rogue_root");
        ALLOWED_CLASSES.add("sorcerer_root");
        ALLOWED_CLASSES.add("warlock_root");
        ALLOWED_CLASSES.add("wizard_root");
    }

    public CharBuildScreen(ClientAdvancementManager advancementManager, @Nullable Screen parent) {
        super(advancementManager, parent);
    }

    @Override
    protected void init() {
        super.init(); // Initialize the UI normally

        // Find the title widget and change its text
        for (Element element : this.children()) {
            if (element instanceof TextWidget textWidget) {
                textWidget.setMessage(Text.of("Character Builder"));

                int textWidth = this.textRenderer.getWidth("Character Builder") + 10; // Add padding
                textWidget.setWidth(textWidth);
                textWidget.setTextColor(0xFFFFD700);
                textWidget.setPosition(textWidget.getX() - 12, textWidget.getY());

                break;
            }
        }
    }

    @Override
    public void onRootAdded(PlacedAdvancement root) {
        String advancementName = root.getAdvancementEntry().toString();
        System.out.println("Checking advancement: " + advancementName);

        // Only allow class advancements
        if (advancementName.startsWith(MOD_NAMESPACE) && ALLOWED_CLASSES.contains(advancementName.replace(MOD_NAMESPACE, ""))) {
            System.out.println("Adding class tab: " + advancementName);
            super.onRootAdded(root);
        } else {
            System.out.println("Ignoring advancement: " + advancementName);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) { // Left click
            System.out.println("Advancement clicked!");
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }
}