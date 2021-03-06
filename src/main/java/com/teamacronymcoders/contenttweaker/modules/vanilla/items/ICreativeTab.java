package com.teamacronymcoders.contenttweaker.modules.vanilla.items;

import minetweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenClass("mods.contenttweaker.CreativeTab")
public interface ICreativeTab {
    @ZenGetter("unlocalizedName")
    String getUnlocalizedName();

    @ZenSetter("unlocalizedName")
    void setUnlocalizedName(String unlocalizedName);

    @ZenGetter("iconStack")
    IItemStack getIconStack();

    @ZenSetter("iconStack")
    void setIconStack(IItemStack iconStack);

    @ZenMethod
    void register();

    Object getInternal();
}
