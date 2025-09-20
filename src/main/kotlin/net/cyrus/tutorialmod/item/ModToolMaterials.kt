package net.cyrus.tutorialmod.item

import net.cyrus.tutorialmod.util.ModTags
import net.minecraft.block.Block
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import java.util.function.Supplier


enum class ModToolMaterials(
    private val inverseTagKey: TagKey<Block>,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairSupplier: Supplier<Ingredient>
) : ToolMaterial {

    PINK_GARNET(
        ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL,
        itemDurability = 1200,
        miningSpeed = 5.0f,
        attackDamage = 4.0f,
        enchantability = 22,
        repairSupplier = Supplier { Ingredient.ofItems(ModItems.PINK_GARNET) }
    );


    override fun getDurability(): Int = itemDurability
    override fun getMiningSpeedMultiplier(): Float = miningSpeed
    override fun getAttackDamage(): Float = attackDamage
    override fun getEnchantability(): Int = enchantability
    override fun getRepairIngredient(): Ingredient = repairSupplier.get()
    override fun getInverseTag(): TagKey<Block> = inverseTagKey


}