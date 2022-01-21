package com.mejiao.keepitsimple.common.tile;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.energy.EnergyStorage;

public class TileGeneratorSimple extends TileEntity implements ITickableTileEntity {
    private EnergyStorage storage = new EnergyStorage(10000);

    public TileGeneratorSimple(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    @Override
    public void tick() {

    }
}
