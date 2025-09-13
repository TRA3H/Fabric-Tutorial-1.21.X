package net.cyrus.tutorialmod.block.custom

import net.cyrus.tutorialmod.TutorialMod
import net.cyrus.tutorialmod.item.ModItems
import net.cyrus.tutorialmod.util.ModTags
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MagicBlock(settings: AbstractBlock.Settings) : Block(settings) {

    override fun onUse(
        state: BlockState?,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hit: BlockHitResult
    ): ActionResult {

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 2f, 2f)
        return ActionResult.SUCCESS
    }

    override fun onEntityCollision(state: BlockState, world: World, pos: BlockPos, entity: Entity) {
        if (!world.isClient && entity is ItemEntity) tryTransform(world, pos, entity)

        super.onEntityCollision(state, world, pos, entity)
    }

    override fun onSteppedOn(world: World, pos: BlockPos, state: BlockState, entity: Entity) {
        if (!world.isClient && entity is ItemEntity) tryTransform(world, pos, entity)
        super.onSteppedOn(world, pos, state, entity)
    }

    private fun tryTransform(world: World, pos: BlockPos, itemEntity: ItemEntity) {
        val stack = itemEntity.stack
        if (!stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS)) return
        itemEntity.stack = ItemStack(Items.DIAMOND, stack.count)
        world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f)
    }

    override fun appendTooltip(
        stack: ItemStack,
        context: Item.TooltipContext,
        tooltip: MutableList<Text>,
        options: TooltipType
    ) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"))
        super.appendTooltip(stack, context, tooltip, options)
    }
}

private fun MagicBlock.isValidItem(stack: ItemStack): Boolean {
    return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS)
}
