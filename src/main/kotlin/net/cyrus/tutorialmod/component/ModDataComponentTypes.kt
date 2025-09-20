package net.cyrus.tutorialmod.component

import net.cyrus.tutorialmod.TutorialMod
import net.minecraft.component.ComponentType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos

object ModDataComponentTypes {

    val COORDINATES: ComponentType<BlockPos> = register("coordinates") { builder -> builder.codec(BlockPos.CODEC) }

    private fun <T> register(
        name: String,
        builderOp: (ComponentType.Builder<T>) -> ComponentType.Builder<T>
    ): ComponentType<T> {
        val id = Identifier.of(TutorialMod.MOD_ID, name)
        val built: ComponentType<T> = builderOp(ComponentType.builder<T>()).build()
        return Registry.register(Registries.DATA_COMPONENT_TYPE, id, built)
    }
    fun registerDataComponentTypes(){
        TutorialMod.LOGGER.info("Register Data Component Types for " + TutorialMod.MOD_ID)
    }

}