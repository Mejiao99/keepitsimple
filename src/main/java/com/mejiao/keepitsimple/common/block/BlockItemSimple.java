package com.mejiao.keepitsimple.common.block;

import com.mejiao.keepitsimple.KeepItSimple;
import com.mejiao.keepitsimple.item.ItemSimple;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockItemSimple {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KeepItSimple.MOD_ID);

    public static final RegistryObject<Block> SIMPLE_GENERATOR = register("simple_generator", () ->
            new BlockEnergyGeneratorSimple(AbstractBlock.Properties.of(Material.STONE)));

    public static void register(IEventBus iEventBus) {
        BLOCKS.register(iEventBus);
    }


    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        ItemSimple.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return ret;
    }

}
