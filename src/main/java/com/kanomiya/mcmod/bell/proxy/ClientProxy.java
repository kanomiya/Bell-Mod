/*
 * Copyright (c) 2017 和宮 葵(Kanomiya Aoi)
 */

package com.kanomiya.mcmod.bell.proxy;

import com.kanomiya.mcmod.bell.client.render.TESRStrikeStick;
import com.kanomiya.mcmod.bell.tileentity.TileEntityStrikeStick;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import static com.kanomiya.mcmod.bell.BellModItems.*;

/**
 * Created by Kanomiya in 2017/03.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void init() {
        super.init();

        ModelLoader.setCustomModelResourceLocation(ITEM_CLAPPER_BELL, 0, new ModelResourceLocation(ITEM_CLAPPER_BELL.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_STRIKE_BELL, 0, new ModelResourceLocation(ITEM_STRIKE_BELL.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_STRIKE_STICK, 0, new ModelResourceLocation(ITEM_STRIKE_STICK.getRegistryName(), "inventory"));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStrikeStick.class, new TESRStrikeStick());

    }
}
