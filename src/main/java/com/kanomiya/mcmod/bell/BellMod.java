/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell;

import com.kanomiya.mcmod.bell.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Kanomiya in 2017/03.
 */
@Mod(modid = BellMod.MODID, name = BellMod.MODNAME, version = BellMod.VERSION)
public class BellMod {
    public static final String MODID = "com.kanomiya.mcmod.bell";
    public static final String MODNAME = "Bell Mod";
    public static final String VERSION = "0.1.0";

    @Mod.Instance(MODID)
    public static BellMod INSTANCE;

    @SidedProxy(clientSide = MODID + ".proxy.ClientProxy", serverSide = MODID + ".proxy.CommonProxy", modId = MODID)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.init();
    }

}
