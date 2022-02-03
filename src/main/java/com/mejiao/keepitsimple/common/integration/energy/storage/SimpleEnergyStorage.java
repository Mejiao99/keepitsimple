package com.mejiao.keepitsimple.common.integration.energy.storage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.energy.EnergyStorage;

public class SimpleEnergyStorage extends EnergyStorage {

    public SimpleEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
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
