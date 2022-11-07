package dev.wizatar08.wtrendmod.init;

import com.mojang.datafixers.types.templates.Tag;
import dev.wizatar08.wtrendmod.WTREndMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Properties;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WTREndMod.MODID);

    // General end dimension
    public static final RegistryObject<Block> END_STONE_DIAMOND_ORE = register("end_stone_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4.0F, 12.0F), UniformInt.of(10, 25)),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> INFUSED_END_STONE = register("infused_end_stone",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.AMETHYST_CLUSTER).strength(0.4f, 0.5f), UniformInt.of(3, 8)),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    // Endillic forest
    public static final RegistryObject<Block> ENDILLIC_PLANKS = register("endillic_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.WOOD).strength(2.3f, 20.0f)),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> ENDILLIC_MOSS_END_STONE = register("endillic_moss_end_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.4f, 11.7f)),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> ENDILLIC_MOSS = register("endillic_moss",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS).strength(0.2f, 0.3f)),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Block> ENDILLIC_LOG = register("endillic_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.3f, 30.0f)),
            new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final RegistryObject<Block> ENDILLIC_SPROUTS = register("endillic_sprouts",
            () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.3f, 4.3f).randomTicks().noOcclusion().isValidSpawn(BlockInit::never).isSuffocating(BlockInit::never).sound(SoundType.AZALEA_LEAVES)),
            new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final RegistryObject<Block> GLOWING_ENDILLIC_SPROUTS = register("glowing_endillic_sprouts",
            () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.3f, 4.3f).lightLevel((light) -> 12).randomTicks().noOcclusion().isValidSpawn(BlockInit::never).isSuffocating(BlockInit::never).sound(SoundType.AZALEA_LEAVES)),
            new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));

    // Hollowlands
    public static final RegistryObject<Block> HOLLOW_CLUSTER = register("hollow_cluster",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.3f, 6.4f)),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant());
    public static final RegistryObject<Block> HARDENED_HOLLOW_CLUSTER = register("hardened_hollow_cluster",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5f, 9.6f).requiresCorrectToolForDrops()),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant());
    public static final RegistryObject<Block> HOLLOW_LAMP = register("hollow_lamp",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.2f, 11.7f).lightLevel((light) -> 15).requiresCorrectToolForDrops()),
            new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).fireResistant());
    public static final RegistryObject<Block> SHADOW_STONE = register("shadow_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.7f, 7.9f).requiresCorrectToolForDrops()),
            new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));


    /*
    BIOME IDEAS:
    - Hollowlands (hollow and shadow blocks) (black)
    - Endillic forest (and variants) (pink)
    - Chorus bloom (purple)
    - End spikes
    - Searing monoliths (yellow)
    - Icy Ruins (blue)
    - Isolated Plateau (green)
     */

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return (boolean)false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;

    }

    public static class Tags {
        public static final TagKey<Block> NEEDS_HOLLOW_TOOL = create("mineable/needs_hollow_tool");

        private static TagKey<Block> create(String location) {
            return BlockTags.create(new ResourceLocation(WTREndMod.MODID, location));
        }
    }
}
