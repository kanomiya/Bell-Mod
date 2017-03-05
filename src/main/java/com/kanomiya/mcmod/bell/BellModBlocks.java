/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell;

import com.kanomiya.mcmod.bell.block.BlockClapperBell;
import com.kanomiya.mcmod.bell.block.BlockStrikeBell;
import com.kanomiya.mcmod.bell.block.BlockStrikeStick;
import com.kanomiya.mcmod.bell.tileentity.TileEntityStrikeStick;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.kanomiya.mcmod.bell.BellMod.MODID;

/**
 * Created by 和宮 葵(Kanomiya) in 2017/03.
 */
@Mod.EventBusSubscriber(modid = BellMod.MODID)
public class BellModBlocks {
    public static final BlockClapperBell CLAPPER_BELL = new BlockClapperBell();
    public static final BlockStrikeBell STRIKE_BELL = new BlockStrikeBell();
    public static final BlockStrikeStick STRIKE_STICK = new BlockStrikeStick();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                CLAPPER_BELL,
                STRIKE_BELL,
                STRIKE_STICK
        );

        GameRegistry.registerTileEntity(TileEntityStrikeStick.class, new ResourceLocation(MODID, "strike_stick").toString());
    }

}
