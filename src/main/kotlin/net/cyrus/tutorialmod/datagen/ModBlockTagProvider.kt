package net.cyrus.tutorialmod.datagen

import net.cyrus.tutorialmod.block.ModBlocks
import net.cyrus.tutorialmod.util.ModTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import java.util.concurrent.CompletableFuture


class ModBlockTagProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {


    override fun configure(wrapperLoopup: RegistryWrapper.WrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.MAGIC_BLOCK)
            .add(ModBlocks.PINK_GARNET_BLOCK)
            .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
            .add(ModBlocks.PINK_GARNET_ORE)
            .add(ModBlocks.RAW_PINK_GARNET_BLOCK)

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE)
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE_GATE)
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL)

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
            .addTag(BlockTags.NEEDS_IRON_TOOL)

    }

}
