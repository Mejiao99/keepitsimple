package com.mejiao.keepitsimple.common.block.generator;

import com.mejiao.keepitsimple.common.block.IEnergyHandler;
import com.mejiao.keepitsimple.common.capability.EnergyStorageImpl;
import com.mejiao.keepitsimple.common.tile.TileSimpleEntities;
import com.mejiao.keepitsimple.util.EnergyUtils;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GeneratorTileEntity extends TileEntity implements IEnergyHandler, ITickableTileEntity {
    protected final EnergyStorageImpl energy = new EnergyStorageImpl(1000, 10, 50, this);
    private final LazyOptional<EnergyStorageImpl> energyStorage = LazyOptional.of(() -> energy);

    @Override
    public EnergyStorageImpl getEnergyImpl() {
        return energy;

    }

    int energyStored;

    public GeneratorTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public GeneratorTileEntity() {
        this(TileSimpleEntities.GENERATOR_ENTITY.get());
    }

//    @Override
//    public void load(BlockState state, CompoundNBT compound) {
//        this.energyStored = compound.getInt("EnergyStored");
//        super.load(state, compound);
//    }
//
//    @Override
//    public CompoundNBT save(CompoundNBT compound) {
//        compound.putInt("EnergyStored", energyStored);
//        return super.save(compound);
//    }
//
//    @Override
//    public void setRemoved() {
//        if (level != null) {
//            WireNetworkManager.invalidateNetwork(level, worldPosition);
//        }
//        super.setRemoved();
//    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

        if (level != null && !remove && cap == CapabilityEnergy.ENERGY && side != null) {
            return energyStorage.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public void tick() {
        energy.createEnergy(50);
        if (energy.canExtract()) {
            EnergyUtils.trySendToNeighbors(level, getBlockPos(), this, 10);
        }
    }


}
