package net.hatt.natural20core.screen.custom;

import net.minecraft.advancement.PlacedAdvancement;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.advancement.AdvancementTab;
import net.minecraft.client.gui.screen.advancement.AdvancementWidget;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.client.network.ClientAdvancementManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

import java.awt.Point;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharBuildScreen extends AdvancementsScreen {
    private static final String MOD_NAMESPACE = "natural20core:classes/";
    private static final Set<String> ALLOWED_CLASSES = new HashSet<>();
    private static final int PAGE_OFFSET_X = 16;
    private static final int PAGE_OFFSET_Y = 18;
    private final Set<PlacedAdvancement> trackedAdvancements = new HashSet<>();
    @Nullable
    private net.minecraft.advancement.AdvancementEntry currentAdvancementEntry;

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
        super.init();
        for (Element element : this.children()) {
            if (element instanceof TextWidget textWidget) {
                textWidget.setMessage(Text.of("Character Builder"));
                int textWidth = this.textRenderer.getWidth("Character Builder") + 10;
                textWidget.setWidth(textWidth);
                textWidget.setTextColor(0xFFFFD700);
                break;
            }
        }
    }

    @Override
    public void onRootAdded(PlacedAdvancement root) {
        String advancementName = root.getAdvancementEntry().id().toString();
        if (advancementName.startsWith(MOD_NAMESPACE) && ALLOWED_CLASSES.contains(advancementName.replace(MOD_NAMESPACE, ""))) {
            trackedAdvancements.add(root);
            super.onRootAdded(root);
        }
    }

    @Override
    public void onDependentAdded(PlacedAdvancement dependent) {
        trackedAdvancements.add(dependent);
        super.onDependentAdded(dependent);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int windowLeft = (this.width - 234) / 2;
            int windowTop  = (this.height - 113) / 2;
            int treeX = windowLeft + PAGE_OFFSET_X;
            int treeY = windowTop + PAGE_OFFSET_Y;
            AdvancementTab selectedTab = getSelectedTab();
            if (selectedTab != null) {
                net.minecraft.advancement.AdvancementEntry selectedRootEntry = selectedTab.getRoot().getAdvancementEntry();
                for (PlacedAdvancement advancement : trackedAdvancements) {
                    if (advancement.getRoot().getAdvancementEntry().equals(selectedRootEntry)) {
                        AdvancementWidget widget = this.getAdvancementWidget(advancement);
                        if (widget != null && isMouseOverWidget(widget, mouseX, mouseY, treeX, treeY, selectedTab)) {
                            System.out.println("Advancement Clicked: " + advancement.getAdvancementEntry().value().name().toString());
                            return true;
                        }
                    }
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private Point convertToTabCoords(double mouseX, double mouseY, int treeX, int treeY, AdvancementTab tab) {
        int tabOriginX = getTabOriginX(tab);
        int tabOriginY = getTabOriginY(tab);
        int relativeX = (int) (mouseX - treeX - tabOriginX);
        int relativeY = (int) (mouseY - treeY - tabOriginY);
        return new Point(relativeX, relativeY);
    }

    private int getTabOriginX(AdvancementTab tab) {
        try {
            Field originXField = AdvancementTab.class.getDeclaredField("originX");
            originXField.setAccessible(true);
            return MathHelper.floor((Double) originXField.get(tab));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int getTabOriginY(AdvancementTab tab) {
        try {
            Field originYField = AdvancementTab.class.getDeclaredField("originY");
            originYField.setAccessible(true);
            return MathHelper.floor((Double) originYField.get(tab));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private boolean isMouseOverWidget(AdvancementWidget widget, double mouseX, double mouseY, int treeX, int treeY, AdvancementTab tab) {
        Point tabCoords = convertToTabCoords(mouseX, mouseY, treeX, treeY, tab);
        int relativeX = tabCoords.x;
        int relativeY = tabCoords.y;
        int widgetX = widget.getX();
        int widgetY = widget.getY();
        int width = 11;
        int height = 12;
        return relativeX >= widgetX - width && relativeX <= widgetX + width &&
                relativeY >= widgetY - height && relativeY <= widgetY + height;
    }

    @Override
    public void selectTab(@Nullable net.minecraft.advancement.AdvancementEntry advancement) {
        super.selectTab(advancement);
        this.currentAdvancementEntry = advancement;
    }

    @Nullable
    private AdvancementTab getSelectedTab() {
        try {
            Field selectedTabField = AdvancementsScreen.class.getDeclaredField("selectedTab");
            selectedTabField.setAccessible(true);
            return (AdvancementTab) selectedTabField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    private Map<?, ?> getTabs() {
        try {
            Field tabsField = AdvancementsScreen.class.getDeclaredField("tabs");
            tabsField.setAccessible(true);
            return (Map<?, ?>) tabsField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}