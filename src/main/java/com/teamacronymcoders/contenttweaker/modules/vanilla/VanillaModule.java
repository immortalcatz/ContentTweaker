package com.teamacronymcoders.contenttweaker.modules.vanilla;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.contenttweaker.api.wrappers.biome.ICTBiome;
import com.teamacronymcoders.contenttweaker.api.wrappers.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.wrappers.blockstate.ICTBlockState;
import com.teamacronymcoders.contenttweaker.api.wrappers.world.IWorld;
import com.teamacronymcoders.contenttweaker.modules.vanilla.blocks.IBlock;
import com.teamacronymcoders.contenttweaker.modules.vanilla.functions.IBlockAction;
import com.teamacronymcoders.contenttweaker.modules.vanilla.functions.IItemRightClick;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ICreativeTab;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.IItem;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.BlockBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.creativetab.CreativeTabBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundEventBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.utils.commands.Commands;
import minetweaker.MineTweakerAPI;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.teamacronymcoders.contenttweaker.ContentTweaker.MOD_ID;

@Module(MOD_ID)
public class VanillaModule extends ModuleBase {
    @Override
    public String getName() {
        return "Vanilla CraftTweaker";
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        MineTweakerAPI.registerBracketHandler(new MaterialBracketHandler());
        MineTweakerAPI.registerBracketHandler(new CreativeTabBracketHandler());
        MineTweakerAPI.registerBracketHandler(new SoundEventBracketHandler());
        MineTweakerAPI.registerBracketHandler(new SoundTypeBracketHandler());
        MineTweakerAPI.registerBracketHandler(new BlockBracketHandler());

        MineTweakerAPI.registerClass(ICTBiome.class);
        MineTweakerAPI.registerClass(IWorld.class);
        MineTweakerAPI.registerClass(IBlockPos.class);
        MineTweakerAPI.registerClass(ICTBlockState.class);

        MineTweakerAPI.registerClass(IItemRightClick.class);
        MineTweakerAPI.registerClass(IBlockAction.class);

        MineTweakerAPI.registerClass(ICreativeTab.class);
        MineTweakerAPI.registerClass(IBlock.class);
        MineTweakerAPI.registerClass(IItem.class);
        MineTweakerAPI.registerClass(VanillaFactory.class);
        MineTweakerAPI.registerClass(Commands.class);
    }
}
