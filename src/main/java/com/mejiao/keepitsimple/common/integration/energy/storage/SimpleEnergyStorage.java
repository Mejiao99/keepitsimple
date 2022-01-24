package com.mejiao.keepitsimple.common.integration.energy.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.energy.EnergyStorage;

public class SimpleEnergyStorage extends EnergyStorage {
    public SimpleEnergyStorage(int capacity) {
        this(capacity, capacity, capacity, 0);
    }

    public SimpleEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer, maxTransfer, 0);
    }

    public SimpleEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract, 0);
    }

    public SimpleEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return super.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return super.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return super.getEnergyStored();
    }

    @Override
    public boolean canExtract() {
        return super.canExtract();
    }

    @Override
    public boolean canReceive() {
        return super.canReceive();
    }

    public void load(CompoundNBT compoundNBT) {
        this.energy = compoundNBT.getInt("Energy");
        this.capacity = compoundNBT.getInt("Capacity");
        this.maxReceive = compoundNBT.getInt("MaxReceive");
        this.maxExtract = compoundNBT.getInt("maxExtract");
    }

    public void save(CompoundNBT compoundNBT) {
        compoundNBT.putInt("Energy", this.energy);
        compoundNBT.putInt("Capacity", this.capacity);
        compoundNBT.putInt("MaxReceive", this.maxReceive);
        compoundNBT.putInt("MaxExtract", this.maxExtract);

    }


}
