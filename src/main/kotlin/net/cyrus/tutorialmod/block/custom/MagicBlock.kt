package net.cyrus.tutorialmod.block.custom

import net.cyrus.tutorialmod.item.ModItems
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
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


    override fun onSteppedOn(world: World, pos: BlockPos?, state: BlockState?, entity: Entity?) {
        (entity as? ItemEntity)?.let {itemEntity ->
            val stack = itemEntity.stack
            if (stack.item === ModItems.RAW_PINK_GARNET){
                itemEntity.stack = ItemStack(Items.DIAMOND, stack.count)
            }
        }

        super.onSteppedOn(world, pos, state, entity)
    }

}