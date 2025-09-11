package net.cyrus.tutorialmod.item

import net.cyrus.tutorialmod.TutorialMod
import net.cyrus.tutorialmod.block.ModBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {

    val PINK_GARNET_ITEMS_GROUP: ItemGroup = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModItems.PINK_GARNET) }
            .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
            .entries { displayContext, entries ->
                entries.add(ModItems.PINK_GARNET)
                entries.add(ModItems.RAW_PINK_GARNET)
            }
            .build()
        )

    val PINK_GARNET_BLOCKS_GROUP: ItemGroup = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TutorialMod.MOD_ID, "pink_garnet_block"),
        FabricItemGroup.builder()
            .icon { ItemStack(ModBlocks.PINK_GARNET_BLOCK) }
            .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
            .entries { displayContext, entries ->
                entries.add(ModBlocks.PINK_GARNET_BLOCK)
                entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                entries.add(ModBlocks.PINK_GARNET_ORE)
                entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
            }
            .build()
    )

    fun registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID)
    }

}