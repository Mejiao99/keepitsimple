package com.mejiao.keepitsimple.common.block.wire;

import com.mejiao.keepitsimple.common.tile.TileSimpleEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WireTileEntity extends TileEntity {
    int energyStored;

    public WireTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public WireTileEntity() {
        this(TileSimpleEntities.Wire_Tile_Entity.get());
    }

    @Override
    public void load(BlockState state, CompoundNBT compound) {
        this.energyStored = compound.getInt("EnergyStored");
        super.load(state, compound);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.putInt("EnergyStored", energyStored);
        return super.save(compound);
    }

    @Override
    public void setRemoved() {
        if (level != null) {
            WireNetworkManager.invalidateNetwork(level, worldPosition);
        }
        super.setRemoved();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (level != null && !remove && cap == CapabilityEnergy.ENERGY && side != null) {
            LazyOptional<WireNetwork> networkOptional = WireNetworkManager.getLazy(level, worldPosition);
            if (networkOptional.isPresent()) {
                return networkOptional.orElseThrow(IllegalStateException::new).getConnection(worldPosition, side).getLazyOptional().cast();
            }
        }
        return LazyOptional.empty();
    }
}
