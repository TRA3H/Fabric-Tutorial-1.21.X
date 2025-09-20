package net.cyrus.tutorialmod.datagen

import net.cyrus.tutorialmod.block.ModBlocks
import net.cyrus.tutorialmod.block.custom.PinkGarnetLampBlock
import net.cyrus.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.data.client.TextureMap
import net.minecraft.data.client.TexturedModel
import net.minecraft.data.client.VariantsBlockStateSupplier
import net.minecraft.item.ArmorItem

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        val pinkGarnetPool : BlockStateModelGenerator.BlockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK)

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK)

        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS)
        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB)

        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON)
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE)

        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE)
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE)
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL)

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR)
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR)



        val lampOffId = TexturedModel.CUBE_ALL.upload(
            ModBlocks.PINK_GARNET_LAMP,
            blockStateModelGenerator.modelCollector
        )


        val lampOnId = blockStateModelGenerator.createSubModel(
            ModBlocks.PINK_GARNET_LAMP,
            "_on",
            Models.CUBE_ALL,
            TextureMap::all
        )


        blockStateModelGenerator.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(
                    BlockStateModelGenerator.createBooleanModelMap(
                        PinkGarnetLampBlock.CLICKED,
                        lampOnId,
                        lampOffId
                    )
                )
        )

        // inventory model for the lamp item (use the OFF model)
        blockStateModelGenerator.registerParentedItemModel(
            ModBlocks.PINK_GARNET_LAMP, lampOffId
        )

    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED)
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED)

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED)
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED)
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED)

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD)
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD)

        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD)

        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_HELMET as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_CHESTPLATE as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_LEGGINGS as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_BOOTS as ArmorItem)
    }
}