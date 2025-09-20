package net.cyrus.tutorialmod

import net.cyrus.tutorialmod.datagen.ModBlockTagProvider
import net.cyrus.tutorialmod.datagen.ModItemTagProvider
import net.cyrus.tutorialmod.datagen.ModLootTableProvider
import net.cyrus.tutorialmod.datagen.ModModelProvider
import net.cyrus.tutorialmod.datagen.ModRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

class TutorialModDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack: FabricDataGenerator.Pack = fabricDataGenerator.createPack()

        pack.addProvider(::ModBlockTagProvider)
        pack.addProvider(::ModItemTagProvider)
        pack.addProvider(::ModLootTableProvider)
        pack.addProvider(::ModModelProvider)
        pack.addProvider(::ModRecipeProvider)
	}
}