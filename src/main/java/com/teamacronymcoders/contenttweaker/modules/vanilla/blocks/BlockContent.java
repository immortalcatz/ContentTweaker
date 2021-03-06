package com.teamacronymcoders.contenttweaker.modules.vanilla.blocks;

import com.teamacronymcoders.base.blocks.BlockBase;
import com.teamacronymcoders.contenttweaker.api.wrappers.blockpos.MCBlockPos;
import com.teamacronymcoders.contenttweaker.api.wrappers.blockstate.MCBlockState;
import com.teamacronymcoders.contenttweaker.api.wrappers.world.MCWorld;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.CreativeTab;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockContent extends BlockBase {
    private BlockRepresentation blockRepresentation;

    private CreativeTabs creativeTab;

    public BlockContent(BlockRepresentation blockRepresentation) {
        super(blockRepresentation.getInternalBlockMaterial(), blockRepresentation.getUnlocalizedName());
        this.blockRepresentation = blockRepresentation;
        setFields();
    }

    public void setFields() {
        this.setUnlocalizedName(this.blockRepresentation.getUnlocalizedName());
        this.setCreativeTab(this.blockRepresentation.getInternalCreativeTab());
        this.setLightOpacity(this.blockRepresentation.getLightOpacity());
        this.setLightLevel(this.blockRepresentation.getLightValue());
        this.setHardness(this.blockRepresentation.getBlockHardness());
        this.setResistance(this.blockRepresentation.getBlockResistance());
        this.setHarvestLevel(this.blockRepresentation.getToolClass(), this.blockRepresentation.getToolLevel());
        this.setSoundType(this.blockRepresentation.getInternalBlockSoundType());
        this.slipperiness = this.blockRepresentation.getSlipperiness();
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTabToDisplayOn() {
        return this.getCreativeTab();
    }

    public CreativeTabs getCreativeTab() {
        return this.creativeTab;
    }

    @Override
    @Nonnull
    public Block setCreativeTab(@Nonnull CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }

    @Override
    public float getEnchantPowerBonus(@Nonnull World world, @Nonnull BlockPos pos) {
        return this.blockRepresentation.getEnchantPowerBonus();
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state) {
        return this.blockRepresentation.getInternalBlockRenderType();
    }

    @Override
    @SideOnly(Side.CLIENT)
    @Nonnull
    public BlockRenderLayer getBlockLayer() {
        return this.blockRepresentation.getInternalBlockLayer();
    }

    @Override
    public void onBlockAdded(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        super.onBlockAdded(world, pos, state);
        if (this.blockRepresentation.getOnBlockAdded() != null) {
            this.blockRepresentation.getOnBlockAdded().onBlockAction(new MCWorld(world), new MCBlockPos(pos), new MCBlockState(state));
        }
    }

    @Override
    public void breakBlock(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        super.breakBlock(world, pos, state);
        if (this.blockRepresentation.getOnBlockBreak() != null) {
            this.blockRepresentation.getOnBlockBreak().onBlockAction(new MCWorld(world), new MCBlockPos(pos), new MCBlockState(state));
        }
    }
}
