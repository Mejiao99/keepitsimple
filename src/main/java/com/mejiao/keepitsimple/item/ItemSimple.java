package com.mejiao.keepitsimple.item;

import com.mejiao.keepitsimple.KeepItSimple;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSimple {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KeepItSimple.MOD_ID);

    public static final RegistryObject<Item> SIMPLE_ITEM = ITEMS.register(
            "simple_item", () -> new Item(
                    new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static void register(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }

}
