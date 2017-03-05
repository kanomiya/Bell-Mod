/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell.tileentity;

import com.kanomiya.mcmod.bell.block.IBell;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
public class TileEntityStrikeStick extends TileEntity implements ITickable {
    private static final double G = 9.8d;
    private static final double LOPE_LENGTH = .25d;
    private static final double OMEGA = Math.sqrt(G / LOPE_LENGTH);

    int reflectCount;
    double displacement; // rad /|\

    public TileEntityStrikeStick() {
        reflectCount = 7; // stop init
    }

    @Override
    public void update() {
        if (reflectCount > 6) {
            displacement = 0;
        }
        else {
            double damping = Math.pow(reflectCount + 1, 1.75d);
            double amplitude = getAmplitude() / damping;
            double omega = OMEGA / damping;
            boolean clockwise = reflectCount % 2 != 0;

            displacement += (clockwise ? -1 : 1) * omega;

            boolean pHit = getAmplitude() < displacement;
            boolean pLimit = !clockwise && amplitude < displacement;
            boolean nLimit = clockwise && displacement < -amplitude;

            if (pLimit || nLimit) {
                reflectCount++;

                if (pLimit)
                    displacement = amplitude;
                else
                    displacement = -amplitude;
            }

            if (pHit) {
                BlockPos frontPos = pos.offset(world.getBlockState(pos).getValue(BlockHorizontal.FACING));
                Block frontBlock = world.getBlockState(frontPos).getBlock();

                if (frontBlock instanceof IBell) {
                    world.playSound(null, frontPos, ((IBell) frontBlock).getBellSound(), SoundCategory.RECORDS, 3f, 1f);
                    world.spawnParticle(EnumParticleTypes.NOTE, frontPos.getX() +.5d, frontPos.getY() +.5d, frontPos.getZ() +.5d, .5d, 0, 0);
                }
            }
        }

    }

    public double getAmplitude() {
        return 45d;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        final double amplitude = Math.abs(getAmplitude());
        this.displacement = Math.max(Math.min(displacement, amplitude), -amplitude);
        reflectCount = 0;
    }

    public void resetDisplacement() {
        setDisplacement(-Math.abs(getAmplitude()));
    }

    public void pull(double amount) {
        push(-amount);
    }

    public void push(double amount) {
        setDisplacement(displacement + amount);
    }

}
