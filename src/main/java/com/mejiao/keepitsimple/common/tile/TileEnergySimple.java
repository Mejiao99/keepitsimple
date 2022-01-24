package com.mejiao.keepitsimple.common.tile;


import com.mejiao.keepitsimple.common.integration.energy.storage.SimpleEnergyStorage;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEnergySimple extends TileEntity implements ITickableTileEntity {
    CompoundNBT compound = new CompoundNBT();
    private final SimpleEnergyStorage storage = new SimpleEnergyStorage(5000, 50, 10, 5000);
    private final LazyOptional<SimpleEnergyStorage> energyStorage = LazyOptional.of(() -> storage);
    EnergyStorage targetStorage;

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
        System.out.println("Cap1: " + cap);
        System.out.println("cap.getDefaultInstance()" + cap.getDefaultInstance());

        if (cap == CapabilityEnergy.ENERGY) {
            if (cap.getDefaultInstance() instanceof EnergyStorage
            ) {
                System.out.println("XL1");
                targetStorage = (EnergyStorage) cap.getDefaultInstance();
            }
            return energyStorage.cast();
        }

        System.out.println("defaultprr: " + cap.getDefaultInstance());
        return energyStorage.cast();
    }

//    @Nonnull
//    @Override
//    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
// //       if (cap == CapabilityEnergy.ENERGY) {
////            boolean b = true;
////            LazyOptional<Boolean> booleanLazyOptional = LazyOptional.of(() -> b);
////            return booleanLazyOptional.cast();
//        }
//
//        return super.getCapability(cap);
//    }


    @Override
    public void tick() {
        storage.save(compound);
        if (storage.canReceive()) {
            if (storage.getEnergyStored() < storage.getMaxEnergyStored()) {
                System.out.println("paso por aqui");
                System.out.println(storage.getEnergyStored());
            }
            //System.out.println("getEnergyStored : " + targetStorage.getEnergyStored());
//            System.out.println("canExtract: " + targetStorage.canExtract());
//            System.out.println("canReceive: " + targetStorage.canReceive());

            //System.out.println("getEnergyStored: " + storage.getEnergyStored());
            //System.out.println("getMaxEnergyStored: " + storage.getMaxEnergyStored());

        }

    }
}
