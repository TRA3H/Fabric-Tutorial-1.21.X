package net.cyrus.tutorialmod.block

import net.minecraft.block.Block
import net.cyrus.tutorialmod.TutorialMod
import net.cyrus.tutorialmod.block.custom.PinkGarnetLampBlock
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockSetType
import net.minecraft.block.ButtonBlock
import net.minecraft.block.DoorBlock
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.TrapdoorBlock
import net.minecraft.block.WallBlock
import net.minecraft.block.WoodType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

object ModBlocks {

    val PINK_GARNET_BLOCK: Block = registerBlock(
        name = "pink_garnet_block",
        block = Block(AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK))
    )

    val RAW_PINK_GARNET_BLOCK: Block = registerBlock (
        name = "raw_pink_garnet_block",
        block = Block(AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
        )
    )

    val MAGIC_BLOCK: Block = registerBlock(
        name = "magic_block",
        block = Block(AbstractBlock.Settings.create()
            .strength(1f)
            .requiresTool()
        )
    )

    val PINK_GARNET_ORE: Block = registerBlock(
        name = "pink_garnet_ore",
        ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create()
                .strength(3f)
                .requiresTool()
        )
    )
    val PINK_GARNET_DEEPSLATE_ORE: Block = registerBlock(
        name = "pink_garnet_deepslate_ore",
        ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create()
                .strength(4f)
                .requiresTool()
                .sounds(BlockSoundGroup.DEEPSLATE)
        )
    )

    val PINK_GARNET_STAIRS: Block = registerBlock(
        name = "pink_garnet_stairs",
        block = StairsBlock(PINK_GARNET_BLOCK.defaultState,
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_SLAB: Block = registerBlock(
        name = "pink_garnet_slab",
        block = SlabBlock(
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_BUTTON: Block = registerBlock(
        name = "pink_garnet_button",
        ButtonBlock(
            BlockSetType.IRON, 2,
            AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()
        )
    )

    val PINK_GARNET_PRESSURE_PLATE: Block = registerBlock(
        name = "pink_garnet_plate",
        PressurePlateBlock(BlockSetType.IRON,
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_FENCE: Block = registerBlock(
        name = "pink_garnet_fence",
        FenceBlock(
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_WALL: Block = registerBlock(
        name = "pink_garnet_wall",
        WallBlock(
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_DOOR: Block = registerBlock(
        name = "pink_garnet_door",
        DoorBlock(BlockSetType.IRON,
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_TRAPDOOR: Block = registerBlock(
        name = "pink_garnet_trapdoor",
        TrapdoorBlock(BlockSetType.IRON,
            AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()
        )
    )

    val PINK_GARNET_FENCE_GATE: Block = registerBlock(
        name = "pink_garnet_fence_gate",
        FenceGateBlock(WoodType.ACACIA,
            AbstractBlock.Settings.create().strength(2f).requiresTool()
        )
    )

    val PINK_GARNET_LAMP: Block = registerBlock(
        name = "pink_garnet_lamp",
        block = PinkGarnetLampBlock(AbstractBlock.Settings.create()
            .strength(1f)
            .requiresTool()
            .luminance { state -> if(state.get(PinkGarnetLampBlock.CLICKED)) 15 else 0 }

        )
    )

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID,name),block)
    }

    private fun registerBlockItem(name: String, block: Block) {
        Registry.register(
            Registries.ITEM,
            Identifier.of(TutorialMod.MOD_ID, name),
            BlockItem(block, Item.Settings()))
    }

    fun registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { entries ->
            entries.add(ModBlocks.PINK_GARNET_BLOCK)
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK)
        }

    }
}