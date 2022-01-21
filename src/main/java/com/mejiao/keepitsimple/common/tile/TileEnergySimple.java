package com.mejiao.keepitsimple.common.tile;

import com.mejiao.keepitsimple.common.integration.energy.forgeenergy.SimpleEnergyStorage;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEnergySimple extends TileEntity implements ITickableTileEntity {
    private final SimpleEnergyStorage storage = new SimpleEnergyStorage(5000);
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
            energyStorage.cast();
        }

        System.out.println("Side2 : " + side);
        return super.getCapability(cap, side);
    }


    @Override
    public void tick() {

        if (storage.getEnergyStored() < storage.getMaxEnergyStored()) {

            this.storage.receiveEnergy(100, false);

        }


        System.out.println("getEnergyStored: " + storage.getEnergyStored());
        System.out.println("getMaxEnergyStored: " + storage.getMaxEnergyStored());
        System.out.println("TileEnergySimple.tick");

    }

}
