package net.cyrus.tutorialmod

import net.cyrus.tutorialmod.block.ModBlocks
import net.cyrus.tutorialmod.item.ModItemGroups
import net.fabricmc.api.ModInitializer
import net.cyrus.tutorialmod.item.ModItems
import net.fabricmc.fabric.api.registry.FuelRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object TutorialMod : ModInitializer {
	const val MOD_ID: String = "tutorialmod"
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)


	override fun onInitialize() {
		ModItemGroups.registerItemGroups()

		ModItems.registerModItems()
		ModBlocks.registerModBlocks()

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600)
	}
}