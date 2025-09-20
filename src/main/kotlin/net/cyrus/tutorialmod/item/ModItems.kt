package net.cyrus.tutorialmod.item

import net.cyrus.tutorialmod.TutorialMod
import net.cyrus.tutorialmod.item.custom.ChiselItem
import net.cyrus.tutorialmod.item.custom.HammerItem
import net.cyrus.tutorialmod.item.custom.ModArmorItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ArmorItem
import net.minecraft.item.AxeItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.util.Identifier
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

object ModItems {
    val PINK_GARNET: Item = registerItem("pink_garnet", Item(Item.Settings()))
    val RAW_PINK_GARNET: Item = registerItem("raw_pink_garnet", Item(Item.Settings()))

    val CHISEL: Item = registerItem("chisel", ChiselItem(Item.Settings().maxDamage(32)))
    val CAULIFLOWER: Item = registerItem("cauliflower", object: Item(Item.Settings().food(ModFoodComponent.CAULTIFLOWER)){
        override fun appendTooltip(
            stack: ItemStack?,
            context: TooltipContext?,
            tooltip: MutableList<Text>,
            type: TooltipType?
        ) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"))
            super.appendTooltip(stack, context, tooltip, type)
        }
    })

    val STARLIGHT_ASHES = registerItem("starlight_ashes", Item(Item.Settings()))

    val PINK_GARNET_SWORD: Item = registerItem("pink_garnet_sword",
        SwordItem(ModToolMaterials.PINK_GARNET, Item.Settings().attributeModifiers(
                SwordItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 3, -2.4f)
                )
            )
        )
    val PINK_GARNET_PICKAXE: Item = registerItem("pink_garnet_pickaxe",
        PickaxeItem(ModToolMaterials.PINK_GARNET, Item.Settings().attributeModifiers(
                PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1f, -2.8f)
                )
            )
        )
    val PINK_GARNET_SHOVEL: Item = registerItem("pink_garnet_shovel",
        ShovelItem(ModToolMaterials.PINK_GARNET, Item.Settings().attributeModifiers(
                ShovelItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 1.5f, -3.0f)
            )
        )
    )
    val PINK_GARNET_AXE: Item = registerItem("pink_garnet_axe",
        AxeItem(ModToolMaterials.PINK_GARNET, Item.Settings().attributeModifiers(
                AxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 6f, -3.2f)
            )
        )
    )
    val PINK_GARNET_HOE: Item = registerItem("pink_garnet_hoe",
        HoeItem(ModToolMaterials.PINK_GARNET, Item.Settings().attributeModifiers(
                HoeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 0f, -3f)
            )
        )
    )

    val PINK_GARNET_HAMMER: Item = registerItem("pink_garnet_hammer",
        HammerItem(ModToolMaterials.PINK_GARNET, Item.Settings().attributeModifiers(
                PickaxeItem.createAttributeModifiers(ModToolMaterials.PINK_GARNET, 7f, -3.4f)
            )
        )
    )

    val PINK_GARNET_HELMET: Item = registerItem("pink_garnet_helmet",
        ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.HELMET, Item.Settings()
            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15)
            )
        )
    )
    val PINK_GARNET_CHESTPLATE: Item = registerItem("pink_garnet_chestplate",
        ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, Item.Settings()
            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15)
            )
        )
    )
    val PINK_GARNET_LEGGINGS: Item = registerItem("pink_garnet_leggings",
        ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, Item.Settings()
            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15)
            )
        )
    )
    val PINK_GARNET_BOOTS: Item = registerItem("pink_garnet_boots",
        ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, Item.Settings()
            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15)
            )
        )
    )

    fun registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID)

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { entries ->
            entries.add(PINK_GARNET)
            entries.add(RAW_PINK_GARNET)
        }
    }

    private fun registerItem(name: String, item: Item): Item =
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item)
}