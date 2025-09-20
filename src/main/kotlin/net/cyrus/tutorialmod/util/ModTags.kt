package net.cyrus.tutorialmod.util

import net.cyrus.tutorialmod.TutorialMod
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier


class ModTags {

   object Blocks{
       val NEEDS_PINK_GARNET_TOOL: TagKey<Block> = createTag("needs_pink_garnet_tool")
       val INCORRECT_FOR_PINK_GARNET_TOOL: TagKey<Block> = createTag("incorrect_for_pink_garnet_tool")

       private fun createTag(name: String): TagKey<Block> {
           return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name))
       }
   }

    object Items {

        val TRANSFORMABLE_ITEMS: TagKey<Item> = createTag("transformable_items")

        private fun createTag(name: String): TagKey<Item> {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name))
        }
    }

}