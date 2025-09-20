package net.cyrus.tutorialmod.item.custom

import net.cyrus.tutorialmod.item.ModArmorMaterials
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.world.World

class ModArmorItem(
    material: RegistryEntry<ArmorMaterial>,
    type: Type,
    settings: Settings
) : ArmorItem(material, type, settings) {

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (!world.isClient && entity is PlayerEntity) {
            if (hasFullSuitOfArmorOn(entity)) {
                evaluateArmorEffects(entity)
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    private fun evaluateArmorEffects(player: PlayerEntity) {
        for ((mapMaterial, effects) in MATERIAL_TO_EFFECT_MAP) {
            if (hasCorrectArmorOn(mapMaterial, player)) {
                addStatusEffectForMaterial(player, effects)
            }
        }
    }

    private fun addStatusEffectForMaterial(player: PlayerEntity, effects: List<StatusEffectInstance>) {
        val hasAll = effects.all { player.hasStatusEffect(it.effectType) }
        if (!hasAll) {
            for (e in effects) {
                player.addStatusEffect(
                    StatusEffectInstance(
                        e.effectType, e.duration, e.amplifier, e.isAmbient, e.shouldShowParticles()
                    )
                )
            }
        }
    }

    private fun hasFullSuitOfArmorOn(player: PlayerEntity): Boolean {
        val inv = player.inventory
        val boots = inv.getArmorStack(0)
        val leggings = inv.getArmorStack(1)
        val chest = inv.getArmorStack(2)
        val helmet = inv.getArmorStack(3)

        return !helmet.isEmpty && !chest.isEmpty && !leggings.isEmpty && !boots.isEmpty
    }

    private fun hasCorrectArmorOn(material: RegistryEntry<ArmorMaterial>, player: PlayerEntity): Boolean {
        val inv = player.inventory

        // All armor slots must be ArmorItem
        if (inv.armor.any { it.isEmpty || it.item !is ArmorItem }) return false

        val boots = inv.getArmorStack(0).item as ArmorItem
        val leggings = inv.getArmorStack(1).item as ArmorItem
        val chest = inv.getArmorStack(2).item as ArmorItem
        val helmet = inv.getArmorStack(3).item as ArmorItem

        return helmet.material == material &&
                chest.material == material &&
                leggings.material == material &&
                boots.material == material
    }

    companion object {
        private val MATERIAL_TO_EFFECT_MAP: Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> =
            mapOf(
                ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL to listOf(
                    StatusEffectInstance(StatusEffects.HASTE, 400, 2, false, false),
                    StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false)
                )
            )
    }
}
