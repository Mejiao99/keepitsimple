package com.mejiao.keepitsimple.api;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum ConnectionType implements IStringSerializable {
    NONE,
    BOTH;


    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public boolean canReceive() {
        return this == BOTH;
    }

    public boolean canExtract() {
        return this == BOTH;
    }
}
