package net.cyrus.tutorialmod.datagen

import net.cyrus.tutorialmod.block.ModBlocks
import net.cyrus.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModLootTableProvider (dataOutput: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>)
    : FabricBlockLootTableProvider(dataOutput, registryLookup) {
    override fun generate() {
        addDrop(ModBlocks.PINK_GARNET_BLOCK)
        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK)
        addDrop(ModBlocks.MAGIC_BLOCK)
        addDrop(ModBlocks.PINK_GARNET_ORE)
        addDrop(ModBlocks.PINK_GARNET_ORE, oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET))
        addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModItems.RAW_PINK_GARNET, 3f, 7f))

        addDrop(ModBlocks.PINK_GARNET_STAIRS)
        addDrop(ModBlocks.PINK_GARNET_SLAB, slabDrops(ModBlocks.PINK_GARNET_SLAB))

        addDrop(ModBlocks.PINK_GARNET_BUTTON)
        addDrop(ModBlocks.PINK_GARNET_PRESSURE_PLATE)

        addDrop(ModBlocks.PINK_GARNET_WALL)
        addDrop(ModBlocks.PINK_GARNET_FENCE)
        addDrop(ModBlocks.PINK_GARNET_FENCE_GATE)

        addDrop(ModBlocks.PINK_GARNET_DOOR, doorDrops(ModBlocks.PINK_GARNET_DOOR))
        addDrop(ModBlocks.PINK_GARNET_TRAPDOOR)

    }

    fun multipleOreDrops(
        drop: Block,
        item: Item,
        minDrops: Float,
        maxDrops: Float
    ): LootTable.Builder {
        val impl: RegistryWrapper.Impl<Enchantment> =
            this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT)

        // If your `applyExplosionDecay` overload requires a LeafEntry.Builder<?>,
        // Kotlin may need an explicit type argument/cast:
        val entry: LeafEntry.Builder<*> =
            ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))

        return this.dropsWithSilkTouch(
            drop,
            this.applyExplosionDecay(drop, entry)
        )
    }
}