package net.cyrus.tutorialmod.datagen

import net.cyrus.tutorialmod.item.ModItems
import net.cyrus.tutorialmod.util.ModTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
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
    }
}