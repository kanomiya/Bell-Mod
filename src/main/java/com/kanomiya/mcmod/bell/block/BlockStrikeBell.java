/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell.block;

import com.kanomiya.mcmod.bell.BellMod;
import com.kanomiya.mcmod.bell.BellModSounds;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
public class BlockStrikeBell extends BlockHorizontal implements IBell {

    public BlockStrikeBell() {
        super(Material.PISTON);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setRegistryName(new ResourceLocation(BellMod.MODID, "strike_bell"));
        setUnlocalizedName(BellMod.MODID + ".strike_bell");
        setLightOpacity(0);
        translucent = true;
        useNeighborBrightness = true;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.getBlock() != this ? state : state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack heldItem = playerIn.getHeldItem(hand);

        if (!heldItem.isEmpty() && heldItem.getItem() == Items.STICK) {
            BlockPos frontPos = pos.offset(worldIn.getBlockState(pos).getValue(BlockHorizontal.FACING));

            worldIn.playSound(playerIn, pos, getBellSound(), SoundCategory.RECORDS, 3f, 1f);
            worldIn.spawnParticle(EnumParticleTypes.NOTE, pos.getX() +.5d, pos.getY() +.5d, pos.getZ() +.5d, .5d, 0, 0);
            return true;
        }

        return false;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public SoundEvent getBellSound() {
        return BellModSounds.SOUND_STRIKE_BELL;
    }
}
