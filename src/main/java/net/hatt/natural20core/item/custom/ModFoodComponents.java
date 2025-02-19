package net.hatt.natural20core.item.custom;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .build();
}
