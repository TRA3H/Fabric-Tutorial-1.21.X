package net.cyrus.tutorialmod.item

import net.cyrus.tutorialmod.TutorialMod
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Identifier
import java.util.EnumMap

object ModArmorMaterials {

    val PINK_GARNET_ARMOR_MATERIAL: RegistryEntry<ArmorMaterial> =
        registerArmorMaterial("pink_garnet") {
            ArmorMaterial(
                EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
                    put(ArmorItem.Type.BOOTS, 2)
                    put(ArmorItem.Type.LEGGINGS, 4)
                    put(ArmorItem.Type.CHESTPLATE, 6)
                    put(ArmorItem.Type.HELMET, 2)
                    put(ArmorItem.Type.BODY, 4)
                },
                20, // enchantability
                SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                { Ingredient.ofItems(ModItems.PINK_GARNET) }, // Supplier<Ingredient>
                listOf(
                    ArmorMaterial.Layer(Identifier.of(TutorialMod.MOD_ID, "pink_garnet"))
                ),
                0.0f, // toughness
                0.0f  // knockback resistance
            )
        }

    fun registerArmorMaterial(
        name: String,
        material: () -> ArmorMaterial
    ): RegistryEntry<ArmorMaterial> {
        val id = Identifier.of(TutorialMod.MOD_ID, name)
        return Registry.registerReference(Registries.ARMOR_MATERIAL, id, material())
    }


}