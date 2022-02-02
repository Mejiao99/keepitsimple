package com.mejiao.keepitsimple.common.tile;


import com.mejiao.keepitsimple.common.integration.energy.storage.SimpleEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEnergySimple extends TileEntity implements ITickableTileEntity {

    private final SimpleEnergyStorage storage = new SimpleEnergyStorage(5000, 50, 10, 400);
    private final LazyOptional<SimpleEnergyStorage> energyStorage = LazyOptional.of(() -> storage);

    Boolean vOpTrue = true;
    private LazyOptional<Boolean> vTrue = LazyOptional.of(() -> vOpTrue);

    public int energy = storage.getEnergyStored();

    public int getEnergy() {
        return energy;
    }

    IEnergyStorage targetStorage;

    public TileEnergySimple(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public TileEnergySimple() {
        this(TileSimpleEntities.SIMPLE_ENERGY_TILE.get());
    }


    @Override
    public CompoundNBT save(CompoundNBT compoundNBT) {
        super.save(compoundNBT);
        this.storage.save(compoundNBT);
        return compoundNBT;
    }

    @Override
    public void load(BlockState blockState, CompoundNBT compoundNBT) {
        super.load(blockState, compoundNBT);
        this.storage.load(compoundNBT);
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

        System.out.println("cap = " + cap);

        if (cap == CapabilityEnergy.ENERGY) {
            System.out.println("ExEnergy");
            return energyStorage.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public void tick() {

//        if (energyStorage.isPresent()) {
//            SimpleEnergyStorage simpleEnergyStorage = energyStorage.resolve().get();
//            simpleEnergyStorage.extractEnergy(100, false);
//            System.out.println("energyStorage:" + simpleEnergyStorage.getEnergyStored());
//            simpleEnergyStorage.save(compound);
//        }
//        storage.load(compound);


//            if (targetStorage.canExtract()) {
//                System.out.println("getEnergyStored : " + targetStorage.getEnergyStored());
//                System.out.println("canExtract: " + targetStorage.canExtract());
//                System.out.println("canReceive: " + targetStorage.canReceive());
//            }
        //System.out.println("getEnergyStored: " + storage.getEnergyStored());
        //System.out.println("getMaxEnergyStored: " + storage.getMaxEnergyStored());

    }

}

