package com.teamacronymcoders.contenttweaker.api.wrappers.world;

import com.teamacronymcoders.contenttweaker.api.wrappers.blockpos.IBlockPos;
import minetweaker.api.block.IBlock;
import minetweaker.api.world.IBiome;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.contenttweaker.World")
public interface IWorld {
    @ZenMethod
    boolean isRemote();

    @ZenMethod
    boolean isRaining();

    @ZenMethod
    boolean isThundering();

    @ZenMethod
    boolean setBlockState(IBlock blockState, IBlockPos blockPos);

    @ZenMethod
    IBiome getBiome(IBlockPos blockPos);

    @ZenMethod
    int getMoonPhase();

    @ZenMethod
    boolean isDayTime();

    @ZenMethod
    long getWorldTime();

    @ZenMethod
    String getWorldType();

    @ZenMethod
    int getDimension();

    @ZenMethod
    boolean isSurfaceWorld();

    @ZenMethod
    String getDimensionType();

    Object getInternal();
}
