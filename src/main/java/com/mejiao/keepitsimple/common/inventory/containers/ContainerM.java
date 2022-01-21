package com.mejiao.keepitsimple.common.inventory.containers;

import com.mejiao.keepitsimple.KeepItSimple;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerM {
    public static DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,
            KeepItSimple.MOD_ID);

    public static final RegistryObject<ContainerType<SimpleBlockContainer>> SIMPLE_BLOCK_CONTAINER =
            CONTAINERS.register("simple_block_container", () ->
                            IForgeContainerType.create(((windowId, inv, data) -> {
                              BlockPos pos =data.readBlockPos();
                              World world = inv.player.getCommandSenderWorld();
                              return new SimpleBlockContainer(windowId,world,pos,inv,inv.player);
                            })));



    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }



}
