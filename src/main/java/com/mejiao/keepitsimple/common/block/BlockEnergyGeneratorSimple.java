package com.mejiao.keepitsimple.common.block;

import com.mejiao.keepitsimple.common.tile.TileSimpleEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockEnergyGeneratorSimple extends Block {

    public BlockEnergyGeneratorSimple(Properties properties) {
        super(properties);
    }



    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileSimpleEntities.SIMPLE_ENERGY_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


}


