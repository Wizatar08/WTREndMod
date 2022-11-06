package dev.wizatar08.wtrendmod.init;

import dev.wizatar08.wtrendmod.WTREndMod;
import dev.wizatar08.wtrendmod.base.ModArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WTREndMod.MODID);

    public static final RegistryObject<Item> HOLLOW_SHARD = ITEMS.register("hollow_shard",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
    public static final RegistryObject<SwordItem> HOLLOW_SWORD = ITEMS.register("hollow_sword",
        () -> new SwordItem(ToolTiers.HOLLOW, 5, -2.5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<PickaxeItem> HOLLOW_PICKAXE = ITEMS.register("hollow_pickaxe",
            () -> new PickaxeItem(ToolTiers.HOLLOW, 1, -2.1f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<ShovelItem> HOLLOW_SHOVEL = ITEMS.register("hollow_shovel",
            () -> new ShovelItem(ToolTiers.HOLLOW, 1.5f, -4.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<AxeItem> HOLLOW_AXE = ITEMS.register("hollow_axe",
            () -> new AxeItem(ToolTiers.HOLLOW, 6.5f, -3.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<HoeItem> HOLLOW_HOE = ITEMS.register("hollow_hoe",
            () -> new HoeItem(ToolTiers.HOLLOW, -1, -1.4f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
    public static final RegistryObject<ArmorItem> HOLLOW_HELMET = ITEMS.register("hollow_helmet",
            () -> new ArmorItem(ArmorTiers.HOLLOW, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<ArmorItem> HOLLOW_CHESTPLATE = ITEMS.register("hollow_chestplate",
            () -> new ArmorItem(ArmorTiers.HOLLOW, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<ArmorItem> HOLLOW_LEGGINGS = ITEMS.register("hollow_leggings",
            () -> new ArmorItem(ArmorTiers.HOLLOW, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<ArmorItem> HOLLOW_BOOTS = ITEMS.register("hollow_boots",
            () -> new ArmorItem(ArmorTiers.HOLLOW, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));


    public static final RegistryObject<Item> ENDILLIC_SCRAPS = ITEMS.register("endillic_scraps",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> ENDILLIC_BERRY = ITEMS.register("endillic_berry",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(Foods.ENDILLIC_BERRY)));

    public static class Foods {
        public static final FoodProperties ENDILLIC_BERRY = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(1.4f)
                .effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 1), 1.0f)
                .build();
    }

    public static class ToolTiers {
        public static final Tier HOLLOW = new ForgeTier(1, 357, 5.1f, 1.4f, 26, BlockInit.Tags.NEEDS_HOLLOW_TOOL, () -> Ingredient.of(ItemInit.HOLLOW_SHARD.get()));
    }

    public static class ArmorTiers {
        public static final ArmorMaterial HOLLOW = new ModArmorMaterial("hollow", 18, new int[]{1, 3, 4, 1}, 26, SoundEvents.ARMOR_EQUIP_CHAIN, 11f, 0.3f, () -> Ingredient.of(ItemInit.HOLLOW_SHARD.get()));
    }
}
