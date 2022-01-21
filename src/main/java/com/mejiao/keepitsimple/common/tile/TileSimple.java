package com.mejiao.keepitsimple.common.tile;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileSimple extends TileEntity {
    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public TileSimple(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public TileSimple() {
        this(TileSimpleEntities.SIMPLE_TILE.get());
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        itemHandler.deserializeNBT(serializeNBT().getCompound("inv"));
        super.load(p_230337_1_, p_230337_2_);
    }

    @Override
    public CompoundNBT save(CompoundNBT p_189515_1_) {
        p_189515_1_.put("inv", itemHandler.serializeNBT());
        return super.save(p_189515_1_);
    }


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(2) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return false;
            }

            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {

                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };


    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }


}
