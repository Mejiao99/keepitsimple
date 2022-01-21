package com.mejiao.keepitsimple.common.tile;

import com.mejiao.keepitsimple.KeepItSimple;
import com.mejiao.keepitsimple.common.block.BlockItemSimple;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TileSimpleEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,
            KeepItSimple.MOD_ID);

    public static final RegistryObject<TileEntityType<TileEnergySimple>> SIMPLE_ENERGY_TILE =
            TILE_ENTITIES.register("simpleenergytile", () -> TileEntityType.Builder.of(
                    TileEnergySimple::new, BlockItemSimple.SIMPLE_GENERATOR.get()).build(null));

    public static void register(IEventBus iEventBus) {
        TILE_ENTITIES.register(iEventBus);
    }

}
