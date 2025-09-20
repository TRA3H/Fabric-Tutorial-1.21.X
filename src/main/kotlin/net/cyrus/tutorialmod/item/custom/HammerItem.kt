package net.cyrus.tutorialmod.item.custom

import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.MiningToolItem
import net.minecraft.item.ToolMaterial
import net.minecraft.registry.tag.BlockTags
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction

class HammerItem(material: ToolMaterial, settings: Item.Settings) :
    MiningToolItem(material, BlockTags.PICKAXE_MINEABLE, settings) {

    companion object {
        fun getBlocksToBeDestroyed(
            range: Int,
            initial: BlockPos,
            player: ServerPlayerEntity
        ): List<BlockPos> {
            val positions = mutableListOf<BlockPos>()

            // NOTE: raycast signature can vary slightly per Yarn version
            val hit = player.raycast(20.0, 0.0f, false)
            if (hit.type == HitResult.Type.BLOCK) {
                val blockHit = hit as BlockHitResult
                when (blockHit.side) {
                    Direction.DOWN, Direction.UP -> {
                        for (x in -range..range) {
                            for (z in -range..range) {
                                positions += BlockPos(initial.x + x, initial.y, initial.z + z)
                            }
                        }
                    }
                    Direction.NORTH, Direction.SOUTH -> {
                        for (x in -range..range) {
                            for (y in -range..range) {
                                positions += BlockPos(initial.x + x, initial.y + y, initial.z)
                            }
                        }
                    }
                    Direction.EAST, Direction.WEST -> {
                        for (z in -range..range) {
                            for (y in -range..range) {
                                positions += BlockPos(initial.x, initial.y + y, initial.z + z)
                            }
                        }
                    }
                    else -> { /* no-op */ }
                }
            }

            return positions
        }
    }
}
