package net.cyrus.tutorialmod.item

import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects

object ModFoodComponent {

    val CAULTIFLOWER: FoodComponent = FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
        .statusEffect(StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build()

}