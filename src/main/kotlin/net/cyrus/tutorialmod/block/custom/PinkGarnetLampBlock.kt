package net.cyrus.tutorialmod.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.ActionResult
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class PinkGarnetLampBlock (settings: Settings) : Block(settings) {

    companion object{ val CLICKED: BooleanProperty = BooleanProperty.of("clicked") }

    init {
        // optional but typical: set initial value
        defaultState = stateManager.defaultState.with(CLICKED, false)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hit: BlockHitResult
    ): ActionResult {
        if(!world.isClient){
            world.setBlockState(pos, state.cycle(CLICKED))
        }

        return ActionResult.SUCCESS
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState?>) {
        builder.add(CLICKED)
    }

}