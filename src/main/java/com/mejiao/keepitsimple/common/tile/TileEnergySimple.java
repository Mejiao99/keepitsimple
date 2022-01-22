package com.mejiao.keepitsimple.common.tile;


import com.mejiao.keepitsimple.common.integration.energy.storage.SimpleEnergyStorage;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEnergySimple extends TileEntity implements ITickable {
    private final SimpleEnergyStorage storage = new SimpleEnergyStorage(5000, 2000, 1000);
    private final LazyOptional<SimpleEnergyStorage> energyStorage = LazyOptional.of(() -> storage);


    public TileEnergySimple(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public TileEnergySimple() {
        this(TileSimpleEntities.SIMPLE_ENERGY_TILE.get());
    }




    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        System.out.println("Side1: " + side);

        if (cap == CapabilityEnergy.ENERGY) {
            boolean b = true;
            LazyOptional<Boolean> booleanLazyOptional = LazyOptional.of(() -> b);
            return booleanLazyOptional.cast();
        }

        System.out.println("defaultprr: " + cap.getDefaultInstance());


        return energyStorage.cast();

        //return super.getCapability(cap, side);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityEnergy.ENERGY) {
            boolean b = true;
            LazyOptional<Boolean> booleanLazyOptional = LazyOptional.of(() -> b);
            return booleanLazyOptional.cast();
        }
        return super.getCapability(cap);
    }

    @Override
    public void tick() {

        if (storage.getEnergyStored() < storage.getMaxEnergyStored()) {

            this.storage.receiveEnergy(1500, false);

        }

        if (storage.getMaxEnergyStored() == 5000) {
        }

        System.out.println("getEnergyStored: " + storage.getEnergyStored());
        System.out.println("getMaxEnergyStored: " + storage.getMaxEnergyStored());

        System.out.println("TileEnergySimple.tick");

    }

}
