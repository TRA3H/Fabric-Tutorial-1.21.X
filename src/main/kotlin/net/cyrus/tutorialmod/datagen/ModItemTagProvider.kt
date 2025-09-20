package net.cyrus.tutorialmod.datagen

import net.cyrus.tutorialmod.item.ModItems
import net.cyrus.tutorialmod.util.ModTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(output: FabricDataOutput, completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>)
    : FabricTagProvider.ItemTagProvider(output, completableFuture) {
    override fun configure(wrapperLookup: RegistryWrapper.WrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(ModItems.PINK_GARNET)
            .add(ModItems.CAULIFLOWER)
            .add(ModItems.CHISEL)
            .add(ModItems.RAW_PINK_GARNET)
            .add(ModItems.STARLIGHT_ASHES)

        getOrCreateTagBuilder(ItemTags.SWORDS)
            .add(ModItems.PINK_GARNET_SWORD)
        getOrCreateTagBuilder(ItemTags.PICKAXES)
            .add(ModItems.PINK_GARNET_PICKAXE)
        getOrCreateTagBuilder(ItemTags.SHOVELS)
            .add(ModItems.PINK_GARNET_SHOVEL)
        getOrCreateTagBuilder(ItemTags.AXES)
            .add(ModItems.PINK_GARNET_AXE)
        getOrCreateTagBuilder(ItemTags.HOES)
            .add(ModItems.PINK_GARNET_HOE)


        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.PINK_GARNET_HELMET)
            .add(ModItems.PINK_GARNET_CHESTPLATE)
            .add(ModItems.PINK_GARNET_LEGGINGS)
            .add(ModItems.PINK_GARNET_BOOTS)
    }
}