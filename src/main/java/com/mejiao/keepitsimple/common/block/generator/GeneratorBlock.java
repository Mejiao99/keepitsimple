package com.mejiao.keepitsimple.common.block.generator;

import com.mejiao.keepitsimple.common.tile.TileSimpleEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class GeneratorBlock extends Block {
    public GeneratorBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileSimpleEntities.GENERATOR_ENTITY.get().create();
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

}
