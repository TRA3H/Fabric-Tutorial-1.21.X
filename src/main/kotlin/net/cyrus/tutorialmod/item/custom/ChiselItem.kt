package net.cyrus.tutorialmod.item.custom


import net.cyrus.tutorialmod.block.ModBlocks
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.client.gui.screen.Screen
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.world.World


class ChiselItem(settings: Item.Settings) : Item(settings) {
    val CHISEL_MAP: Map<Block, Block> by lazy {
        mapOf(
            Blocks.STONE to Blocks.STONE_BRICKS,
            Blocks.END_STONE to Blocks.END_STONE_BRICKS,
            Blocks.OAK_LOG to ModBlocks.PINK_GARNET_BLOCK,
            Blocks.GOLD_BLOCK to Blocks.NETHERITE_BLOCK
        )
    }

    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        val world: World = context.world
        val pos = context.blockPos
        val clickedBlock = world.getBlockState(pos).block
        val out = CHISEL_MAP[clickedBlock] ?: return ActionResult.PASS


        if(!world.isClient){
            world.setBlockState(pos, out.defaultState)

            val serverWorld = world as ServerWorld
            val player = context.player as? ServerPlayerEntity?: return ActionResult.SUCCESS
            val stack = context.stack

            stack.damage(1, serverWorld, player) { item ->
                player.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND)
            }

            world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS)
        }

        return ActionResult.SUCCESS
    }

    override fun appendTooltip(stack: ItemStack, context: TooltipContext, tooltip: MutableList<Text>, type: TooltipType) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.tutorial.chisel.shift_down"))
        } else {
            tooltip.add(Text.translatable("tooltip.tutorial.chisel"))
        }

        super.appendTooltip(stack, context, tooltip, type)
    }

}