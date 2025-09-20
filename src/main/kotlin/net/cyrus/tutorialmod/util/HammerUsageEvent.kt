import net.cyrus.tutorialmod.item.custom.HammerItem
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object HammerUsageEvent : PlayerBlockBreakEvents.Before {

    private val HARVESTED_BLOCKS = HashSet<BlockPos>()

    override fun beforeBlockBreak(
        world: World,
        player: net.minecraft.entity.player.PlayerEntity,
        pos: BlockPos,
        state: BlockState,
        blockEntity: BlockEntity?
    ): Boolean {
        val mainHand = player.mainHandStack
        val item = mainHand.item

        if (item is HammerItem && player is ServerPlayerEntity) {
            // prevent recursion for the blocks we break programmatically
            if (HARVESTED_BLOCKS.contains(pos)) return true

            val positions = HammerItem.getBlocksToBeDestroyed(1, pos, player)
            for (target in positions) {
                // skip the original block, and skip blocks this hammer can't drop correctly
                if (target == pos || !item.isCorrectForDrops(mainHand, world.getBlockState(target))) continue

                HARVESTED_BLOCKS.add(target)
                player.interactionManager.tryBreakBlock(target)
                HARVESTED_BLOCKS.remove(target)
            }
        }

        return true
    }
}
